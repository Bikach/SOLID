package fr.bikach.solid.o.before.taxes;

import fr.bikach.solid.o.before.personnel.Employee;
import fr.bikach.solid.o.before.personnel.FullTimeEmployee;
import fr.bikach.solid.o.before.personnel.PartTimeEmployee;

public class TaxCalculator {
    private final int RETIREMENT_TAX_PERCENTAGE = 10;
    private final int INCOME_TAX_PERCENTAGE = 16;
    private final int BASE_HEALTH_INSURANCE = 100;


    public double calculate(Employee employee) {
        if (employee instanceof FullTimeEmployee)
            return BASE_HEALTH_INSURANCE +
                    (employee.getMonthlyIncome() * RETIREMENT_TAX_PERCENTAGE) / 100 +
                    (employee.getMonthlyIncome() * INCOME_TAX_PERCENTAGE) / 100;


        if (employee instanceof PartTimeEmployee)
            return BASE_HEALTH_INSURANCE +
                (employee.getMonthlyIncome() * 10) / 100 +
                (employee.getMonthlyIncome() * INCOME_TAX_PERCENTAGE) / 100;

        if (employee instanceof PartTimeEmployee){
            if(employee.getMonthlyIncome() < 350)
                return 0;
            return (employee.getMonthlyIncome() * INCOME_TAX_PERCENTAGE) / 100;
        }
        return 0;
    }
}
