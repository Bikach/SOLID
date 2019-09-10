package fr.bikach.solid.o.refactored.main;


import fr.bikach.solid.o.refactored.logging.ConsoleLogger;
import fr.bikach.solid.o.refactored.persistence.EmployeeFileSerializer;
import fr.bikach.solid.o.refactored.persistence.EmployeeRepository;
import fr.bikach.solid.o.refactored.personnel.Employee;

import java.io.IOException;
import java.util.List;

public class SaveEmployeesMain {
    public static void main(String[] args) {
        // Grab employees
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        ConsoleLogger consoleLogger = new ConsoleLogger();

        EmployeeRepository repository = new EmployeeRepository(employeeFileSerializer);
        List<Employee> employees = repository.findAll();

        // Save all
        for (Employee e : employees){
            try {
                repository.save(e);
                consoleLogger.writeInfo("Saved employee " + e.toString());
            } catch (IOException exception) {
                consoleLogger.writeError("Error saving employee", exception);
            }
        }
    }
}
