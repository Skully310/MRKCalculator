package org.example;
import java.util.Scanner;

public class Calculator_v3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number:");
        double n1 = scanner.nextDouble();

        System.out.println("Enter an operator (+, -, *, /):");
        char operator = scanner.next().charAt(0);       // char da der Scanner keine einzelnen bestimmten Zeichen speichern kann
                                                        // charAt(0) nimmt den ersten Buchstaben
        System.out.println("Enter the second number:");
        double n2 = scanner.nextDouble();

        double value = 0;
        boolean error = false;                          // Error auf false setzen um Errormessage nicht zu triggern

        switch (operator) {                             // switch um die bestimmte Rechenweise auszuwählen
            case '+':                                   // Prüfstelle
                value = n1 + n2;                        // Rechnen mit nur noch einem Value
                break;                                  // WICHTIG!! beendet die Rechenoperation
            case '-':
                value = n1 - n2;
                break;
            case '*':
                value = n1 * n2;
                break;
            case '/':
                if (n2 != 0) {                          // "!=" = Ungleich // Prüfstelle ob, durch 0 geteilt wird
                    value = n1 / n2;
                } else {                                // Ausgabe falls, durch 0 geteilt wird
                    System.out.println("Error: Division by zero is not allowed!");
                    error = true;
                }
                break;
            default:                                    // standard Antwort
                System.out.println("Error: Invalid operator!");
                error = true;
        }

        if (!error) {                                   // Falls Error nicht auf true gesetzt wurde, wird das Ergebnis nun ausgespuckt
            System.out.println(n1 + " " + operator + " " + n2 + " = " + value);
        }                                               // "+" ist wichtig da Java sonst nicht versteht wie es die Variablen ausgeben soll

        scanner.close();
    }
}