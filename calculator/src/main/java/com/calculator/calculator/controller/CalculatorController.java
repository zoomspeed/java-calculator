package com.calculator.calculator.controller;

import com.calculator.calculator.command.OperationCommand;
import com.calculator.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/compute")
    public double compute(@RequestBody OperationCommand operationCommand) {
        return calculatorService.compute(
                operationCommand.getOperation1(),
                operationCommand.getOperator(),
                operationCommand.getOperation2()
        );
    }
}
