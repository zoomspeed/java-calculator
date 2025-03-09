package com.calculator.calculator.calculatorapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAddition() {
        assertEquals(8.0, Calculator.calculate("3 + 5"));
    }

    @Test
    void testSubtraction() {
        assertEquals(2.0, Calculator.calculate("7 - 5"));
    }

    @Test
    void testMultiplication() {
        assertEquals(15.0, Calculator.calculate("3 * 5"));
    }

    @Test
    void testDivision() {
        assertEquals(2.0, Calculator.calculate("10 / 5"));
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> Calculator.calculate("10 / 0"));
        assertEquals("Division by zero", exception.getMessage());
    }

    @Test
    void testInvalidInputFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Calculator.calculate("3 5"));
        assertEquals("Invalid input format", exception.getMessage());
    }

    @Test
    void testInvalidOperator() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Calculator.calculate("3 ^ 5"));
        assertEquals("Unsupported operation", exception.getMessage());
    }
}