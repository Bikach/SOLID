package fr.bikach.solid.d.refactored.main;


import fr.bikach.solid.d.refactored.logging.ConsoleLogger;
import fr.bikach.solid.d.refactored.persistence.EmployeeFileRepository;
import fr.bikach.solid.d.refactored.persistence.EmployeeFileSerializer;
import fr.bikach.solid.d.refactored.personnel.Employee;
import fr.bikach.solid.d.refactored.personnel.FullTimeEmployee;

import java.util.List;

public class NatHolidayEmployeeTimeOffMain {
    public static void main(String[] args) {
        // Create dependencies
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeFileRepository repository = new EmployeeFileRepository(employeeFileSerializer);

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
