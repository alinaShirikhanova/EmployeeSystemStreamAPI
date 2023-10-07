package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeAlreadyAddedException;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements JavaEmployeeService {

    List<Employee> allEmployees = new ArrayList<>();
    int maxAmountEmp = 10;

    public Employee addEmployee(String name, String surname, int departmentId, double salary) {
        if (allEmployees.size() == maxAmountEmp) {
            throw new EmployeeStorageIsFullException("Превышено количество сотрудников");
        }

        if (allEmployees.stream().anyMatch(employee -> employee.getName().equals(name) && employee.getSurname().equals(surname)))
            throw new EmployeeAlreadyAddedException("Сотрудник с таким именем и фамилией уже существует");

        Employee employee = new Employee(name, surname, departmentId, salary);
        allEmployees.add(employee);
        return employee;
    }

    public Employee delEmployee(String name, String surname) {
        Employee emp = allEmployees.stream()
                        .filter(em -> em.getName().equals(name) && em.getSurname().equals(surname)).findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудника с таким именем или фамилией нету"));
        allEmployees.removeIf(employee -> employee.getName().equals(name) && employee.getSurname().equals(surname));
        throw new EmployeeNotFoundException("Сотрудника с таким именем или фамилией нету");
    }

    public Employee getEmployee(String name, String surname) {
        return allEmployees.stream().filter(emp -> emp.getName().equals(name) && emp.getSurname().equals(surname)).findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));
    }

    public List<Employee> getEmployees() {
        return allEmployees;
    }
}




