package Homework_Bonus;
import java.util.*;
import java.time.LocalDate;

class Designer extends Person {
    private DesignTool tool;

    public Designer(String name, Date birthDate, DesignTool tool) {
        super(name, birthDate);
        this.tool = tool;
    }

    public DesignTool getDesignSpecialty() {
        return this.tool;
    }
}