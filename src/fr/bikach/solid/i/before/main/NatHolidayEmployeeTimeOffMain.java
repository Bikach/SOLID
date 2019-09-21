package fr.bikach.solid.i.before.main;

import fr.bikach.solid.i.before.logging.ConsoleLogger;
import fr.bikach.solid.i.before.persistence.EmployeeFileSerializer;
import fr.bikach.solid.i.before.persistence.EmployeeRepository;
import fr.bikach.solid.i.before.personnel.Employee;
import fr.bikach.solid.i.before.personnel.FullTimeEmployee;

import java.util.List;

public class NatHolidayEmployeeTimeOffMain {
    public static void main(String[] args) {
        // Create dependencies
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepository repository = new EmployeeRepository(employeeFileSerializer);

        // Grab employees
        List<Employee> employees = repository.findAll();
        Employee manager = new FullTimeEmployee("Steve Jackson", 5000);

        // Request time off for each employee on
        // national holiday
        for (Employee employee : employees){
            employee.requestTimeOff(1, manager);
        }
    }
}
