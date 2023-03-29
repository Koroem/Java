package Homework_Bonus;
import java.time.LocalDate;
import java.util.*;
class Person implements Node {
    private String name;
    private Date birthDate;
    private Map<Node, Position> relationships;
    private Company company;

    public Person(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.relationships = new HashMap<>();
        this.company = null;
    }

    public void addFriend(Person friend) {
        this.relationships.put(friend, Position.FRIEND);
        friend.relationships.put(this, Position.FRIEND);
    }

    public void addCompany(Company company) {
        if (this.company == null) {
            Position position = Position.EMPLOYEE;
            if (this instanceof Programmer) {
                position = Position.PROGRAMMER;
            } else if (this instanceof Designer) {
                position = Position.DESIGNER;
            }
            this.relationships.put(company, position);
            company.addPerson(this, position);
            this.company = company;
        } else {
           throw new RuntimeException(this.name + " already works for a company.");

        }
    }
    @Override
    public String getName() {
        return this.name;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public Map<Node, Position> getRelationships() {
        return this.relationships;
    }

    public Company getCompany() {
        return this.company;
    }
}