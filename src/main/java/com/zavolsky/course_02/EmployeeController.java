package com.zavolsky.course_02;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/show")
    public String show(@RequestParam(required = false) String format) {
        return employeeService.show(format);
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam("name") String name,@RequestParam("familyName") String familyName) {
        return employeeService.remove(name,familyName);
    }

    @GetMapping(path = "/find")
    public String find(@RequestParam("name") String name,@RequestParam("familyName") String familyName) {
        return employeeService.find( name, familyName);
    }

}
