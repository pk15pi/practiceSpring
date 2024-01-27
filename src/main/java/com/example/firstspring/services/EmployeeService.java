package com.example.firstspring.services;

import com.example.firstspring.entity.Employee;
import com.example.firstspring.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployee(){ return employeeRepo.findAll();}

    public List<Employee> getEmployeeByName(String name){ return employeeRepo.findAllByName(name);}

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepo.findById(id);
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee patchEmployee(Long id, Employee employee) {
        Optional<Employee> empInstanceOption = employeeRepo.findById(id);
        if(empInstanceOption.isPresent()){
            Employee empInstance = empInstanceOption.get();

            if(empInstance.getDob() != null) {
                employee.setDob(empInstance.getDob());
            }

            if(empInstance.getTitle() != null){
                employee.setTitle(empInstance.getTitle());
            }

            if(empInstance.getName() != null) {
                employee.setName(empInstance.getName());
            }

            if(empInstance.getPin() != null) {
                employee.setPin(empInstance.getPin());
            }

            if(empInstance.getCity() != null){
                employee.setCity(empInstance.getCity());
            }

            return employeeRepo.save(employee);

        } else {
            return null;
        }
    }


    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }


    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }

}
