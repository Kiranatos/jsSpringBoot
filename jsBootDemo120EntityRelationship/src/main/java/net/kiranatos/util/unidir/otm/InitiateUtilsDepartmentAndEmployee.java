package net.kiranatos.util.unidir.otm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.kiranatos.model.unidir.otm.Department;
import net.kiranatos.model.unidir.otm.Employee;
import net.kiranatos.services.unidir.otm.DepartmentService;
import net.kiranatos.services.unidir.otm.EmployeeService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class InitiateUtilsDepartmentAndEmployee implements CommandLineRunner {

    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    public InitiateUtilsDepartmentAndEmployee(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" <<< Unidirectional association | @OneToMany | Department and Employee entities >>> " + Arrays.toString(args));

        create("Epam", "trainee-", 3);
        create("SoftServe", "senior-", 2);
        create("Google", "junior-", 4);
        create("Yandex", "middle-", 2);

    }

    private void create(String nameDepartment, String nameEmployee, int n) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Employee em = new Employee();
            em.setName(nameEmployee + Math.floor(Math.random() * 1000) / 10);
            employees.add(em);
            employeeService.save(em);
        }

        Department dep = new Department();
        dep.setName(nameDepartment);
        dep.setEmployees(employees);

        departmentService.save(dep);

    }
}
