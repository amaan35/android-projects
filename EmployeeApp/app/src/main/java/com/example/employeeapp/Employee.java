package com.example.employeeapp;

public class Employee {
    //Attributes
    private String employeeName;
    private String employeeID;
    private int employeeImage;

    public Employee(String employeeName, String employeeID, int employeeImage) {
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.employeeImage = employeeImage;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public int getEmployeeImage() {
        return employeeImage;
    }

    public void setEmployeeImage(int employeeImage) {
        this.employeeImage = employeeImage;
    }
}
