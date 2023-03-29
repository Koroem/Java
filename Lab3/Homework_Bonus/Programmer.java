package Homework_Bonus;
import java.util.*;
import java.time.LocalDate;

class Programmer extends Person {
    private ProgrammingLanguage language;

    public Programmer(String name, Date birthDate, ProgrammingLanguage language) {
        super(name, birthDate);
        this.language = language;
    }

    public ProgrammingLanguage getLanguage() {
        return this.language;
    }
}