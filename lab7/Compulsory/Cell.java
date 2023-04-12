package org.example;

import java.util.*;

public class Cell {
    private List<Token> tokens;

    public Cell() {
        this.tokens = null;
    }

    public boolean isVisited() {
        return tokens != null;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
