package fr.bikach.solid.i.before.taxes;

import fr.bikach.solid.i.before.personnel.Employee;
import fr.bikach.solid.i.before.personnel.FullTimeEmployee;
import fr.bikach.solid.i.before.personnel.Intern;
import fr.bikach.solid.i.before.personnel.PartTimeEmployee;

public class TaxCalculatorFactory {
    public static TaxCalculator create(Employee employee) {
        if (employee instanceof FullTimeEmployee) {
            return new FullTimeTaxCalculator();
        }

        if (employee instanceof PartTimeEmployee) {
            return new PartTimeTaxCalculator();
        }

        if (employee instanceof Intern) {
            return new InternTaxCalculator();
        }

        throw new RuntimeException("Invalid employee type");
    }
}
