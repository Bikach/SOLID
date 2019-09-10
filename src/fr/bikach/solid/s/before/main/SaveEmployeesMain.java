package fr.bikach.solid.s.before.main;

import fr.bikach.solid.s.before.persistence.EmployeeRepository;
import fr.bikach.solid.s.before.personnel.Employee;

import java.util.List;

public class SaveEmployeesMain {
    public static void main(String[] args) {
        // Grab employees
        EmployeeRepository repository = new EmployeeRepository();
        List<Employee> employees = repository.findAll();

        // Save all
        for (Employee e : employees){
            Employee.save(e);
        }
    }
}
