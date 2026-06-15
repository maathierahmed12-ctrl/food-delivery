package Entities;

import java.util.List;

public class Employee {
    private String id;
    private String name;
    private double Department;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
        this.Department = Department;
       
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
