package fr.bikach.solid.i.before.documents;

import fr.bikach.solid.i.before.personnel.Employee;

import java.time.Month;

public class Payslip implements ExportableDocument {
    private String employeeName;
    private int monthlyIncome;
    private Month month;

    public Payslip(Employee employee, Month month) {
        this.employeeName = employee.getFullName();
        this.monthlyIncome = employee.getMonthlyIncome();
        this.month = month;
    }

    @Override
    public String toTxt() {
        StringBuilder sb = new StringBuilder();
        sb.append("MONTH: ").append(this.month);
        sb.append(System.lineSeparator());
        sb.append("NAME: ").append(this.employeeName);
        sb.append(System.lineSeparator());
        sb.append("INCOME: ").append(this.monthlyIncome);
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public byte[] toPdf() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toJson() {
        throw new UnsupportedOperationException();
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }
}
