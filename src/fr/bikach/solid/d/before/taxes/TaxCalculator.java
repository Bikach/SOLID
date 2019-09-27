package fr.bikach.solid.d.before.taxes;

import fr.bikach.solid.d.before.personnel.Employee;

public interface TaxCalculator {
    double calculate(Employee employee);
}
