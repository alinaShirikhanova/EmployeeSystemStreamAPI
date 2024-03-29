package com.example.demo.api;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeSalaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class EmployeeSalaryController {
    private final EmployeeSalaryService employeeSalaryService;

    public EmployeeSalaryController(EmployeeSalaryService employeeSalaryService) {
        this.employeeSalaryService = employeeSalaryService;
    }

    @GetMapping("/max-salary")
    public Employee getMaxSalaryEmployee(@RequestParam("departmentId") int departmentId) {
        return employeeSalaryService.getMaxSalaryEmployee(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getMinSalaryEmployee(@RequestParam("departmentId") int departmentId) {
        return employeeSalaryService.getMinSalaryEmployee(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeSalaryService.getAllEmployees();
    }

    @GetMapping(value = "/all", params = { "student-id", "theme-id" })
    public List<Employee> getEmployeesByDepartment(@RequestParam(value = "departmentId") int departmentId) {
        return employeeSalaryService.getEmployeesByDepartment(departmentId);
    }

}
