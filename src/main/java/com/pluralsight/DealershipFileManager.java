package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

// methods
    public Dealership getDealership() {
        Dealership dealership = null;

        try {
            FileReader reader = new FileReader("inventory.csv");
            BufferedReader bufReader = new BufferedReader(reader);

            String firstline = bufReader.readLine();
            String [] parts = firstline.split(",");

            dealership = new Dealership(parts[0], parts[1], parts[2]);

            String line;

            while ((line = bufReader.readLine()) != null) {
                String [] vehicleParts = line.split(",");

                Vehicle newVehicle = new Vehicle(
                        vehicleParts[0], // make
                        vehicleParts[1], // model
                        vehicleParts[2], // color
                        vehicleParts[3], // vehicleType
                        Integer.parseInt(vehicleParts[4]), // year
                        Integer.parseInt(vehicleParts[5]), // vin
                        Integer.parseInt(vehicleParts[6]), // odometer
                        Double.parseDouble(vehicleParts[7]) // price
                );

                dealership.addVehicle(newVehicle);
            }
            bufReader.close();
        } catch (IOException e) {
            System.out.println("Could not load inventory");
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership) {

    }
}

