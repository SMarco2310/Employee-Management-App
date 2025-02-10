package tech.getarray.employee_manager_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarray.employee_manager_app.model.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {




    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
