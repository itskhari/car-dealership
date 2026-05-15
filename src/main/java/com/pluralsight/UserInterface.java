package com.pluralsight;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private DealershipFileManager fileManager = new DealershipFileManager();
    private List<Vehicle> inventory;

    Scanner sc = new Scanner(System.in);

    public void display() {
        init(); // this loads the dealership I believe, well it's calling on the method to do so.

        boolean run = true;

        while (run) {
            // display menu options
            System.out.println("1. List All Vehicles");
            System.out.println("2. Search by Price");
            System.out.println("3. Search by Make/Model");
            System.out.println("4. Search by Year");
            System.out.println("5. Search by Color");
            System.out.println("6. Search by Mileage");
            System.out.println("7. Search by Type");
            System.out.println("8. Add Vehicle");
            System.out.println("9. Remove Vehicle");
            System.out.println("10. Sell/Lease a Vehicle");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();


            switch (choice) {
                case "1":
                    processAllVehicleRequest();
                    break;
                case "2":
                    processGetByPriceRequest();
                    break;
                case "3":
                    processGetByMakeModelRequest();
                    break;
                case "4":
                    processGetByYearRequest();
                    break;
                case "5":
                    processGetByColorRequest();
                    break;
                case "6":
                    processGetByMileageRequest();
                    break;
                case "7":
                    processGetByTypeRequest();
                    break;
                case "8":
                    processAddVehiclesRequest();
                    break;
                case "9":
                    processRemoveVehiclesRequest();
                    break;
                case "10":
                    SellLeaseVehicle();
                    break;
                case "0":
                    System.out.println("Exiting...");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid Choice, Please Select Again");

            }
        }
    }

    // methods
    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        // dfm stands for dealership file manager ; changed from dfm to file manager (static vs local variable)
        this.dealership = fileManager.getDealership();
    }

    private void displayVehicles(List<Vehicle> inventory) {
        for (Vehicle newVehicle : inventory) {
            System.out.println(newVehicle);
        }
    }

    private void processAllVehicleRequest() {
        List<Vehicle> inventory = dealership.getAllVehicles();
        displayVehicles(inventory);
    }

    public void processGetByPriceRequest() {
        System.out.print("Enter minimum price: ");
        double min = Double.parseDouble(sc.nextLine());

        System.out.print("Enter maximum price: ");
        double max = Double.parseDouble(sc.nextLine());

        List<Vehicle> results = dealership.getVehiclesByPrice(min, max);
        displayVehicles(results);
    }

    public void processGetByMakeModelRequest() {
        System.out.print("Enter make: ");
        String make = sc.nextLine();

        System.out.print("Enter model: ");
        String model = sc.nextLine();

        List<Vehicle> results = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(results);
    }

    public void processGetByYearRequest() {
        System.out.print("Enter minimum year: ");
        int min = Integer.parseInt(sc.nextLine());

        System.out.print("Enter maximum year: ");
        int max = Integer.parseInt(sc.nextLine());

        List<Vehicle> results = dealership.getVehiclesByYear(min, max);
        displayVehicles(results);
    }

    public void processGetByColorRequest() {
        System.out.print("Enter color: ");
        String color = sc.nextLine();

        List<Vehicle> results = dealership.getVehiclesByColor(color);
        displayVehicles(results);
    }

    public void processGetByMileageRequest() {
        System.out.print("Enter minimum mileage: ");
        int min = Integer.parseInt(sc.nextLine());

        System.out.print("Enter maximum mileage: ");
        int max = Integer.parseInt(sc.nextLine());

        List<Vehicle> results = dealership.getVehiclesByMileage(min, max);
        displayVehicles(results);
    }

    public void processGetByTypeRequest() {
        System.out.print("Enter vehicle type (Car, Truck, SUV, etc.): ");
        String type = sc.nextLine();

        List<Vehicle> results = dealership.getVehiclesByType(type);
        displayVehicles(results);
    }

    public void processAddVehiclesRequest() {
        System.out.print("Enter make: ");
        String make = sc.nextLine();

        System.out.print("Enter model: ");
        String model = sc.nextLine();

        System.out.print("Enter color: ");
        String color = sc.nextLine();

        System.out.print("Enter vehicle type: ");
        String type = sc.nextLine();

        System.out.print("Enter year: ");
        int year = Integer.parseInt(sc.nextLine());

        System.out.print("Enter VIN: ");
        int vin = Integer.parseInt(sc.nextLine());

        System.out.print("Enter odometer: ");
        int odometer = Integer.parseInt(sc.nextLine());

        System.out.print("Enter price: ");
        double price = Double.parseDouble(sc.nextLine());

        Vehicle newVehicle = new Vehicle(
                make, model, color, type, year, vin, odometer, price
        );

        dealership.addVehicle(newVehicle);
        fileManager.saveDealership(dealership);

        System.out.println("Vehicle added successfully!");
    }

    public void processRemoveVehiclesRequest() {
        System.out.print("Enter VIN of vehicle to remove: ");
        int vin = Integer.parseInt(sc.nextLine());

        dealership.removeVehicle(vin);
        fileManager.saveDealership(dealership);

        System.out.println("Vehicle removed successfully!");
    }

    private static Vehicle findVehicle(List<Vehicle> inventory, int vin) {
        for (Vehicle newVehicle : inventory) {
            if (newVehicle.getVin() == vin) {
                return newVehicle;
            }
        }
        return null;
    }
    // this part was not me, due to rushing, i do know how to use a file/buffered reader
    //  i definitely do not format it as cleanly as it did so i need to review this later.
    private static void saveContract(Contract contract) {
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter("contracts.csv", true));

            if (contract instanceof SalesContract sc) {
                bw.write(String.format(
                        "SALE|%s|%s|%s|%s|%.2f|%.2f|%b",
                        sc.getDate(), sc.getName(), sc.getEmail(),
                        sc.getVehicle().getVin(),
                        sc.getTotalPrice(), sc.getMonthlyPay(),
                        sc.isFinanced()
                ));
                bw.newLine();

            } else if (contract instanceof LeaseContract lc) {
                bw.write(String.format(
                        "LEASE|%s|%s|%s|%s|%.2f|%.2f",
                        lc.getDate(), lc.getName(), lc.getEmail(),
                        lc.getVehicle().getVin(),
                        lc.getTotalPrice(), lc.getMonthlyPay()
                ));
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving contract: " + e.getMessage());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing writer: " + e.getMessage());
            }
        }
    }


    public void SellLeaseVehicle() {

        
        System.out.print("Please enter the VIN of desired vehicle: ");
        int vin = Integer.parseInt(sc.nextLine());

        Vehicle vehicle = findVehicle(inventory, vin);
        if (vehicle == null) {
            System.out.println("Vehicle not found");
            return;
        }

        System.out.print("Enter today's date (MM/DD/YYYY): ");
        String date = sc.nextLine();

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your email: ");
        String email = sc.nextLine();

        System.out.println("Sale or Lease (S/L): ");
        String choice = sc.nextLine().toUpperCase();

        Contract contract;

        if (choice.equals("S")) {
            System.out.print("Finance? (Y/N): ");
            boolean isFinanced = sc.nextLine().equalsIgnoreCase("y");
            contract = new SalesContract(date, name, email, vehicle, isFinanced);

        } else if (choice.equals("L")) {
            int currentYear = LocalDate.now().getYear();
            if ((currentYear - vehicle.getYear()) > 3) {
                System.out.println("Cannot lease vehicle over 3 years old");
                return;
            }
            contract = new LeaseContract(date, name, email, vehicle);
        } else {
            System.out.println("Invalid option");
            return;
        }
        saveContract(contract);
        System.out.println("Contract saved successfully.");
    }
}
