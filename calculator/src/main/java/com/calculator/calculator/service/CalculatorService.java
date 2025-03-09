package com.calculator.calculator.service;

import com.calculator.calculator.operation.OperationFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    private final OperationFactory operationFactory;

    public CalculatorService(OperationFactory operationFactory) {
        this.operationFactory = operationFactory;
    }

    public double compute(double operand1, String operator, double operand2) {
        return operationFactory.getOperation(operator).apply(operand1, operand2);
    }
}