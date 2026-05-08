package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name, address, phone;
    private List<Vehicle> inventory;
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
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> results = new ArrayList<>();

        for (Vehicle newVehicle : inventory) {
            if (newVehicle.getPrice() >= min && newVehicle.getPrice() <= max) {
                results.add(newVehicle);
            }
        }
        return results;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> results = new ArrayList<>();

        for (Vehicle newVehicle : inventory) {
            boolean matchesMake = newVehicle.getMake().equalsIgnoreCase(make);
            boolean matchesModel = newVehicle.getModel().equalsIgnoreCase(model);

            if (matchesMake && matchesModel) {
                results.add(newVehicle);
            }
        }
        return results;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> results = new ArrayList<>();

        for (Vehicle newVehicle : inventory) {
            if (newVehicle.getYear() >= min && newVehicle.getYear() <= max) {
                results.add(newVehicle);
            }
        }
        return results;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> results = new ArrayList<>();

        for (Vehicle newVehicle : inventory) {
            if (newVehicle.getColor().equalsIgnoreCase(color)) {
                results.add(newVehicle);
            }
        }
        return results;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> results = new ArrayList<>();

        for (Vehicle newVehicle : inventory) {
            if (newVehicle.getOdometer() >= min && newVehicle.getOdometer() <= max) {
                results.add(newVehicle);
            }
        }

        return results;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> results = new ArrayList<>();

        for (Vehicle newVehicle : inventory) {
            if (newVehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                results.add(newVehicle);
            }
        }

        return results;
    }

    public List<Vehicle> getAllVehicles() {
        return this.inventory;
    }

    public void addVehicle(Vehicle newVehicle) {
        inventory.add(newVehicle);
    }
// changed because previous method signature was too wordy, so this is the cleaner simplified version.
    public void removeVehicle(int vin) {
        Vehicle toRemove = null;

        for (Vehicle v : inventory) {
            if (v.getVin() == vin) {
                toRemove = v;
                break;
            }
        }

        if (toRemove != null) {
            inventory.remove(toRemove);
        }
    }
}
