package com.example.demo.service;

import com.example.demo.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    EmployeeService employeeService;
    @InjectMocks
    DepartmentServiceImpl departmentService;
    List<Employee> list;

    @BeforeEach
    public void setup() {
//        MockitoAnnotations.initMocks(this);
        list = List.of(
                new Employee("Иван", "Петров", 1, 50000),
                new Employee("Петя", "Иванов", 5, 100),
                new Employee("Валя", "Иванов", 3, 1000),
                new Employee("Ваня", "Иванов", 5, 100));
        Mockito.when(employeeService.getEmployees()).thenReturn(list);
    }


    @Test
    void getEmployeesByDepartment() {
        List<Employee> expected = List.of(
                new Employee("Петя", "Иванов", 5, 100),
                new Employee("Ваня", "Иванов", 5, 100));
        List<Employee> actual = departmentService.getEmployeesByDepartment(5);

        assertEquals(expected, actual);


    }

    @Test
    void getSumOfSalariesByDepartment() {
        assertEquals(200.0, departmentService.getSumOfSalariesByDepartment(5));
    }

    @Test
    void getMaxSalaryEmployee() {
        assertEquals(100.0, departmentService.getMaxSalaryEmployee(5));
    }

    @Test
    void getMinSalaryEmployee() {
        assertEquals(100.0, departmentService.getMinSalaryEmployee(5));
    }

    @Test
    void getAllEmployees() {
        assertEquals(list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId)), departmentService.getAllEmployees());
    }
}