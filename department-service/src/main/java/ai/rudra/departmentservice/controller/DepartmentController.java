package ai.rudra.departmentservice.controller;

import ai.rudra.departmentservice.client.EmployeeClient;
import ai.rudra.departmentservice.models.Department;
import ai.rudra.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    EmployeeClient employeeClient;

    @Autowired
    public DepartmentRepository departmentRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @GetMapping
    public List<Department> getDepartment() {
        LOGGER.info("GET:: All Departments");
        return departmentRepository.getAllDepartments();
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department){
        LOGGER.info("POST:: Add Department");
        return departmentRepository.addDepartment(department);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable int id){
        LOGGER.info("GET:: Department {} Retrieved", id);
        return departmentRepository.findDepartmentById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> getDepartmentWithEmployees() {
        LOGGER.info("GET:: All Department with employees");
        List<Department> departments = getDepartment();
        departments.stream()
                .forEach(department -> {
                    department.setEmployees(
                            employeeClient.getEmployeeByDepartment(department.getId())
                    );
                });

        return departments;
    }
}
