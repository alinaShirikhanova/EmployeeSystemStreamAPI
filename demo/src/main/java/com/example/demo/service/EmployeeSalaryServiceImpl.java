package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeSalaryServiceImpl implements EmployeeSalaryService{
    private final JavaEmployeeService javaEmployeeService;

    public EmployeeSalaryServiceImpl(JavaEmployeeService javaEmployeeService) {
        this.javaEmployeeService = javaEmployeeService;
    }

    @Override
    public Employee getMaxSalaryEmployee(int departmentId) {
        return javaEmployeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(emp -> (int) emp.getSalary())).orElseThrow();
    }

    @Override
    public Employee getMinSalaryEmployee(int departmentId) {
            return javaEmployeeService.getEmployees().stream()
                    .filter(employee -> employee.getDepartmentId() == departmentId)
                    .min(Comparator.comparingInt(emp -> (int) emp.getSalary())).orElseThrow();
        }


    @Override
    public List<Employee> getEmployeesByDepartment(int departmentId) {
        return javaEmployeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getAllEmployees() {
        return javaEmployeeService.getEmployees();
    }
}
