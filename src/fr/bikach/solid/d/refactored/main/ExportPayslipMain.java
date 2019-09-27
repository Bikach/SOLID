package fr.bikach.solid.d.refactored.main;

import fr.bikach.solid.d.refactored.documents.Payslip;
import fr.bikach.solid.d.refactored.logging.ConsoleLogger;
import fr.bikach.solid.d.refactored.persistence.EmployeeFileRepository;
import fr.bikach.solid.d.refactored.persistence.EmployeeFileSerializer;
import fr.bikach.solid.d.refactored.personnel.Employee;

import java.time.Month;
import java.util.List;

public class ExportPayslipMain {
    public static void main(String[] args) {
        // Create dependencies
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeFileRepository repository = new EmployeeFileRepository(employeeFileSerializer);

        // Grab employees
        List<Employee> employees = repository.findAll();

        for (Employee employee : employees){
            Payslip payslip = new Payslip(employee , Month.AUGUST);

            String exportableText = payslip.toTxt().toUpperCase();
            System.out.println(exportableText);
        }
    }
}
