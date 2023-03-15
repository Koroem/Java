package Compulsory;


import java.util.*;

public class Person implements Node, Comparable<Person> {

    /* Nume persoana */
    private String name;

    /* Lista de obiecte de tip Person */
    private List<Person> friends;

    /* Constructor Person, Initializeaza lista goala friends
    Lista friends va contine obiecte de tip Person */
    public Person(String name) {
        this.name = name;
        this.friends = new ArrayList<>();
    }

    /* Metoda pentru a adauga o cunostinta de tip Person la lista de cunostinte(friends)*/
    public void addFriend(Person friend) {
        friends.add(friend);
    }
    /* Metoda pentru a afla lista de cunostinte a unei persoane */
    public List<Person> getFriends() {
        return friends;
    }
    /* Metoda de comparare nume cu alte persoane */

    @Override
    public int compareTo(Person otherPerson) {
        return this.name.compareTo(otherPerson.name);
    }
    /* Metoda pentru a obtine numele persoanei */
    @Override
    public String getName() {
        return name;
    }
}

