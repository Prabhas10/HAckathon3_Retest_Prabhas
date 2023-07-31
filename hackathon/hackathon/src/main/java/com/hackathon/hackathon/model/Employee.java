package com.hackathon.hackathon.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Employee {
    @Id
    private String empid;
    private String empname;

    @Override
    public String toString() {
        return "Employee{" +
                "empid='" + empid + '\'' +
                ", empname='" + empname + '\'' +
                ", emploc='" + emploc + '\'' +
                ", designation='" + designation + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    private String emploc;
    private String designation;
    private String department;
    private double salary;

    public Employee(String empid, String empname, String emploc, String designation, String department, double salary) {
        this.empid = empid;
        this.empname = empname;
        this.emploc = emploc;
        this.designation = designation;
        this.department = department;
        this.salary = salary;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmploc() {
        return emploc;
    }

    public void setEmploc(String emploc) {
        this.emploc = emploc;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}