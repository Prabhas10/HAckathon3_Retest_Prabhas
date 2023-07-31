package com.hackathon.hackathon.service;

import com.hackathon.hackathon.exception.AdminAlreadyExistsException;
import com.hackathon.hackathon.model.Admin;
import com.hackathon.hackathon.model.Employee;

import java.util.List;

public interface AdminService {
    Admin addAdmin(Admin admin) throws AdminAlreadyExistsException;

    List<Employee> searchEmployeesByDepartmentAndSalary(String adminDepartment, double minSalary);
}