package com.example.firstspring.repositories;

import com.example.firstspring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    public List<Employee> findAllByName(String name);
}
