package fr.bikach.solid.i.before.taxes;

import fr.bikach.solid.i.before.personnel.Employee;

public interface TaxCalculator {
    double calculate(Employee employee);
}
