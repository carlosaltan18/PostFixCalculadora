package org.hojatrabajo;

import org.hojatrabajo.interfaces.Calc;
import org.hojatrabajo.interfaces.Stack;

/**
 * Evaluates postfix expressions using a stack-based algorithm.
 * @author Sergio
 */
public class PostfixCalculator implements Calc {

    /**
     * Evaluates a postfix expression.
     * @param input postfix expression with space-separated tokens
     * @return result of evaluation, or 0.0 if error occurs
     */
    @Override
    public double operate(String input) {
        Stack<Double> stack = new StackVector<>(100);
        String[] tokens = input.split(" ");

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }

            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            }
            else if (token.length() == 1 && isOperator(token.charAt(0))) {
                try {
                    Double operandB = stack.pop();
                    Double operandA = stack.pop();

                    if (operandA == null || operandB == null) {
                        System.err.println("Error calculating: Insufficient operands :(");
                        return 0.0;
                    }

                    double result = calculate(operandA, operandB, token.charAt(0));
                    stack.push(result);
                } catch (ArithmeticException e) {
                    System.err.println("Error: " + e.getMessage());
                    return 0.0;
                } catch (Exception e) {
                    System.err.println("Error calculating: Insufficient operands :(");
                    return 0.0;
                }
            }
            else {
                System.err.println("Error: Invalid character detected :(");
                return 0.0;
            }
        }

        try {
            Double finalResult = stack.pop();

            if (finalResult == null) {
                System.err.println("Error: Empty expression");
                return 0.0;
            }

            Double remaining = stack.peek();
            if (remaining != null) {
                System.err.println("Error calculating: Insufficient operators :(");
                return 0.0;
            }

            return finalResult;
        } catch (Exception e) {
            System.err.println("Error: Empty expression");
            return 0.0;
        }
    }

    /**
     * Checks if a token is a valid number.
     * @param token string to check
     * @return true if token is a number
     */
    private boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks if a character is a valid operator.
     * @param c character to check
     * @return true if c is +, -, *, or /
     */
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * Performs arithmetic operation on two operands.
     * @param a first operand
     * @param b second operand
     * @param operator arithmetic operator
     * @return result of operation
     * @throws ArithmeticException if division by zero
     */
    private double calculate(double a, double b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            default: return 0;
        }
    }
}