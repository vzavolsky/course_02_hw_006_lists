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
        return String.format("Employee %s %s was added.", name, familyName);
    }

    private boolean checkDuplicates(Employee employee) {
        for (Employee employeeListItem : this.employeeList) {
            if (employee.equals(employeeListItem)) {
                return true;
            }
        }
        return false;
    }

    public String show(String param) {
        switch (param) {
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

    public String remove(int id) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeID() == id) {
                employeeList.remove(employee);
                return String.format("%s %s with ID:%d was deleted", employee.getName(), employee.getFamilyName(), employee.getEmployeeID());
            }
        }
        return String.format("Employee with ID:%d wasn't founded.", id);
    }

    private String noResults() {
        return "Nothing was founded.";
    }

    public String searchById(int id) {
        for (Employee employee: employeeList) {
            if (employee.getEmployeeID() == id) {
                return employee.toString();
            }
        }
        return noResults();
    }

    /*public String searchByName(String name) {
        String res = "Was founded employees with name \"" + name + "\":";
        boolean founded = false;
        for (Employee employee: employeeList) {
            if (employee.getName().equals(name)) {
                res += "\n" + employee.toString();
            }
        }
        if (founded) {
            return res;
        }
        return noResults();
    }

    public String searchByFName(String familyName) {
        return "";
    }

    public String searchByEmployee(String name, String familyName) {
        return "";
    }*/
}
