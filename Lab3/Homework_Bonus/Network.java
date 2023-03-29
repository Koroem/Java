package Homework_Bonus;
import java.util.*;
import java.time.LocalDate;

class Network {
    private List<Node> nodes;

    public Network() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public List<Node> getNodes() {
        return this.nodes;
    }

    public int getNodeImportance(Node node) {
        int count = 0;

        for (Node otherNode : this.nodes) {
            if (otherNode == node) {
                continue;
            }
            Map<Node, Position> relationships = node.getRelationships();
            if (relationships.containsKey(otherNode)) {
               count++;
            }
        }
        return count;
    }
    public void printNetwork(){
        List<Node> nodes = this.getNodes();
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                Node node1 = nodes.get(i);
                Node node2 = nodes.get(j);
                int importance1 = this.getNodeImportance(node1);
                int importance2 = this.getNodeImportance(node2);
                if (importance2 > importance1) {
                    nodes.set(i, node2);
                    nodes.set(j, node1);
                }
            }
        }

        for (Node node : nodes) {
            System.out.println(node.getName() + " -> Importance: " + this.getNodeImportance(node));
        }
    }
}