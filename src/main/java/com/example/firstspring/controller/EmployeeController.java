package com.example.firstspring.controller;

import com.example.firstspring.entity.Employee;
import com.example.firstspring.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/{id}")
    public Optional<Employee> getEmpById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public Employee posteEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PatchMapping("/{id}")
    public Employee patchEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.patchEmployee(id, employee);
    }

    @PutMapping("")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/deletewithresponse/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }

//    @DeleteMapping("/deletewithresponse/{id}")
//    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id){
//        employeeService.deleteEmployee(id);
//        return ResponseEntity.ok("Deleted Successfylly");
//    }

    @PostMapping("/bulkemployee/create")
    public List<Employee> bulkCreateEmployee(List<Employee> employees){
        List<Employee> emps = new ArrayList<>();
        for(Employee item : employees) {
            employeeService.saveEmployee(item);
            emps.add(item);
        }
        return emps;
    }

    @PutMapping("/bulkemployee/update")
    public List<Employee> bulkUpdateEmployee(List<Employee> employees){
        List<Employee> emps = new ArrayList<>();
        for(Employee item: employees) {
            employeeService.updateEmployee(item);
            emps.add(item);
        }
        return emps;
    }

    @DeleteMapping("/bulkemployee/delete/{ids}")
    public List<Long> deleteBulk(@PathVariable List<Long> ids){
        List<Long> refs = new ArrayList<>();
        for(Long ref : ids){
            employeeService.getEmployeeById(ref);
            refs.add(ref);
        }

        return refs;
    }
}
