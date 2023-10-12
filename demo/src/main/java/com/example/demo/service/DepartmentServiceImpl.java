package com.example.demo.service;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final JavaEmployeeService javaEmployeeService;

    public DepartmentServiceImpl(JavaEmployeeService javaEmployeeService) {
        this.javaEmployeeService = javaEmployeeService;
    }

    @Override
    public List<Employee> getEmployeesByDepartment(int departmentId) {
        return javaEmployeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public double getSumOfSalariesByDepartment(int departmentId) {
        return javaEmployeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    @Override
    public double getMaxSalaryEmployee(int departmentId) {
        return javaEmployeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary)).orElseThrow().getSalary();
    }

    @Override
    public double getMinSalaryEmployee(int departmentId) {
        return javaEmployeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary)).orElseThrow().getSalary();
    }


    @Override
    public Map<Integer, List<Employee>> getAllEmployees() {
        return javaEmployeeService.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
