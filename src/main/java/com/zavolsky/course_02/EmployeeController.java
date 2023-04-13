package com.zavolsky.course_02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService = new EmployeeService();

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String greetings() {
        return employeeService.greetings();
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam("name") String name, @RequestParam("familyName") String familyName) {
        return employeeService.add(name,familyName);
    }

    @GetMapping(path = "/show")
    public String show(@RequestParam("param") String param) {
        return employeeService.show(param);
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam("id") int id) {
        return employeeService.remove(id);
    }

    @GetMapping(path = "/search")
    public String searchById(@RequestParam("id") int id) {
        return employeeService.searchById(id);
    }
    /*public String searchByName(@RequestParam("name") String name) {
        return employeeService.searchByName(name);
    }
    public String searchByFName(@RequestParam("familyName") String familyName) {
        return employeeService.searchByFName(familyName);
    }
    public String searchByEmployee(@RequestParam("name") String name,@RequestParam("familyName") String familyName) {
        return employeeService.searchByEmployee(name,familyName);
    }*/
}
