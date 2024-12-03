package br.com.carstore.servlet;

import br.com.carstore.dao.CarDao;
import br.com.carstore.model.Car;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.fileupload.servlet.ServletFileUpload.isMultipartContent;

@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding(("UTF-8"));

       Map<String, String> parameters =  uploadImage(req);

        String carId = parameters.get("id");
        String carName = parameters.get("car-name");
        String brand = parameters.get("brand");
        String price = parameters.get("price");
        String year = parameters.get("year");
        String yearModel = parameters.get("year-model");
        String image = parameters.get("image");


        CarDao carDao = new CarDao();
        Car car = new Car(carId, carName, brand, price, year, yearModel, image);

        if (carId.isBlank()) {

            carDao.createCar(car);

        } else {

            carDao.updateCar(car);
        }

        resp.sendRedirect("/admin/find-all-cars");
    }

    private Map<String, String> uploadImage(HttpServletRequest httpServletRequest) {

        HashMap<String, String> parameters = new HashMap<>();

        if (isMultipartContent(httpServletRequest)) {

            try {

                DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

                List<FileItem> fileItems = new ServletFileUpload(diskFileItemFactory).parseRequest(httpServletRequest);

                for (FileItem item : fileItems) {

                    checkFieldType(item, parameters);
                }

            } catch (Exception ex) {

                parameters.put("image", "img/default-car.jpg");
            }

            return parameters;
        }
        return parameters;


    }

    private void checkFieldType(FileItem fileItem, Map requestParameters) throws Exception {

        if (fileItem.isFormField()) {

            requestParameters.put(fileItem.getFieldName(), fileItem.getString());

        } else {

            String fileName = processUploadedFile(fileItem);

            requestParameters.put("image", fileName);

        }

    }

    private String processUploadedFile(FileItem fileItem) throws Exception {

        Long currentTime = new Date().getTime();

        String fileName = currentTime.toString().concat("-").concat(fileItem.getName().replace(" ", ""));
        String filePath = this.getServletContext().getRealPath("img").concat(File.separator).concat(fileName);


        fileItem.write(new File(filePath));

        return fileName;

    }


}