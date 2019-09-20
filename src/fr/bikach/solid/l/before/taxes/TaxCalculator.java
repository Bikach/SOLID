package fr.bikach.solid.l.before.taxes;

import fr.bikach.solid.l.before.personnel.Employee;

public interface TaxCalculator {
    double calculate(Employee employee);
}
