package fr.bikach.solid.l.before.main;

import fr.bikach.solid.l.before.logging.ConsoleLogger;
import fr.bikach.solid.l.before.persistence.EmployeeFileSerializer;
import fr.bikach.solid.l.before.persistence.EmployeeRepository;
import fr.bikach.solid.l.before.personnel.Employee;
import fr.bikach.solid.l.before.personnel.ServiceLicenseAgreement;
import fr.bikach.solid.l.before.personnel.Subcontractor;

import java.util.List;

public class ApproveSLAMain {
    public static void main(String[] args) {
        // Create dependencies
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepository repository = new EmployeeRepository(employeeFileSerializer);

        // Define SLA
        int minTimeOffPercent = 98;
        int maxResolutionDays = 2;
        ServiceLicenseAgreement companySla = new ServiceLicenseAgreement(
                minTimeOffPercent,
                maxResolutionDays);

        // Grab subcontractors
        List<Employee> subcontractors = repository.findAll();

        for (Employee e : subcontractors){
            if(e instanceof Subcontractor){
                Subcontractor s = (Subcontractor)e;
                s.approveSLA(companySla);
            }
        }
    }
}
