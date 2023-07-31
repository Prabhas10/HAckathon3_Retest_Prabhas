package com.hackathon.hackathon.service;

import com.hackathon.hackathon.exception.EmployeeAlreadyExistsException;
import com.hackathon.hackathon.model.Employee;
import com.hackathon.hackathon.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) throws EmployeeAlreadyExistsException{
        if (employeeRepository.findByEmpid(employee.getEmpid()) != null) {
            throw new EmployeeAlreadyExistsException();
        }
        return employeeRepository.save(employee);
    }
}