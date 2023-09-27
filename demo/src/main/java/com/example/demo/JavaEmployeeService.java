package com.example.demo;

public interface JavaEmployeeService {
    Employee addEmployee(String name, String surname);
    Employee delEmployee(String name, String surname);
    Employee getEmployee(String name, String surname);
    Employee reternEmployee(String name, String surname);

}
