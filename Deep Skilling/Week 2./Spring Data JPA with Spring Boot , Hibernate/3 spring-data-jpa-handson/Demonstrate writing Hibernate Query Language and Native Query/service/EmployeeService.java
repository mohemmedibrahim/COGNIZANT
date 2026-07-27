package com.cognizant.ormlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllPermanentEmployees(){

        return employeeRepository.getAllPermanentEmployees();

    }

    public double getAverageSalary(int id){

        return employeeRepository.getAverageSalary(id);

    }

    public List<Employee> getAllEmployeesNative(){

        return employeeRepository.getAllEmployeesNative();

    }

}