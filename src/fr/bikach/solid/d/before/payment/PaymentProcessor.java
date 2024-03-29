package fr.bikach.solid.d.before.payment;

import fr.bikach.solid.d.before.notifications.EmailSender;
import fr.bikach.solid.d.before.persistence.EmployeeFileRepository;
import fr.bikach.solid.d.before.persistence.EmployeeFileSerializer;
import fr.bikach.solid.d.before.personnel.Employee;

import java.util.List;

public class PaymentProcessor {

    private EmployeeFileRepository employeeRepository;

    public PaymentProcessor(){
        EmployeeFileSerializer serializer =
                new EmployeeFileSerializer();
        this.employeeRepository =
                new EmployeeFileRepository(serializer);
    }

    public int sendPayments(){
        List<Employee> employees = this.employeeRepository.findAll();
        int totalPayments = 0;

        for(Employee employee : employees){
            totalPayments += employee.getMonthlyIncome();
            EmailSender.notify(employee);
        }

        return totalPayments;
    }
}
