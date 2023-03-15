package Compulsory;

import java.util.*;

public class Company implements Node, Comparable<Company> {
    /* Nume Companie */
    private String name;
    /* Lista de obiecte de tip Person */
    private List<Person> employees;

    /* Constructor Company */
    public Company(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }
    /* Adaugare angajat */
    public void addEmployee(Person employee) {
        employees.add(employee);
    }
    /* Metoda de comparare a numelui cu alta companie */

    @Override
    public int compareTo(Company other) {
        return this.name.compareTo(other.name);
    }
/* getter de nume */
    @Override
    public String getName() {
        return name;
    }
}

