package org.hojatrabajo;

import org.hojatrabajo.interfaces.Calc;
import org.hojatrabajo.interfaces.Stack;

/**
 * Calculator implementation that evaluates Postfix expressions
 * @author Sergio
 */
public class PostfixCalculator implements Calc {

    /**
     * Operate a exprexion in a value of string
     * @param input
     * @return double
     */
    @Override
    public double operate(String input) {
        Stack<Double> stack = new StackImplemets<>();

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

                    double result = calculate(operandA, operandB, token.charAt(0));
                    stack.push(result);

                } catch (ArithmeticException e) {
                    System.err.println("Error: " + e.getMessage());
                    return 0.0;
                } catch (RuntimeException e) {
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

            try {
                stack.pop();
                System.err.println("Error calculating: Insufficient operators :(");
                return 0.0;
            } catch (RuntimeException e) {
                return finalResult;
            }

        } catch (RuntimeException e) {
            System.err.println("Error: Empty expression");
            return 0.0;
        }
    }

    /**
     * mverify if string contains number
     * @param token
     * @return true or false
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
     * boolean method to verify if a char is operator
     * @param c
     * @return true or false
     */
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * A methot to calculte is the char is an operator
     * @param a
     * @param b
     * @param operator
     * @return double
     */
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