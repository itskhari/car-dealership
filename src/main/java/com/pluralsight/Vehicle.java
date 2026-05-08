package com.pluralsight;

public class Vehicle {
    private String make, model, color, vehicleType;
    private int year, vin, odometer;
    private double price;

// constructor
    public Vehicle(String make, String model, String color, String vehicleType, int year, int vin, int odometer, double price) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.vehicleType = vehicleType;
        this.year = year;
        this.vin = vin;
        this.odometer = odometer;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "{Make: " + make + '\'' +
                ", Model: " + model + '\'' +
                ", Color: " + color + '\'' +
                ", Type: " + vehicleType + '\'' +
                ", Year: " + year +
                ", VIN #: " + vin +
                ", Odometer: " + odometer +
                ", Price: " + price +
                '}';
    }

    // getter and setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
