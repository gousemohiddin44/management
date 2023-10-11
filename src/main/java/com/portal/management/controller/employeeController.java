package com.portal.management.controller;

import com.portal.management.employee;
import com.portal.management.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class employeeController {

    @Autowired
    employeeService employeeService;
    @GetMapping("/employees")
    public ResponseEntity<List<employee>> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<List<employee>> getEmployees(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/add/employee")
    public ResponseEntity<String> addEmployee(@RequestBody employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/delete/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
        return employeeService.deleteEmployee(id);
    }

}
