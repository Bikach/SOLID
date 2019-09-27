package fr.bikach.solid.d.refactored.taxes;

import fr.bikach.solid.d.refactored.personnel.Employee;

public interface TaxCalculator {
    double calculate(Employee employee);
}
