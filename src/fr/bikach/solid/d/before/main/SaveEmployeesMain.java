package fr.bikach.solid.d.before.main;

import fr.bikach.solid.d.before.logging.ConsoleLogger;
import fr.bikach.solid.d.before.persistence.EmployeeFileRepository;
import fr.bikach.solid.d.before.persistence.EmployeeFileSerializer;
import fr.bikach.solid.d.before.personnel.Employee;

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
