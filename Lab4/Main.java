package Homework_Bonus;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        Network network = new Network();

        Person andrei = new Person("Andrei", new Date());
        Programmer bogdan = new Programmer("Bogdan", new Date(),ProgrammingLanguage.C);
        Designer cristina = new Designer("Cristina", new Date(),DesignTool.PHOTOSHOP);
        Programmer dan = new Programmer("Dan", new Date(), ProgrammingLanguage.C);


        Company google = new Company("Google", Industry.SOFTWARE);
        Company centric = new Company("Centric", Industry.SOFTWARE);
        Company arcadia= new Company("Arcadia", Industry.HEALTHCARE);
        Company brd= new Company("BRD", Industry.FINANCE);
        Company continental= new Company("Continental", Industry.AUTOMOTIVE);


        andrei.addFriend(bogdan);
        bogdan.addFriend(cristina);
        cristina.addFriend(andrei);

        andrei.addCompany(google);
        bogdan.addCompany(centric);
        cristina.addCompany(continental);
        dan.addCompany(continental);

        network.addNode(andrei);
        network.addNode(bogdan);
        network.addNode(cristina);
        network.addNode(dan);

        network.addNode(google);
        network.addNode(centric);
        network.addNode(brd);
        network.addNode(continental);
        network.addNode(arcadia);

        network.printNetwork();


    }

    }