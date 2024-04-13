package ai.rudra.employeeservice.repository;

import ai.rudra.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {
    private final List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public Employee getEmployee(int id) {
        return employeeList.get(id);
    }

    public Employee addEmployee(Employee employee){
        employeeList.add(employee);
        return employee;
    }

    public List<Employee> getEmployeeByDepartment(int departmentId) {
       return employeeList.stream().filter(employee -> employee.departmentId() == departmentId).collect(Collectors.toList());
    }

}
