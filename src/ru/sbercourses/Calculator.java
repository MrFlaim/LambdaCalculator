package ru.sbercourses;

import ru.sbercourses.operation.Operation;
import ru.sbercourses.operation.OperationImp;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class Calculator {
    private static Operation<Double, Character> operation = new OperationImp();

    public static Double countPostfixExpression(List<String> postfixExpression) {
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < postfixExpression.size(); i++) {
            String element = postfixExpression.get(i);
            if (isNumeric(element)) {
                stack.push(Double.parseDouble(element));
            } else if (element.equals("--")) {
                if (i + 1 < postfixExpression.size() && isNumeric(postfixExpression.get(i + 1))) {
                    double operand = Double.parseDouble(postfixExpression.get(i + 1));
                    stack.push(-operand);
                    i++;
                }
            } else {
                try {
                    double operand2 = stack.pop();
                    double operand1 = stack.pop();
                    stack.push(operation.calculate(operand1, element.charAt(0), operand2));
                } catch (EmptyStackException e) {
                    System.out.println("Введено несоответствующее количество операторов");
                    return null;
                }
            }
        }
        return stack.pop();
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+(\\.\\d+)?");
    }
}
