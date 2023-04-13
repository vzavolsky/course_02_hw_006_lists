package com.zavolsky.course_02;

import java.util.Objects;

public class Employee {
    private static int employeeIDinc = 0;
    private int employeeID = ++employeeIDinc;
    private String name;
    private String familyName;

    Employee(String name, String familyName) {
        this.employeeID = employeeID;
        this.name = name;
        this.familyName = familyName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public String toString() {
        return "{" +
                "employeeID = " + employeeID +
                ", name = '" + name + '\'' +
                ", familyName = '" + familyName + '\'' +
                '}';
    }

    public String toJSON() {
        return "{" +
                "\"id\":" + employeeID +
                ", \"name\":\"" + name + "\"" +
                ", \"fname\":\"" + familyName + "\"" +
                '}';
    }

    public boolean equals(Employee employee) {
        if (this.getName().equals(employee.getName()) && this.getFamilyName().equals(employee.getFamilyName())) {
            return true;
        }
        return false;
    }
}
