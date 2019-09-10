package fr.bikach.solid.o.refactored.taxes;

import fr.bikach.solid.o.refactored.personnel.Employee;

public interface TaxCalculator {
    double calculate(Employee employee);
}
