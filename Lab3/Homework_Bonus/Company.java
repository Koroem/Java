package Homework_Bonus;
import java.util.*;

class Company implements Node {
    private String name;
    private Industry industry;
    private Map<Node, Position> employees;

    public Company(String name, Industry industry) {
        this.name = name;
        this.industry = industry;
        this.employees = new HashMap<>();
    }

    public void addPerson(Person person, Position position) {
        this.employees.put(person, position);
    }

    public String getName() {
        return this.name;
    }

    public Industry getIndustry() {
        return this.industry;
    }

    public Map<Node, Position> getRelationships() {
        return this.employees;
    }
}

