package fr.bikach.solid.d.before.main;

import fr.bikach.solid.d.before.payment.PaymentProcessor;

public class PayEmployeesMain {

    /*
    Will take a couple of seconds to execute due to the
    sending of mails.
     */
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        int totalPayments = paymentProcessor.sendPayments();
        System.out.println("Total payments " + totalPayments);
    }
}
