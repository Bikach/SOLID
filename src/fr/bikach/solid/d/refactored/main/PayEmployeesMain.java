package fr.bikach.solid.d.refactored.main;

import fr.bikach.solid.d.refactored.notifications.EmailSender;
import fr.bikach.solid.d.refactored.notifications.EmployeeNotifier;
import fr.bikach.solid.d.refactored.payment.PaymentProcessor;
import fr.bikach.solid.d.refactored.persistence.EmployeeFileRepository;
import fr.bikach.solid.d.refactored.persistence.EmployeeFileSerializer;
import fr.bikach.solid.d.refactored.persistence.EmployeeRepository;

public class PayEmployeesMain {

    /*
    Will take a couple of seconds to execute due to the
    sending of mails.
     */

    public static void main(String[] args) {

        EmployeeFileSerializer serializer = new EmployeeFileSerializer();
        EmployeeRepository employeeRepository =
                new EmployeeFileRepository(serializer);
        EmployeeNotifier employeeNotifier = new EmailSender();
        PaymentProcessor paymentProcessor = new PaymentProcessor(
                employeeRepository,
                employeeNotifier);

        int totalPayments = paymentProcessor.sendPayments();
        System.out.println("Total payments " + totalPayments);
    }
}
