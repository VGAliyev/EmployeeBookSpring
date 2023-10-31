package pro.sky.course2.aliev.employeebook.employeebook.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.course2.aliev.employeebook.employeebook.Employee;
import pro.sky.course2.aliev.employeebook.employeebook.exceptions.EmployeeAlreadyAddedException;
import pro.sky.course2.aliev.employeebook.employeebook.exceptions.EmployeeNotFoundException;
import pro.sky.course2.aliev.employeebook.employeebook.exceptions.EmployeeStorageIsFullException;
import pro.sky.course2.aliev.employeebook.employeebook.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName) {
        try {
            return employeeService.add(firstName, lastName);
        } catch (EmployeeStorageIsFullException e) {
            System.out.println("Storage is full!");
        } catch (EmployeeAlreadyAddedException e) {
            System.out.println("Already added!");
        }
        return null;
    }

    @RequestMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName) {
        try {
            return employeeService.remove(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Not found!");
        }
        return null;
    }

    @RequestMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        try {
            return employeeService.find(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Not found!");
        }
        return null;
    }

    @RequestMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }
}
