package com.cognizant.ormlearn;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeService;

@SpringBootApplication
public class OrmLearnApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(OrmLearnApplication.class,args);

        EmployeeService service =
                context.getBean(EmployeeService.class);

        // HQL
        List<Employee> employees =
                service.getAllPermanentEmployees();

        System.out.println("Permanent Employees");
        employees.forEach(System.out::println);

        // Aggregate Function
        System.out.println("Average Salary = "
                + service.getAverageSalary(1));

        // Native Query
        System.out.println("All Employees");
        service.getAllEmployeesNative()
                .forEach(System.out::println);

    }

}