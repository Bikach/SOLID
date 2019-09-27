package fr.bikach.solid.d.refactored.payment;

import fr.bikach.solid.d.refactored.notifications.EmployeeNotifier;
import fr.bikach.solid.d.refactored.persistence.EmployeeRepository;
import fr.bikach.solid.d.refactored.personnel.Employee;

import java.util.List;

public class PaymentProcessor {

    private EmployeeRepository employeeRepository;
    private EmployeeNotifier employeeNotifier;

    public PaymentProcessor(EmployeeRepository employeeRepository,
                            EmployeeNotifier employeeNotifier){
        this.employeeRepository = employeeRepository;
        this.employeeNotifier = employeeNotifier;
    }

    public int sendPayments(){
        List<Employee> employees = this.employeeRepository.findAll();
        int totalPayments = 0;

        for(Employee employee : employees){
            totalPayments += employee.getMonthlyIncome();
            this.employeeNotifier.notify(employee);
        }

        return totalPayments;
    }
}
