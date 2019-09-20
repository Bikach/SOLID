package fr.bikach.solid.l.before.taxes;

import fr.bikach.solid.l.before.personnel.Employee;
import fr.bikach.solid.l.before.personnel.FullTimeEmployee;
import fr.bikach.solid.l.before.personnel.Intern;
import fr.bikach.solid.l.before.personnel.PartTimeEmployee;

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
