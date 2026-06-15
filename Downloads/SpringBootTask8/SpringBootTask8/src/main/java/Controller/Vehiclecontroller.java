package Controller;

import Entities.Vehicle;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")

public class Vehiclecontroller {


        private Vehiclecontroller vehicleManager;

    public Vehiclecontroller(Vehiclecontroller vehicleManager) {
        this.vehicleManager = vehicleManager;
    }

    public void VehicleController(Vehiclecontroller vehicleManager) {

            this.vehicleManager = vehicleManager;
        }

        @PostMapping("/add")
        public String addVehicle(@RequestBody Vehicle vehicle) {
            return vehicleManager.addVehicle(vehicle);
        }

        @GetMapping
        public void displayVehicles() {
            vehicleManager.displayVehicles();
        }
    }