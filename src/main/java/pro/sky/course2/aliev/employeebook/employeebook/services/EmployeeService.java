package pro.sky.course2.aliev.employeebook.employeebook.services;

import pro.sky.course2.aliev.employeebook.employeebook.Employee;

import java.util.List;

public interface EmployeeService {
    Employee add(String firstName, String lastName);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);
    List<Employee> getEmployees();
}
