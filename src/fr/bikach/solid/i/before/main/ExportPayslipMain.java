package fr.bikach.solid.i.before.main;

import fr.bikach.solid.i.before.documents.Payslip;
import fr.bikach.solid.i.before.logging.ConsoleLogger;
import fr.bikach.solid.i.before.persistence.EmployeeFileSerializer;
import fr.bikach.solid.i.before.persistence.EmployeeRepository;
import fr.bikach.solid.i.before.personnel.Employee;

import java.time.Month;
import java.util.List;

public class ExportPayslipMain {
    public static void main(String[] args) {
        // Create dependencies
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepository repository = new EmployeeRepository(employeeFileSerializer);

        // Grab employees
        List<Employee> employees = repository.findAll();

        for (Employee employee : employees){
            Payslip payslip = new Payslip(employee , Month.AUGUST);

            String exportableText = payslip.toTxt().toUpperCase();
            System.out.println(exportableText);
        }
    }
}
