package com.hackathon.hackathon.repository;
import com.hackathon.hackathon.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee findByEmpid(String empid);
    List<Employee> findByDepartmentAndSalaryGreaterThan(String adminDepartment, double minSalary);
}
