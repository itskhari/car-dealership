package com.pluralsight;


import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

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
                    processAllVehicleRequst();
                    break;
//                case "2":
//                    processGetByPriceRequest();
//                    break;
//                case "3":
//                    processGetByMakeModelRequest();
//                    break;
//                case "4":
//                    processGetByYearRequest();
//                    break;
//                case "5":
//                    processGetByColorRequest();
//                    break;
//                case "6":
//                    processGetByMileageRequest();
//                    break;
//                case "7":
//                    processGetByType();
//                    break;
//                case "8":
//                    processAddVehiclesRequest();
//                    break;
//                case "9":
//                    processRemoveVehiclesRequest();
//                    break;                                    doesn't have to be used yet but made just in case.
                case "0":
                    run = false;
                    break;
                default:
                    System.out.println("Invalid Choice, Please Select Again");

            }
        }
    }

    // methods
    private void init() {
        DealershipFileManager dfm = new DealershipFileManager();  // dfm stands for dealership file manager.
        this.dealership = dfm.getDealership();
    }
    private void displayVehicles(List<Vehicle> inventory) {
        for (Vehicle newVehicle : inventory) {
            System.out.println(newVehicle);
        }
    }
    private void processAllVehicleRequst() {
        List<Vehicle> inventory = dealership.getAllVehicles();
        displayVehicles(inventory);
    }

}
