package com.ushwamala.thymeleaf.springboot.Repository;

import com.ushwamala.thymeleaf.springboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository  extends JpaRepository<Employee,Integer> {

    //custom method to sort by lastName
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
    List<Employee> findAllByOrderByLastNameAsc();

    // search by name
    public List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String firstName, String lastName);

}
