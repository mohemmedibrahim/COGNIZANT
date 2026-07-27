package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.ormlearn.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

    // HQL Query
    @Query("SELECT e FROM Employee e WHERE e.permanent = 1")
    List<Employee> getAllPermanentEmployees();

    // HQL Aggregate Function
    @Query("SELECT AVG(e.salary) FROM Employee e WHERE e.department.id = :id")
    double getAverageSalary(@Param("id") int id);

    // Native Query
    @Query(value="SELECT * FROM employee", nativeQuery=true)
    List<Employee> getAllEmployeesNative();

}