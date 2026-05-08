package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name, address, phone;
    private ArrayList<Vehicle> inventory;
    // you did this because every dealership would need an inventory list; it would need to be a field.

// constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;

        inventory = new ArrayList<Vehicle>();
        // you did this because when a new dealership object is made you want it to make its own new list to store variables
    }
// getters and setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
// methods
    public List<Vehicle> getVehiclesByPrice (double min, double max) {
        return null;
    }
    public List<Vehicle> getVehiclesByMakeModel (String make, String model) {
        return null;
    }
    public List<Vehicle> getVehiclesByYear (int min, int max) {
        return null;
    }
    public List<Vehicle> getVehiclesByColor (String color) {
        return null;
    }
    public List<Vehicle> getVehiclesByMileage (int min, int max) {
        return null;
    }
    public List<Vehicle> getVehiclesByType (String vehicleType) {
        return null;
    }
    public void addVehicle(Vehicle newVehicle) {
        inventory.add(newVehicle);
    }
    public void removeVehicle(Vehicle vehicleToRemove) {
        // supposed to be empty for now I believe
    }
}
