package ai.rudra.employeeservice.controller;

import ai.rudra.employeeservice.model.Employee;
import ai.rudra.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping
    public List<Employee> getAllEmployees() {
        LOGGER.info("Get all employees");
        return employeeRepository.getEmployeeList();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        LOGGER.info("Create employee");
        return employeeRepository.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        LOGGER.info("Get employee by id {}", id);
        return employeeRepository.getEmployee(id);
    }

    @GetMapping("/department/{departmentId}")
        public List<Employee> getEmployeeByDepartment(@PathVariable int departmentId) {
        LOGGER.info("Get employee by department {}", departmentId);
        return employeeRepository.getEmployeeByDepartment(departmentId);
        }
}
