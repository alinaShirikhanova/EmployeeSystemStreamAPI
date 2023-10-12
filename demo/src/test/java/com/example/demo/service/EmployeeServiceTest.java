package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    private final EmployeeService employeeService = new EmployeeService();

    @BeforeEach
    public void setUp() {
        employeeService.addEmployee("Иван", "Петров", 1, 50000);
        employeeService.addEmployee("Петя", "Иванов", 5, 100);
//        employeeService.addEmployee("Катя", "Иванов", 4, 1000);
        employeeService.addEmployee("Валя", "Иванов", 3, 1000);
//        employeeService.addEmployee("Рита", "Иванов", 3, 10000);
//        employeeService.addEmployee("Василий", "Иванов", 2, 100000);
//        employeeService.addEmployee("Раиса", "Иванов", 5, 100000);
//        employeeService.addEmployee("Николай", "Иванов", 5, 100000);
//        employeeService.addEmployee("Сергей", "Иванов", 1, 100000);
//        employeeService.addEmployee("Петя6", "Иванов", 1, 100000);
//        employeeService.addEmployee("Петя6", "Иванов", 1, 100000);
//        employeeService.addEmployee("Петя6", "Иванов", 1, 100000);
//        employeeService.addEmployee("Петя6", "Иванов", 1, 100000);
    }

    @Test
    void addEmployee() {
        employeeService.addEmployee("Ваня", "Иванов", 5, 100);
        List<Employee> list = List.of(new Employee("Иван", "Петров", 1, 50000),
                new Employee("Петя", "Иванов", 5, 100),
                new Employee("Валя", "Иванов", 3, 1000),
                new Employee("Ваня", "Иванов", 5, 100));

        assertEquals(list, employeeService.getEmployees());
    }

    @Test
    void delEmployee() {
        employeeService.delEmployee("Петя", "Иванов");
        List<Employee> list = List.of(new Employee("Иван", "Петров", 1, 50000),
                new Employee("Валя", "Иванов", 3, 1000));

        assertEquals(list, employeeService.getEmployees());
    }

    @Test
    void delEmployeeThrows() {
        employeeService.delEmployee("Петя", "Иванов");
        List<Employee> list = List.of(new Employee("Иван", "Петров", 1, 50000),
                new Employee("Валя", "Иванов", 3, 1000));

        assertThrows(EmployeeNotFoundException.class, () -> employeeService.delEmployee("Владислав", "Иванов"));
    }

    @Test
    void getEmployee() {
        Employee actual = employeeService.getEmployee("Петя", "Иванов");
        assertEquals(new Employee("Петя", "Иванов", 5, 100), actual);
    }

    @Test
    void getEmployees() {
        List<Employee> list = List.of(new Employee("Иван", "Петров", 1, 50000),
                new Employee("Валя", "Иванов", 3, 1000),
                new Employee("Петя", "Иванов", 5, 100));
        assertEquals(new HashSet<>(list), new HashSet<>(employeeService.getEmployees()));
    }
}