package fr.bikach.solid.d.refactored.persistence;

import fr.bikach.solid.d.refactored.personnel.Employee;

import java.io.IOException;
import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();
    void save(Employee employee) throws IOException;
}
