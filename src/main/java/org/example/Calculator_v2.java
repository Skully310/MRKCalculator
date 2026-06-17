package org.example;

import java.util.Scanner;                               // Scanner util um variable Zahlen einzugeben

public class Calculator_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);       // Scanner starten und bereit machen für input

        System.out.println("Enter the first number:");  // Eingabeaufforderung
        double n1 = scanner.nextDouble();               // Auslesen der nächsten "double" Zahl und speichern in n1

        System.out.println("Enter the second number:");
        double n2 = scanner.nextDouble();

        double valueA ;
        double valueS ;
        double valueM ;
        double valueD ;

        valueA = n1 + n2;
        valueS = n1 - n2;
        valueM = n1 * n2;
        valueD = n1 / n2;

        System.out.println("Addition = " + valueA);
        System.out.println("Subtraction = " + valueS);
        System.out.println("Multiplication = " + valueM);
        System.out.println("Division = " + valueD);

        scanner.close();
    }
}