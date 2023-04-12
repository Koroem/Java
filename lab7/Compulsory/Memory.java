package org.example;

import java.util.*;

public class Memory {
    private final Queue<Token> tokens;

    public Memory(int n) {
        tokens = new LinkedList<>();
        for (int i = 1; i <= n * n * n; i++) {
            tokens.add(new Token(i));
        }
        Collections.shuffle((List<?>) tokens);
    }

    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            extracted.add(tokens.poll());
        }
        return extracted;
    }
}
