package org.hojatrabajo;

import org.hojatrabajo.interfaces.Calc;
import org.hojatrabajo.interfaces.Stack;

/**
 * Calculator implementation that evaluates Postfix expressions
 * @author Sergio
 */
public class PostfixCalculator implements Calc {

    @Override
    public double operate(String input) {
        Stack<Double> stack = new StackVector<>();

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (character == ' ') {
                continue;
            }

            if (Character.isDigit(character)) {
                stack.push((double) (character - '0'));
            }
            else if (isOperator(character)) {
                try {
                    if (stack.peek() == null) {
                        throw new IllegalArgumentException("Insufficient operands :(");
                    }
                    Double operandB = stack.pop();

                    if (stack.peek() == null) {
                        throw new IllegalArgumentException("Insufficient operands :(");
                    }
                    Double operandA = stack.pop();

                    double result = calculate(operandA, operandB, character);
                    stack.push(result);

                } catch (Exception e) {
                    System.err.println("Error calculating: " + e.getMessage());
                    return 0.0;
                }
            }
            else {
                System.err.println("Error: Invalid character detected :(");
                return 0.0;
            }
        }

        Double finalResult = stack.pop();

        if (stack.peek() != null) {
            System.err.println("Error calculating: Insufficient operators :(");
            return 0.0;
        }

        return finalResult;
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private double calculate(double a, double b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Division by zero :/ ");
                return a / b;
            default: return 0;
        }
    }
}