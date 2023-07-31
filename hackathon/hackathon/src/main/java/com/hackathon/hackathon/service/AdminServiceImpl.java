package com.hackathon.hackathon.service;

import com.hackathon.hackathon.exception.AdminAlreadyExistsException;
import com.hackathon.hackathon.model.Admin;
import com.hackathon.hackathon.model.Employee;
import com.hackathon.hackathon.repository.AdminRepository;
import com.hackathon.hackathon.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository, EmployeeRepository employeeRepository) {
        this.adminRepository = adminRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Admin addAdmin(Admin admin) throws AdminAlreadyExistsException {
        if (adminRepository.findByAdminuser(admin.getAdminuser()) != null) {
            throw new AdminAlreadyExistsException();
        }
        return adminRepository.save(admin);
    }

    @Override
    public List<Employee> searchEmployeesByDepartmentAndSalary(String adminDepartment, double minSalary) {
        return employeeRepository.findByDepartmentAndSalaryGreaterThan(adminDepartment, minSalary);
    }
}