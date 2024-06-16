package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String values = scanner.next();
        int length = values.length();
        scanner.close();

        InfixToPostfix infixToPostfix = new InfixToPostfix(values, length);

        List<String> tokens = infixToPostfix.doPostfix();

        PostfixToResult postfixToResult = new PostfixToResult(tokens);

        int answer = postfixToResult.doResult();

        System.out.println(answer);
    }
}