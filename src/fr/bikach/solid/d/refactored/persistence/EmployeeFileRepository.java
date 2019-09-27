package fr.bikach.solid.d.refactored.persistence;


import fr.bikach.solid.d.refactored.personnel.Employee;
import fr.bikach.solid.d.refactored.personnel.FullTimeEmployee;
import fr.bikach.solid.d.refactored.personnel.Intern;
import fr.bikach.solid.d.refactored.personnel.PartTimeEmployee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Helper method to perform CRUD operations on employees. In a production
application we could use the database for persistence. In this demo,
we are storing employees in the file system.
 */
public class EmployeeFileRepository implements EmployeeRepository {
    private EmployeeFileSerializer serializer;

    public EmployeeFileRepository(EmployeeFileSerializer serializer) {
        this.serializer = serializer;
    }

    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();

        String path =  this.getClass().getClassLoader()
                .getResource("employees.csv")
                .getPath();

        try (Scanner scanner = new Scanner(new File(path))) {
            // SKip header
            scanner.nextLine();

            // Process content
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Employee employee = createEmployeeFromCsvRecord(line);
                employees.add(employee);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public void save(Employee employee) throws IOException {
        String serializedString = this.serializer.serialize(employee);

        Path path = Paths.get(employee.getFullName()
                .replace(" ", "_") + ".rec");
        Files.write(path, serializedString.getBytes());
    }

    private Employee createEmployeeFromCsvRecord(String line) {
        String[] employeeRecord = line.split(",");
        String name = employeeRecord[0];
        int income = Integer.parseInt(employeeRecord[1]);
        int nbHours = Integer.parseInt(employeeRecord[2]);

        Employee employee;
        if(nbHours == 40){
            employee = new FullTimeEmployee(name,income);
        } else if (nbHours == 20){
            employee = new PartTimeEmployee(name, income);
        } else{
            employee = new Intern(name, income, nbHours);
        }
        return employee;
    }
}
