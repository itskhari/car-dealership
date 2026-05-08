package com.pluralsight;


import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private DealershipFileManager fileManager = new DealershipFileManager();

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
}
