package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements JavaEmployeeService {

    List<Employee> allEmployees = new ArrayList<>();
    int maxAmountEmp = 10;

    public Employee addEmployee(String name, String surname) {
        if (allEmployees.size() == maxAmountEmp) {
            throw new EmployeeStorageIsFullException("Превышаемое количество сотрудников");
        }
        for (Employee elem : allEmployees) {
            if (elem.getName().equals(name) && elem.getSurname().equals(surname)) {
                throw new EmployeeAlreadyAddedException("Сотрудник с таким именем и фамилией уже существует");
            }
        }
        Employee newPeople = new Employee(name, surname);
        allEmployees.add(newPeople);
        return newPeople;
    }

    public Employee delEmployee(String name, String surname) {
        for (Employee elem : allEmployees) {
            if (elem.getName().equals(name) && elem.getSurname().equals(surname)) {
                allEmployees.remove(elem);
                return elem;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник с таким именем или фамилией нету");
    }

    public Employee getEmployee(String name, String surname) {
        for (Employee elem : allEmployees) {
            if (elem.getName().equals(name) && elem.getSurname().equals(surname)) {
                return elem;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник с таким именем или фамилией нету");
    }

    public Employee reternEmployee(String name, String surname) {
        return (Employee) allEmployees;
    }
}



