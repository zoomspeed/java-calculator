package com.calculator.calculator.calculatorapp;

import com.calculator.calculator.operation.Operation;
import com.calculator.calculator.operation.OperationFactory;

class Calculator {
    public static double calculate(String expression) {
        String[] parts = expression.split(" ");
        if (parts.length != 3) throw new IllegalArgumentException("Invalid input format");

        double operand1 = Double.parseDouble(parts[0]);
        String operator = parts[1];
        double operand2 = Double.parseDouble(parts[2]);

        Operation operation = OperationFactory.getOperation(operator);
        return operation.apply(operand1, operand2);
    }
}