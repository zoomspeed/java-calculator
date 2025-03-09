package com.calculator.calculator.operation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class OperationFactoryTest {

    private OperationFactory operationFactory;

    @BeforeEach
    void setUp() {
        operationFactory = new OperationFactory();
    }

    @Test
    void testGetAdditionOperation() {
        Operation operation = operationFactory.getOperation("+");
        assertEquals(8.0, operation.apply(3.0, 5.0));
    }

    @Test
    void testGetSubtractionOperation() {
        Operation operation = operationFactory.getOperation("-");
        assertEquals(2.0, operation.apply(7.0, 5.0));
    }

    @Test
    void testGetMultiplicationOperation() {
        Operation operation = operationFactory.getOperation("*");
        assertEquals(15.0, operation.apply(3.0, 5.0));
    }

    @Test
    void testGetDivisionOperation() {
        Operation operation = operationFactory.getOperation("/");
        assertEquals(2.0, operation.apply(10.0, 5.0));
    }

    @Test
    void testDivisionByZero() {
        Operation operation = operationFactory.getOperation("/");
        Exception exception = assertThrows(ArithmeticException.class, () -> operation.apply(10.0, 0.0));
        assertEquals("Division by zero", exception.getMessage());
    }

    @Test
    void testUnsupportedOperation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> operationFactory.getOperation("^"));
        assertEquals("Unsupported operation", exception.getMessage());
    }
}