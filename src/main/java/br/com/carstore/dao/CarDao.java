package br.com.carstore.dao;

import br.com.carstore.config.ConnectionPoolConfig;
import br.com.carstore.model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarDao {

    public void createCar(Car car) {

        String SQL = "INSERT INTO CAR (NAME, BRAND, PRICE, YEAR_, YEAR_MODEL, IMAGE) VALUES (?, ?, ?, ?, ?, ?)";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, car.getName());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setString(3, car.getPrice());
            preparedStatement.setString(4, car.getYear());
            preparedStatement.setString(5, car.getYearModel());
            preparedStatement.setString(6, car.getImage());
            preparedStatement.execute();

            System.out.println("success in insert car");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");
            System.out.println("Error: " + e.getMessage());

        }

    }

    public List<Car> findAllCars() {

        String SQL = "SELECT * FROM CAR";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Car> cars = new ArrayList<>();

            while (resultSet.next()) {
                String carId = resultSet.getString("ID");
                String carName = resultSet.getString("NAME");
                String brand = resultSet.getString("BRAND");
                String price = resultSet.getString("PRICE");
                String year = resultSet.getString("YEAR_");
                String yearModel = resultSet.getString("YEAR_MODEL");
                String image = resultSet.getString("IMAGE");

                Car car = new Car(carId, carName, brand, price, year, yearModel, image);
                cars.add(car);
            }

            System.out.println("success in select * car");

            connection.close();

            return cars;

        } catch (Exception e) {

            System.out.println("fail in database connection");
            System.out.println("Error: " + e.getMessage());

            return Collections.emptyList();

        }

    }

    public void deleteCarById(String carId) {

        String SQL = "DELETE CAR WHERE ID = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, carId);
            preparedStatement.execute();

            System.out.println("success on delete car with id: " + carId);

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }

    }

    public void updateCar(Car car) {
        String SQL = "UPDATE CAR SET NAME = ?, BRAND = ?, PRICE = ?, YEAR_ = ?, YEAR_MODEL = ?, IMAGE = ? WHERE ID = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, car.getName());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setString(3, car.getPrice());
            preparedStatement.setString(4, car.getYear());
            preparedStatement.setString(5, car.getYearModel());
            preparedStatement.setString(6, car.getImage());
            preparedStatement.setString(7, car.getId());
            preparedStatement.execute();

            System.out.println("Success in updating car");

            connection.close();

        } catch (Exception e) {
            System.out.println("Fail in updating car");
            System.out.println("Error: " + e.getMessage());
        }
    }

}

