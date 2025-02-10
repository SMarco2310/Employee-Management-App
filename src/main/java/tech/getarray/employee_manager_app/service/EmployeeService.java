package tech.getarray.employee_manager_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarray.employee_manager_app.exception.UserNotFoundException;
import tech.getarray.employee_manager_app.model.Employee;
import tech.getarray.employee_manager_app.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode("EMP" + java.util.UUID.randomUUID());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }
    public void deleteEmployee(Long id){
        employeeRepository.deleteEmployeeById(id);
    }
}
