package br.com.carstore.model;

public class Car {

    private String id;
    private String name;
    private String image;
    private String brand;
    private String price;
    private String year;
    private String yearModel;



    public Car(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Car(String id, String name, String brand, String price, String year, String yearModel, String image) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.year = year;
        this.yearModel = yearModel;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getBrand() {
        return brand;
    }

    public String getPrice() {
        return price;
    }

    public String getYear() {
        return year;
    }

    public String getYearModel() {
        return yearModel;
    }
}
