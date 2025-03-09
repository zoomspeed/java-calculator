package com.calculator.calculator.calculatorcli;
import com.calculator.calculator.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorCLITests {

    private CalculatorCLI calculatorCLI;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        CalculatorService mockService = Mockito.mock(CalculatorService.class);
        Mockito.when(mockService.compute(3.0, "+", 5.0)).thenReturn(8.0);
        Mockito.when(mockService.compute(10.0, "/", 2.0)).thenReturn(5.0);

        calculatorCLI = new CalculatorCLI(mockService);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testCLIAddition() {
        String input = "3 + 5\nexit\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        calculatorCLI.runCLI();

        assertTrue(outContent.toString().contains("Result: 8.0"));
    }

    @Test
    void testCLIDivision() {
        String input = "10 / 2\nexit\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        calculatorCLI.runCLI();

        assertTrue(outContent.toString().contains("Result: 5.0"));
    }

    @Test
    void testCLIExitCommand() {
        String input = "exit\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        calculatorCLI.runCLI();

        assertTrue(outContent.toString().contains("Exiting CLI..."));
    }
}