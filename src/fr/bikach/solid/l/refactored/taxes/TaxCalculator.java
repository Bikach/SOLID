package fr.bikach.solid.l.refactored.taxes;

import fr.bikach.solid.l.refactored.personnel.Employee;

public interface TaxCalculator {
    double calculate(Employee employee);
}
