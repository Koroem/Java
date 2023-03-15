package Compulsory;
import java.util.*;

public class Main {
    public static void main(String[] args) {

                List<Node> nodes = new ArrayList<>();

                Person ana = new Person("Ana");
                Person bogdan = new Person("Bogdan");
                Person catalin = new Person("Catalin");

                Company amazon=new Company("Amazon");
                Company google = new Company("Google");
                Company microsoft = new Company("Microsoft");

                ana.addFriend(bogdan);
                ana.addFriend(catalin);

                google.addEmployee(ana);
                microsoft.addEmployee(bogdan);
                microsoft.addEmployee(catalin);

                nodes.add(ana);
                nodes.add(bogdan);
                nodes.add(catalin);

                nodes.add(amazon);
                nodes.add(google);
                nodes.add(microsoft);

            for (Node node : nodes) {
                System.out.println(node.getName());
            }

            }
}