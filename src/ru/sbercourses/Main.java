package ru.sbercourses;

import ru.sbercourses.converter.InfixToPostfixConverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку для расчета без пробелов: ");
        String infixExpression = scanner.nextLine();
        var postfixList = InfixToPostfixConverter.infixToPostfix(infixExpression);
        var result = Calculator.countPostfixExpression(postfixList);
        if (result != null) {
            System.out.println("Результат расчета: " + result);
        }

    }
}
