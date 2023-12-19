package net.kiranatos.services.unidir.otm;

import net.kiranatos.model.unidir.otm.Employee;
import net.kiranatos.repositories.unidir.otm.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}
