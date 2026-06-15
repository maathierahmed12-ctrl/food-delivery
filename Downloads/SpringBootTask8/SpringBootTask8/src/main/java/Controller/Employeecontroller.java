package Controller;

import Entities.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class Employeecontroller {

    @RestController
    @RequestMapping("/employees")
    public class EmployeeController {

        private final Employeecontroller employeeManager;

        public EmployeeController(Employeecontroller employeeManager) {
            this.employeeManager = employeeManager;
        }

        @PostMapping("/add")
        public String addEmployee(@RequestBody Employee employee) {

            return employeeManager.addEmployee(employee);
        }

        @GetMapping
        public List<Employee> getAllEmployees() {

            return employeeManager.getAllEmployees();
        }
    }

    private List<Employee> getAllEmployees() {
        return List.of();
    }
    private String addEmployee(Employee employee) {
        return null;
    }
}
