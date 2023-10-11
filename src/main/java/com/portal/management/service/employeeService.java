package com.portal.management.service;

import com.portal.management.dao.employeeDao;
import com.portal.management.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class employeeService {

    @Autowired
    employeeDao employeeDao;
    public ResponseEntity<List<employee>> getEmployees() {
        try {
            return new ResponseEntity<>(employeeDao.findAll(), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<employee>> getEmployeeById(Integer id) {
        try {
            return new ResponseEntity<>(employeeDao.findByEmployeeId(id), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addEmployee(employee employee) {
        try {
            employeeDao.save(employee);
            return new ResponseEntity<>("Successfully added new employee", HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteEmployee(Integer id) {
        try {
            employeeDao.deleteById(id);
            return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
    }
}
