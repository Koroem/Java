package Homework_Bonus;

import java.util.Map;

public interface Node {
    String getName();
    Map<Node, Position> getRelationships();
}
