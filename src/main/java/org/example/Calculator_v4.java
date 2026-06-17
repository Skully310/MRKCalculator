package org.example;
import java.util.Scanner;

public class Calculator_v4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalc = true;                                    // Reset fürs Beenden des Rechners

        System.out.println("Welcome to my Calculator!");

        while (continueCalc) {                                          // Schleife für mehrfaches Rechnen
            System.out.println("\n--- New Calculation ---");            // Bisschen Text
            System.out.println("Enter the first number:");

            if (!scanner.hasNextDouble()) {                             // Prüfen ob die Eingabe wirklich eine Zahl ist
                System.out.println("Error: Invalid number!");           // Falsche Eingabe
                scanner.next();
                continue;
            }
            double n1 = scanner.nextDouble();

            System.out.println("Enter an operator (+, -, *, /):");      // Prüfen ob die Eingabe ein valider Operator ist
            char operator = scanner.next().charAt(0);
            if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                System.out.println("Error: Invalid operator!");
                continue;
            }


            System.out.println("Enter the second number:");
            if (!scanner.hasNextDouble()) {
                System.out.println("Error: Invalid number!");
                scanner.next();
                continue;
            }
            double n2 = scanner.nextDouble();

            double value = 0;
            boolean error = false;

            switch (operator) {
                case '+':
                    value = n1 + n2;
                    break;
                case '-':
                    value = n1 - n2;
                    break;
                case '*':
                    value = n1 * n2;
                    break;
                case '/':
                    if (n2 != 0) {
                        value = n1 / n2;
                    } else {
                        System.out.println("Error: Division by zero is not allowed!");
                        error = true;
                    }
                    break;
            }

            if (!error) {
                System.out.println(n1 + " " + operator + " " + n2 + " = " + value);
            }


            System.out.println("\nDo you want to perform another calculation? (y/n)");  // Abfragen, ob weiter gerechnet werden soll
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("n")) {
                continueCalc = false;
                System.out.println("Calculator closed. Goodbye!");
            }
        }
        scanner.close();
    }
}