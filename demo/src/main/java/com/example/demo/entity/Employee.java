package com.example.demo.entity;
import java.util.Objects;

public class Employee {

    private final String name;
    private final String surname;
    int departmentId;
    double salary;

    public Employee(String name, String surname, int departmentId, double salary) {
        this.name = name;
        this.surname = surname;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return String.format("ФИО: %s %s, \n Отдел: %d, \n ЗП: %f", surname, name, departmentId, salary);
    }

}