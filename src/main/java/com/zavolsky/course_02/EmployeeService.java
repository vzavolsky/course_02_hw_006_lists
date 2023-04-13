package com.zavolsky.course_02;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> employeeList = new ArrayList<>();

    public String greetings() {
        return "Hi";
    }

    public String add(String name, String familyName) {
        Employee employee = new Employee(name, familyName);
        if (checkDuplicates(employee)) {
            return String.format("Employee %s %s already exists in the list.", name, familyName);
        } else {
            this.employeeList.add(employee);
        }
        return employee.toJSON();
    }

    private boolean checkDuplicates(Employee employee) {
        for (Employee employeeListItem : this.employeeList) {
            if (employee.equals(employeeListItem)) {
                return true;
            }
        }
        return false;
    }

    public String show(String format) {
        if (format == null) {
            format = "";
        }
        switch (format) {
            case "json":
                return toJSON();
            default:
                return this.employeeList.toString();
        }
    }

    private String toJSON() {
        String res = "";
        for (Employee employee : employeeList) {
            res += employee.toJSON() + ",";
        }
        return "[" + res + "]";
    }

    public String remove(String name, String familyName) {
        for (Employee employee : employeeList) {
            if (employee.getName().equals(name) && employee.getFamilyName().equals(familyName)) {
                employeeList.remove(employee);
                return employee.toJSON();
            }
        }
        return noResults();
    }

    private String noResults() {
        return "Nothing was founded.";
    }

    public String find(String name, String familyName) {
        for (Employee employee : employeeList) {
            if (employee.getName().equals(name) && employee.getFamilyName().equals(familyName)) {
                return employee.toJSON();
            }
        }
        return noResults();
    }
}
