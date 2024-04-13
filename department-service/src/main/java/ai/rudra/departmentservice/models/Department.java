package ai.rudra.departmentservice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
public class Department {

    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();


    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department() {
    }
}
