package ru.sbercourses.operation;

import java.util.function.BinaryOperator;

public class OperationImp implements Operation<Double, Character> {
    private static final BinaryOperator<Double> plus = Double::sum;
    private static final BinaryOperator<Double> minus = (firstDouble, secoundDouble) -> firstDouble - secoundDouble;
    private static final BinaryOperator<Double> div = (firstDouble, secoundDouble) -> firstDouble / secoundDouble;
    private static final BinaryOperator<Double> mul = (firstDouble, secoundDouble) -> firstDouble * secoundDouble;
    private static final BinaryOperator<Double> pow = (first, pow) -> {
        for (int i = 1; i < pow; i++) {
            first *= first;
        }
        return first;
    };

    @Override
    public Double calculate(Double operand1, Character operator, Double operand2) {
        switch (operator) {
            case '+':
                return (plus.apply(operand1, operand2));
            case '-':
                return (minus.apply(operand1, operand2));
            case '*':
                return (mul.apply(operand1, operand2));
            case '/':
                return (div.apply(operand1, operand2));
            case '^':
                return (pow.apply(operand1, operand2));
            default:
                return null;
        }
    }
}
