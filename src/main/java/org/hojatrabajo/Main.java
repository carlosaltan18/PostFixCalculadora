package org.hojatrabajo;

import org.hojatrabajo.interfaces.Calc;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Main program for evaluating postfix expressions from a file.
 * @author Sergio & Carlos
 */
public class Main {

    /**
     * Reads and evaluates postfix expressions from datos.txt.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        String filePath = "file/datos.txt";

        LectorArchivo reader = new LectorArchivo(filePath);
        Calc calculator = new PostfixCalculator();

        try {
            List<String> expressions = reader.leerLineas();

            if (expressions.isEmpty()) {
                System.out.println("No expressions found to evaluate");
                return;
            }

            System.out.println("=== Postfix Calculator ===");
            System.out.println();

            for (String expression : expressions) {
                System.out.println("Expression: " + expression);
                double result = calculator.operate(expression);

                if (result != 0.0) {
                    System.out.println("Result: " + result);
                    System.out.println("Status: Success");
                } else {
                    System.out.println("Status: Error occurred");
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found at path '" + filePath + "'");
        } catch (IOException e) {
            System.err.println("Error: Could not read file");
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}