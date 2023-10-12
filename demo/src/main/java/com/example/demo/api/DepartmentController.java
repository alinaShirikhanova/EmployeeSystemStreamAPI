package com.example.demo.api;


import com.example.demo.entity.Employee;
import com.example.demo.service.DepartmentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesByDepartment(@PathVariable("id") int departmentId) {
        return departmentService.getEmployeesByDepartment(departmentId);
    }

    @GetMapping("/{id}/salary/sum")
    public double getSumOfSalariesByDepartment(@PathVariable("id") int departmentId) {
        return departmentService.getSumOfSalariesByDepartment(departmentId);
    }

    @GetMapping("/{id}/salary/max")
    public double getMaxSalaryEmployee(@PathVariable("id") int departmentId) {
        return departmentService.getMaxSalaryEmployee(departmentId);
    }

    @GetMapping("/{id}/salary/min")
    public double getMinSalaryEmployee(@PathVariable("id") int departmentId) {
        return departmentService.getMinSalaryEmployee(departmentId);
    }


    public Map<Integer, List<Employee>> getAllEmployees() {
        return departmentService.getAllEmployees();
    }
}
