package com.example.controller;

import com.example.model.Employee;
import com.example.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepo employeeRepoImpl;

    @GetMapping
    public ResponseEntity<String> hello() {

        return ResponseEntity.ok("Welocome To Fintech CSI");
    }

    @GetMapping("/listofemployee")
    public ResponseEntity<List<Employee>> getAllData() {

        return ResponseEntity.ok(employeeRepoImpl.findAll().stream().sorted(Comparator.comparing(Employee::getEmpName)).collect(Collectors.toList()));
    }
    @GetMapping("/userdata")
    public ResponseEntity<Principal> getUser(Principal principal) {

        return ResponseEntity.ok(principal);
    }

}
