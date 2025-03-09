package com.calculator.calculator.operation;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OperationFactory {
    private static final Map<String, Operation> operations = new HashMap<>();

    static {
        operations.put("+", new Addition());
        operations.put("-", new Subtraction());
        operations.put("*", new Multiplication());
        operations.put("/", new Division());
    }

    public static Operation getOperation(String operator) {
        if (!operations.containsKey(operator)) throw new IllegalArgumentException("Unsupported operation");
        return operations.get(operator);
    }
}
