package net.kiranatos.repositories.unidir.otm;

import net.kiranatos.model.unidir.otm.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
