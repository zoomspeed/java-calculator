package com.calculator.calculator.operation;

public class Division implements Operation {
    public double apply(double a, double b) {
        if (b == 0) throw new ArithmeticException("Division by zero");
        return a / b;
    }
}
