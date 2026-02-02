package org.hojatrabajo;

import org.hojatrabajo.interfaces.Calc;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *  Main class of PostFix calculator
 */
public class Main {
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

            System.out.println("Postfix Calculator");
            for (String expression : expressions) {
                double result = calculator.operate(expression);
                if (result != 0.0) {
                    System.out.println("Infix: " + expression);
                    System.out.println("Result: " + result);
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found ");
        } catch (IOException e) {
            System.err.println("Input/Output failure");
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}