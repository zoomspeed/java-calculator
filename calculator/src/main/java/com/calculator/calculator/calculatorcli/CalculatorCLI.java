package com.calculator.calculator.calculatorcli;

import com.calculator.calculator.service.CalculatorService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CalculatorCLI implements ApplicationRunner {
    private final CalculatorService calculatorService;

    public CalculatorCLI(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Override
    public void run(ApplicationArguments args) {
        if (args.getSourceArgs().length > 0) {
            runCLI();
        }
    }

    private void runCLI() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("CLI Calculator started. Enter 'exit' to quit.");

        while (true) {
            System.out.print("Enter operation (ex: 3 + 5): ");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Exiting CLI...");
                break;
            }

            try {
                String[] parts = input.split(" ");
                if (parts.length != 3) {
                    throw new IllegalArgumentException("Invalid format. Use: number operator number");
                }

                double operand1 = Double.parseDouble(parts[0]);
                String operator = parts[1];
                double operand2 = Double.parseDouble(parts[2]);

                double result = calculatorService.compute(operand1, operator, operand2);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}