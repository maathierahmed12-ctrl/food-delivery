package Services;

import Entities.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleManager {

    private List<Vehicle> vehicles;

        public void VehicleManager() {

            vehicles = new ArrayList<>();

            vehicles.add(new Vehicle("V101", "Toyota Corolla", 20.0));
            vehicles.add(new Vehicle("V102", "Nissan Sunny", 18.0));
            vehicles.add(new Vehicle("V103", "Hyundai Elantra", 22.0));
        }

        public String addVehicle(Vehicle vehicle) {

            for (Vehicle v : vehicles) {

                if (v.getVehicleId().equalsIgnoreCase(vehicle.getVehicleId())) {
                    return "Vehicle ID already exists No vehicle was added";
                }
            }

            vehicles.add(vehicle);

            return "Vehicle Added Successfully" +
                    "Vehicle ID: " + vehicle.getVehicleId() + ".." +
                    "Vehicle Model: " + vehicle.getVehicleModel() + "..." +
                    "Rental Price Per Day: " + vehicle.getRentalPricePerDay() + " OMR" +
                    "Status: Created";
        }

        public void displayVehicles() {

            System.out.println("\nUpdated Vehicle List:");

            for (Vehicle v : vehicles) {
                System.out.println(
                        v.getVehicleId() +
                                " -> " +
                                v.getVehicleModel() +
                                " -> " +
                                v.getRentalPricePerDay() +
                                " OMR/day"
                );
            }
        }
    }

