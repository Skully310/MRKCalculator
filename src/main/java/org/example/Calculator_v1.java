package org.example;


public class Calculator_v1 {
    public static void main() {
        double n1 = 5;                                  // Zahl 1
        double n2 = 8;                                  // Zahl 2

        double valueA ;                                 // Neue Variable erstellen, um das Ergebniss abzuspeichern
        double valueS ;
        double valueM ;
        double valueD ;

        valueA = n1 + n2;                               // Rechnen
        valueS = n1 - n2;
        valueM = n1 * n2;
        valueD = n1 / n2;

        System.out.println("Addition = " + valueA);     // Ergebnis
        System.out.println("Subtraction = " + valueS);
        System.out.println("Multiplication = " + valueM);
        System.out.println("Division = " + valueD);
    }
}