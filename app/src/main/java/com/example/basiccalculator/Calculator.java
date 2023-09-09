package com.example.basiccalculator;

import java.util.Arrays;

public class Calculator {

    private static char[] operators = {'×', '÷', '%', '+', '−'};

    public static int last_char(String screen_text) {
        if (screen_text.isEmpty())
            return -1;
        char last = screen_text.charAt(screen_text.length() - 1);
        if (last == '+' || last == '−' || last == '÷' || last == '×' || last == '%' || last == ' ')
            return 1;
        else
            return 0;
    }

    public static String del(String screen_text) {
        if (screen_text.charAt(screen_text.length() - 1) == ' ')
            return screen_text.substring(0, screen_text.length() - 3);
        else
            return screen_text.substring(0, screen_text.length() - 1);
    }

    private static float add(float num1, float num2) {
        return (num1 + num2);
    }

    private static float subtract(float num1, float num2) {
        return (num1 - num2);
    }

    private static float mult(float num1, float num2) {
        return (num1 * num2);
    }

    private static float div(float num1, float num2) {
        if (num2 != 0)
            return (num1 / num2);
        else
            throw new IllegalArgumentException("Division by zero is not allowed.");
    }

    private static float mod(float num1, float num2) {
        return (num1 % num2);
    }

    public static float Calculate(String num1, String num2, char operation) {

        Float number1 = Float.parseFloat(num1);
        Float number2 = Float.parseFloat(num2);

        if (operation == '×')
            return mult(number1, number2);
        if (operation == '÷')
            return div(number1, number2);
        if (operation == '%')
            return mod(number1, number2);
        if (operation == '+')
            return add(number1, number2);
        if (operation == '−')
            return subtract(number1, number2);

        return 1;
    }

    public static String performOperation(String screen_text, char operation) {
        String op = " \\" + operation + " ";
        String[] numbers_sybols = screen_text.split(op, 2);

        String[] left = numbers_sybols[0].split(" ");
        String[] right = numbers_sybols[1].split(" ");

        float result = Calculate(left[left.length - 1], right[0], operation);

        left = Arrays.copyOf(left, left.length - 1);
        screen_text = String.join(" ", left);
        right = Arrays.copyOfRange(right, 1, right.length);
        screen_text += " " + result + " ";
        screen_text += String.join(" ", right);

        return screen_text;
    }

    public static String calculateResult(String screen_text) throws Exception {
        if (last_char(screen_text) == 0) {
            for (char operator : operators)
                while (screen_text.contains(String.valueOf(operator)))
                    screen_text = performOperation(screen_text, operator);
        } else {
            throw new Exception("Make Sure from your Calculation");
        }

        return formatResult(Float.parseFloat(screen_text));
    }

    private static String formatResult(float result) {
        // Format the result if needed
        if (result % 1 == 0) {
            int intResult = Math.round(result);
            return String.valueOf(intResult);
        }
        return String.valueOf(result);
    }
}
