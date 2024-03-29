package fr.bikach.solid.s.before.persistence;

import fr.bikach.solid.s.before.personnel.Employee;
import fr.bikach.solid.s.before.personnel.FullTimeEmployee;
import fr.bikach.solid.s.before.personnel.PartTimeEmployee;

import java.util.Arrays;
import java.util.List;

/*
Helper method to perform CRUD operations on employees. In a production
application we could use the database for persistence. In this demo,
we are storing employees in the file system.
 */
public class EmployeeRepository {

    public List<Employee> findAll(){
        // Employees are kept in memory for simplicity
        var anna = new FullTimeEmployee("Anna Smith", 2000);
        var billy = new FullTimeEmployee("Billy Leech", 920);

        var steve = new PartTimeEmployee("Steve Jones", 800);
        var magda = new PartTimeEmployee("Magda Iovan", 920);

        return Arrays.asList(anna, billy, steve, magda);
    }
}
