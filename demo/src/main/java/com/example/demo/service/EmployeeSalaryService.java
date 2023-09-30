package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeSalaryService {
    Employee getMaxSalaryEmployee(int departmentId);
    Employee getMinSalaryEmployee(int departmentId);
    List<Employee> getEmployeesByDepartment(int departmentId);
    List<Employee> getAllEmployees();
}
