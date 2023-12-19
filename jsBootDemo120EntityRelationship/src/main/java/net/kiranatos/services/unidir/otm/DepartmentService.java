package net.kiranatos.services.unidir.otm;

import net.kiranatos.model.unidir.otm.Department;
import net.kiranatos.repositories.unidir.otm.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    
    public void save(Department department) {
        departmentRepository.save(department);
    }

}
