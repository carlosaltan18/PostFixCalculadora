package org.hojatrabajo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for PostfixCalculator.
 * @author Sergio
 */
public class PostfixCalculatorTest {

    private PostfixCalculator calculator;

    /**
     * Sets up calculator before each test.
     */
    @Before
    public void setUp() {
        calculator = new PostfixCalculator();
    }

    /**
     * Tests simple addition: 1 2 + = 3.
     */
    @Test
    public void testSimpleAddition() {
        double result = calculator.operate("1 2 +");
        assertEquals(3.0, result, 0.001);
    }

    /**
     * Tests simple subtraction: 5 3 - = 2.
     */
    @Test
    public void testSimpleSubtraction() {
        double result = calculator.operate("5 3 -");
        assertEquals(2.0, result, 0.001);
    }

    /**
     * Tests simple multiplication: 4 3 * = 12.
     */
    @Test
    public void testSimpleMultiplication() {
        double result = calculator.operate("4 3 *");
        assertEquals(12.0, result, 0.001);
    }

    /**
     * Tests simple division: 8 2 / = 4.
     */
    @Test
    public void testSimpleDivision() {
        double result = calculator.operate("8 2 /");
        assertEquals(4.0, result, 0.001);
    }

    /**
     * Tests complex expression: 1 2 + 4 * 3 + = 15.
     */
    @Test
    public void testComplexExpression() {
        double result = calculator.operate("1 2 + 4 * 3 +");
        assertEquals(15.0, result, 0.001);
    }

    /**
     * Tests expression: 6 2 3 + * = 30.
     */
    @Test
    public void testComplexExpression2() {
        double result = calculator.operate("6 2 3 + *");
        assertEquals(30.0, result, 0.001);
    }

    /**
     * Tests assignment example: 5 6 + 7 * = 77.
     */
    @Test
    public void testAssignmentExample() {
        double result = calculator.operate("5 6 + 7 *");
        assertEquals(77.0, result, 0.001);
    }

    /**
     * Tests division by zero handling.
     */
    @Test
    public void testDivisionByZero() {
        double result = calculator.operate("5 0 /");
        assertEquals("Division by zero should return 0.0", 0.0, result, 0.001);
    }

    /**
     * Tests insufficient operands error.
     */
    @Test
    public void testInsufficientOperands() {
        double result = calculator.operate("5 +");
        assertEquals("Insufficient operands should return 0.0", 0.0, result, 0.001);
    }

    /**
     * Tests insufficient operators error.
     */
    @Test
    public void testInsufficientOperators() {
        double result = calculator.operate("5 6 7");
        assertEquals("Insufficient operators should return 0.0", 0.0, result, 0.001);
    }

    /**
     * Tests invalid character handling.
     */
    @Test
    public void testInvalidCharacter() {
        double result = calculator.operate("5 5 &");
        assertEquals("Invalid character should result in 0.0", 0.0, result, 0.001);
    }

    /**
     * Tests empty expression handling.
     */
    @Test
    public void testEmptyExpression() {
        double result = calculator.operate("");
        assertEquals("Empty expression should return 0.0", 0.0, result, 0.001);
    }

    /**
     * Tests expression with only spaces.
     */
    @Test
    public void testOnlySpaces() {
        double result = calculator.operate("   ");
        assertEquals("Expression with only spaces should return 0.0", 0.0, result, 0.001);
    }

    /**
     * Tests decimal numbers: 2.5 3.5 + = 6.0.
     */
    @Test
    public void testDecimalNumbers() {
        double result = calculator.operate("2.5 3.5 +");
        assertEquals(6.0, result, 0.001);
    }

    /**
     * Tests negative result: 3 5 - = -2.
     */
    @Test
    public void testNegativeResult() {
        double result = calculator.operate("3 5 -");
        assertEquals(-2.0, result, 0.001);
    }

    /**
     * Tests long expression with multiple operations.
     */
    @Test
    public void testLongExpression() {
        double result = calculator.operate("15 7 1 1 + - / 3 * 2 1 1 + + -");
        assertEquals(5.0, result, 0.001);
    }
}