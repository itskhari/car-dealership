package com.pluralsight;

import java.io.*;

public class DealershipFileManager {

// methods
    public Dealership getDealership() {
        Dealership dealership = null;

        try {
            FileReader reader = new FileReader("src/main/resources/inventory.csv");
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

        try (
                FileWriter writer = new FileWriter("inventory.csv");
                BufferedWriter bufWriter = new BufferedWriter(writer)
        ) {
            bufWriter.write(dealership.getName() + "," +
                    dealership.getAddress() + "," +
                    dealership.getPhone());
            bufWriter.newLine();

            // Write each vehicle
            for (Vehicle newVehicle : dealership.getAllVehicles()) {
                bufWriter.write(
                        newVehicle.getMake() + "," +
                                newVehicle.getModel() + "," +
                                newVehicle.getColor() + "," +
                                newVehicle.getVehicleType() + "," +
                                newVehicle.getYear() + "," +
                                newVehicle.getVin() + "," +
                                newVehicle.getOdometer() + "," +
                                newVehicle.getPrice()
                );
                bufWriter.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving dealership");
        }

    }
}

