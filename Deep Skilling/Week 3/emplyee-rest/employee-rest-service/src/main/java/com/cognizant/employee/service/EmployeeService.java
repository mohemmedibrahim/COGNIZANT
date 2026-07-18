package com.cognizant.employee.service;

import com.cognizant.employee.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    public List<Employee> getEmployees() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("employee.xml");

        List<Employee> employees = new ArrayList<>();

        employees.add(context.getBean("employee1", Employee.class));
        employees.add(context.getBean("employee2", Employee.class));

        return employees;
    }
}