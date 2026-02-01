package org.hojatrabajo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the PostfixCalculator logic
 */
public class PostfixCalculatorTest {

    private final PostfixCalculator calculator = new PostfixCalculator();

    @Test
    public void testSimpleAddition() {
        double result = calculator.operate("1 2 +");
        assertEquals(3.0, result, 0.001);
    }

    @Test
    public void testComplexExpression() {
        double result = calculator.operate("1 2 + 4 * 3 +");
        assertEquals(15.0, result, 0.001);
    }

    @Test
    public void testDivision() {
        double result = calculator.operate("8 2 /");
        assertEquals(4.0, result, 0.001);
    }

    @Test
    public void testDivisionByZero() {
        double result = calculator.operate("5 0 /");
        assertEquals("Division by zero should return 0.0 ", 0.0, result, 0.001);
    }

    @Test
    public void testInsufficientOperands() {
        double result = calculator.operate("5 +");
        assertEquals("Insufficient operands should return 0.0", 0.0, result, 0.001);
    }

    @Test
    public void testInvalidCharacter() {
        double result = calculator.operate("5 5 &");
        assertEquals("Invalid character should result in 0.0", 0.0, result, 0.001);
    }
}