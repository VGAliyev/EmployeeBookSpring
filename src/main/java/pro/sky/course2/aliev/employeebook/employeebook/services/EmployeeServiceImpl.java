package pro.sky.course2.aliev.employeebook.employeebook.services;

import org.springframework.stereotype.Service;
import pro.sky.course2.aliev.employeebook.employeebook.Employee;
import pro.sky.course2.aliev.employeebook.employeebook.exceptions.EmployeeAlreadyAddedException;
import pro.sky.course2.aliev.employeebook.employeebook.exceptions.EmployeeNotFoundException;
import pro.sky.course2.aliev.employeebook.employeebook.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    private final int MAX_EMPLOYEES_COUNT = 10;

    public Employee add(String firstName, String lastName) {
        if (employees.size() > MAX_EMPLOYEES_COUNT) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
