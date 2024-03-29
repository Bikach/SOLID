package fr.bikach.solid.d.refactored.main;

import fr.bikach.solid.d.refactored.logging.ConsoleLogger;
import fr.bikach.solid.d.refactored.persistence.EmployeeFileRepository;
import fr.bikach.solid.d.refactored.persistence.EmployeeFileSerializer;
import fr.bikach.solid.d.refactored.personnel.Employee;

import java.io.IOException;
import java.util.List;

public class SaveEmployeesMain {
    public static void main(String[] args) {
        // Grab employees
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        ConsoleLogger consoleLogger = new ConsoleLogger();

        EmployeeFileRepository repository = new EmployeeFileRepository(employeeFileSerializer);
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
