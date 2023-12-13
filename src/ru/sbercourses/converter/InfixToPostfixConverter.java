package ru.sbercourses.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixToPostfixConverter {
    public static List<String> infixToPostfix(String infixExpression) {
        List<String> postfixExpression = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < infixExpression.length(); i++) {
            char ch = infixExpression.charAt(i);
            if (ch == '-' && (i == 0 || !Character.isDigit(infixExpression.charAt(i - 1)))) {
                postfixExpression.add("--");
            } else if (Character.isDigit(ch)) {
                StringBuilder currentNumber = new StringBuilder();
                while (i < infixExpression.length() &&
                        (Character.isDigit(infixExpression.charAt(i)) || infixExpression.charAt(i) == '.')) {
                    currentNumber.append(infixExpression.charAt(i));
                    i++;
                }
                i--;
                postfixExpression.add(currentNumber.toString());
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfixExpression.add(String.valueOf(stack.pop()));
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.peek())) {
                    postfixExpression.add(String.valueOf(stack.pop()));
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            postfixExpression.add(String.valueOf(stack.pop()));
        }

        return postfixExpression;
    }

    private static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}
