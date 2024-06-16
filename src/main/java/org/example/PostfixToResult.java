package org.example;

import java.util.List;
import java.util.Stack;

public class PostfixToResult {

    private final Stack<Integer> l = new Stack<>();
    private final List<String> tokens;

    public PostfixToResult(List<String> tokens) {
        this.tokens = tokens;
    }

    public int doResult(){
        for (String q : tokens) {
            int i2;
            int i1;
            switch (q) {
                case "/" -> {
                    i2 = l.pop();
                    i1 = l.pop();
                    l.add((i1 / i2));
                }
                case "*" -> {
                    i2 = l.pop();
                    i1 = l.pop();
                    l.add((i1 * i2));
                }
                case "-" -> {
                    i2 = l.pop();
                    i1 = l.pop();
                    l.add((i1 - i2));
                }
                case "+" -> {
                    i2 = l.pop();
                    i1 = l.pop();
                    l.add((i1 + i2));
                }
                default -> l.add(Integer.parseInt(q));
            }
        }

        return l.pop();
    }
}
