package Entities;

public class Vehicle {


        private String vehicleId;
        private String vehicleModel;
        private double rentalPricePerDay;

        public Vehicle(String vehicleId, String vehicleModel, double rentalPricePerDay) {
            this.vehicleId = vehicleId;
            this.vehicleModel = vehicleModel;
            this.rentalPricePerDay = rentalPricePerDay;
        }

        public String getVehicleId() {
            return vehicleId;
        }

        public void setVehicleId(){
            this.vehicleId=vehicleId;
        }

        public String getVehicleModel() {
            return vehicleModel;
        }

        public void setVehicleModel(){
            this.vehicleModel=vehicleModel;
        }

        public double getRentalPricePerDay() {
            return rentalPricePerDay;
        }
        public void setRentalPricePerDay(){
            this.rentalPricePerDay=rentalPricePerDay;
        }
    }
