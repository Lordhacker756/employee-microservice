package ai.rudra.departmentservice.repository;

import ai.rudra.departmentservice.models.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {
    private List<Department> departmentList = new ArrayList<>();

    public Department addDepartment(Department department){
        departmentList.add(department);
        return department;
    }

    public Department findDepartmentById(Integer id){
        return departmentList.get(id);
    }


    public  List<Department> getAllDepartments(){
        return departmentList;
    }
}
