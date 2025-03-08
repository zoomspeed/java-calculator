package com.calculator.calculator.calculatorapp;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

class Calculator {
    private static final Map<String, BiFunction<Double, Double, Double>> operations = new HashMap<>();

    static {
        operations.put("+", (a, b) -> a + b);
        operations.put("-", (a, b) -> a - b);
        operations.put("*", (a, b) -> a * b);
        operations.put("/", (a, b) -> {
            if (b == 0) throw new ArithmeticException("Division by zero");
            return a / b;
        });
    }

    public static double calculate(String expression) {
        String[] parts = expression.split(" ");
        if (parts.length != 3) throw new IllegalArgumentException("Invalid input format");

        double operand1 = Double.parseDouble(parts[0]);
        String operator = parts[1];
        double operand2 = Double.parseDouble(parts[2]);

        if (!operations.containsKey(operator)) throw new IllegalArgumentException("Unsupported operation");

        return operations.get(operator).apply(operand1, operand2);
    }
}