package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixToPostfix {

    private final Stack<Character> operation = new Stack<>();
    private final StringBuilder calculations = new StringBuilder();
    private final List<String> tokens = new ArrayList<>();
    private final String values;
    private final int length;

    public InfixToPostfix(String values, int length) {
        this.values = values;
        this.length = length;
    }

    public List<String> doPostfix(){
        for (int i = 0; i < length; i++) {
            char a = values.charAt(i);

            if (Character.isDigit(a)) {
                calculations.append(a);
            }
            else {
                tokens.add(calculations.toString());
                calculations.setLength(0);

                if (a == '*' || a == '/') {
                    if (operation.isEmpty()) operation.add(a);
                    else if (operation.peek() == '*' || operation.peek() == '/') {
                        tokens.add(""+operation.pop());
                        operation.add(a);
                    } else operation.add(a);
                }
                if (a == '+' || a == '-') {
                    if (operation.isEmpty()) operation.add(a);
                    else {
                        while (!operation.isEmpty()) {
                            tokens.add(""+operation.pop());
                        }
                        operation.add(a);
                    }
                }
            }
        }

        while (!operation.isEmpty()) {
            tokens.add(""+operation.pop());
        }

        return tokens;
    }
}
