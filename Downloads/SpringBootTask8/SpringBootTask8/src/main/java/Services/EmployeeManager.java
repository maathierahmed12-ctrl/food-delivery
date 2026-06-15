package Services;

import Entities.Employee;

import java.util.ArrayList;

public class EmployeeManager {

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("E101", "Sara"));
        employees.add(new Employee("E102", "Ahmed"));
        employees.add(new Employee("E103", "John"));

        System.out.println(" Existing Employees ");
        for (Employee e : employees) {
            System.out.println(e.getId() + " -> " + e.getName() +
                    " -> " + e.getId());
        }

        Employee newEmployee = new Employee("E104", "Ali");

        boolean exists = false;

        for (Employee e : employees) {
            if (e.getId().equalsIgnoreCase(newEmployee.getId())) {
                exists = true;
                break;
            }
        }

        if (!exists) {

            employees.add(newEmployee);

            System.out.println("Employee Added Successfully");
            System.out.println("Employee ID: " + newEmployee.getId());
            System.out.println("Employee Name: " + newEmployee.getName());
            System.out.println("Status: Created");

        } else {

            System.out.println("Employee ID already exists");
            System.out.println("No employee was created");
        }

        System.out.println("Updated Employee List ");
        for (Employee e : employees) {
            System.out.println(e.getId() + " -> " + e.getName() +
                    " -> " + e.getId());
        }
    }
}


