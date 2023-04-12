package com.zavolsky.course_02;

import java.util.Objects;

public class Employee {
    private static int employeeIDinc = 0;
    private int employeeID = ++employeeIDinc;
    private String name;
    private String familyName;

    Employee() {
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
        return "Employee {" +
                "employeeID = " + employeeID +
                ", name = '" + name + '\'' +
                ", familyName = '" + familyName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeID == employee.employeeID && Objects.equals(name, employee.name) && Objects.equals(familyName, employee.familyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID, name, familyName);
    }
}
