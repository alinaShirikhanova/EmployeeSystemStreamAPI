package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeSalaryService {
    Employee getMaxSalaryEmployee(int departmentId);
    Employee getMinSalaryEmployee(int departmentId);
    List<Employee> getEmployeesByDepartment(int departmentId);
    Map<Integer, List<Employee>> getAllEmployees();
}
