package fr.bikach.solid.i.refactored.taxes;

import fr.bikach.solid.i.refactored.personnel.Employee;

public interface TaxCalculator {
    double calculate(Employee employee);
}
