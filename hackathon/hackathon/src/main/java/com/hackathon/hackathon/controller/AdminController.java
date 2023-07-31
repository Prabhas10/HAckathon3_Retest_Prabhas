package com.hackathon.hackathon.controller;

import com.hackathon.hackathon.exception.AdminAlreadyExistsException;
import com.hackathon.hackathon.model.Admin;
import com.hackathon.hackathon.model.Employee;
import com.hackathon.hackathon.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) throws AdminAlreadyExistsException {
        Admin savedAdmin = adminService.addAdmin(admin);
        return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> searchEmployeesByDepartmentAndSalary(@RequestParam String department,
            @RequestParam double minSalary
    ) {
        List<Employee> employees = adminService.searchEmployeesByDepartmentAndSalary(department, minSalary);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
