package fr.bikach.solid.i.refactored.main;

import fr.bikach.solid.i.refactored.documents.Payslip;
import fr.bikach.solid.i.refactored.logging.ConsoleLogger;
import fr.bikach.solid.i.refactored.persistence.EmployeeFileSerializer;
import fr.bikach.solid.i.refactored.persistence.EmployeeRepository;
import fr.bikach.solid.i.refactored.personnel.Employee;

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
