package org.example;
import java.util.Scanner;

public class Multitool_v1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean mainmenu = true;

        System.out.println("Welcome to the Multi-Tool App!");

            while (mainmenu) {
                System.out.println("\n===== MAIN MENU =====");
                System.out.println("1. Calculator");
                System.out.println("2. Converter");
                System.out.println("3. Exit");
                System.out.print("Please choose an option (1-3): ");

                String choice = scanner.next();

                switch (choice) {
                    case "1" -> runCalculator(scanner);
                    case "2" -> runConverter(scanner);
                    case "3" -> {
                        mainmenu = false;
                        System.out.println("\nThank you for using the app. Goodbye!");
                    }
                    default -> System.out.println("\nError: Invalid choice! Please enter 1, 2, or 3.");
                }
            }
            scanner.close();
        }


    public static void runCalculator(Scanner scanner) {
        boolean continueCalc = true;
        System.out.println("\n===== CALCULATOR =====");

        while (continueCalc) {
            System.out.println("\n--- New Calculation ---");
            System.out.println("Enter the first number:");

            if (!scanner.hasNextDouble()) {
                System.out.println("Error: Invalid number!");
                scanner.next();
                continue;
            }
            double n1 = scanner.nextDouble();

            System.out.println("Enter an operator (+, -, *, /, ^, %, v [Root]):");
            char operator = scanner.next().charAt(0);

            boolean isValid = switch (operator) {
                case '+', '-', '*', '/', '^', '%', 'v' -> true;
                default -> false;
            };

            if (!isValid) {
                System.out.println("Error: Invalid operator!");
                continue;
            }

            double n2 = 0;
            boolean needSecondNumber = (operator != 'v');
            if (needSecondNumber) {
                System.out.println("Enter the second number:");
                if (!scanner.hasNextDouble()) {
                    System.out.println("Error: Invalid number!");
                    scanner.next();
                    continue;
                }
                n2 = scanner.nextDouble();
            }
                double value = 0;
                boolean error = false;

                switch (operator) {
                    case '+' -> value = n1 + n2;
                    case '-' -> value = n1 - n2;
                    case '*' -> value = n1 * n2;
                    case '/' -> {
                        if (n2 != 0) {
                            value = n1 / n2;
                        } else {
                            System.out.println("Error: Division by zero is not allowed!");
                            error = true;
                        }
                    }
                    case '^' -> value = Math.pow(n1, n2);
                    case '%' -> {
                        if (n2 != 0) {
                            value = n1 * n2 / 100;
                        } else {
                            System.out.println("Error: Modulo by zero is not allowed!");
                            error = true;
                        }
                    }
                    case 'v' -> {
                        if (n1 >= 0) {
                            value = Math.sqrt(n1);
                        } else {
                            System.out.println("Error: Cannot calculate the square root of a negative number!");
                            error = true;
                        }
                    }
                }

                if (!error) {
                    if (operator == 'v') {
                        System.out.println("√" + n1 + " = " + value);
                    } else if (operator == '%') {
                        System.out.println( n1 +"% of " + n2 + " = " + value);
                    } else {
                        System.out.println(n1 + " " + operator + " " + n2 + " = " + value);
                    }
                }

                boolean validResponse = false;
                int counter = 0;

                while (!validResponse) {
                    System.out.println("\nDo you want to perform another calculation?\n(y = Yes, n = Main Menu, e = Exit)");
                    String answer = scanner.next();

                    if (answer.equalsIgnoreCase("y")) {
                        validResponse = true;
                    } else if (answer.equalsIgnoreCase("n")) {
                        validResponse = true;
                        continueCalc = false;
                        System.out.println("\nReturning to Main Menu...");
                    } else if (answer.equalsIgnoreCase("e") || counter >= 2) {
                        validResponse = true;
                        System.out.println("\nThank you for using the app. Goodbye!");
                        System.exit(0);
                    } else {
                        System.out.println("\nError: Invalid input! Please enter only 'y', 'n' or 'e'.");

                    }

                    counter = counter + 1;
                }
            }
        }

    public static void runConverter(Scanner scanner) {
        while (true) {
            System.out.println("\n===== MAIN CONVERTER MENU =====");
            System.out.println("1. Temperature");
            System.out.println("2. Distance");
            System.out.println("3. Mass");
            System.out.println("4. Volume");
            System.out.println("5. Currency");
            System.out.println("6. Speed");
            System.out.println("7. Time");
            System.out.println("8. Back to App Main Menu");
            System.out.println("9. Exit Application");
            System.out.print("Choose a category: ");

            String mainChoice = scanner.next();

            switch (mainChoice) {
                case "1" -> convertTemperature(scanner);
                case "2" -> convertDistance(scanner);
                case "3" -> convertMass(scanner);
                case "4" -> convertVolume(scanner);
                case "5" -> convertCurrency(scanner);
                case "6" -> convertSpeed(scanner);
                case "7" -> convertTime(scanner);
                case "8" -> {
                    System.out.println("Returning to App Main Menu...");
                    return;
                }
                case "9" -> {
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Error: Invalid category choice!");
            }
        }
    }

    private static void convertTemperature(Scanner scanner) {
        System.out.println("\n--- Temperature Converter ---");
        System.out.println("Units: 1=Celsius, 2=Fahrenheit, 3=Kelvin");

        System.out.print("From unit (1-3): ");
        int from = scanner.nextInt();
        System.out.print("To unit (1-3): ");
        int to = scanner.nextInt();

        if (from < 1 || from > 3 || to < 1 || to > 3) {
            System.out.println("Error: Invalid unit choice! Please enter a number between 1 and 3.");
            return;
        }

        System.out.print("Enter temperature: ");
        if (!scanner.hasNextDouble()) { System.out.println("Invalid number!"); scanner.next(); return; }
        double input = scanner.nextDouble();

        double result = 0;

        if (from == 1) {
            switch (to) {
                case 1 -> result = input;
                case 2 -> result = (input * 9 / 5) + 32;
                case 3 -> result = input + 273.15;
            }
        } else if (from == 2) {
            switch (to) {
                case 1 -> result = (input - 32) * 5 / 9;
                case 2 -> result = input;
                case 3 -> result = (input - 32) * 5 / 9 + 273.15;
            }
        } else if (from == 3) {
            switch (to) {
                case 1 -> result = input - 273.15;
                case 2 -> result = (input - 273.15) * 9 / 5 + 32;
                case 3 -> result = input;
            }
        }

        String fromName = switch (from) { case 1 -> "Celsius"; case 2 -> "Fahrenheit"; default -> "Kelvin"; };
        String toName = switch (to) { case 1 -> "Celsius"; case 2 -> "Fahrenheit"; default -> "Kelvin"; };

        System.out.println("Result: " + input + " " + fromName + " = " + result + " " + toName);
    }

    private static void convertDistance(Scanner scanner) {
        System.out.println("\n--- Distance Converter ---");
        System.out.println("Units: 1=Meter, 2=Kilometer, 3=Mile, 4=Feet, 5=Inch, 6=Nautical Mile, 7=Astronomical Unit (AU)");

        System.out.print("From unit (1-7): ");
        int from = scanner.nextInt();
        System.out.print("To unit (1-7): ");
        int to = scanner.nextInt();

        if (from < 1 || from > 7 || to < 1 || to > 7) {
            System.out.println("Error: Invalid unit choice! Please enter a number between 1 and 7.");
            return;
        }

        System.out.print("Enter value: ");
        if (!scanner.hasNextDouble()) { System.out.println("Invalid number!"); scanner.next(); return; }
        double val = scanner.nextDouble();

        double meters = switch (from) {
            case 1 -> val;
            case 2 -> val * 1000.0;
            case 3 -> val * 1609.344;
            case 4 -> val * 0.3048;
            case 5 -> val * 0.0254;
            case 6 -> val * 1852.0;
            case 7 -> val * 149597870700.0;
            default -> 0;
        };

        double result = switch (to) {
            case 1 -> meters;
            case 2 -> meters / 1000.0;
            case 3 -> meters / 1609.344;
            case 4 -> meters / 0.3048;
            case 5 -> meters / 0.0254;
            case 6 -> meters / 1852.0;
            case 7 -> meters / 149597870700.0;
            default -> 0;
        };

        String fromName = switch (from) { case 1 -> "Meter"; case 2 -> "Kilometer"; case 3 -> "Mile"; case 4 -> "Feet"; case 5 -> "Inch"; case 6 -> "Nautical Mile"; default -> "AU"; };
        String toName = switch (to) { case 1 -> "Meter"; case 2 -> "Kilometer"; case 3 -> "Mile"; case 4 -> "Feet"; case 5 -> "Inch"; case 6 -> "Nautical Mile"; default -> "AU"; };

        System.out.println("Result: " + val + " " + fromName + " = " + result + " " + toName);
    }

    private static void convertMass(Scanner scanner) {
        System.out.println("\n--- Mass Converter ---");
        System.out.println("Units: 1=Gram, 2=Kilogram, 3=Pound (lbs), 4=Ounce (oz), 5=Metric Ton");

        System.out.print("From unit (1-5): ");
        int from = scanner.nextInt();
        System.out.print("To unit (1-5): ");
        int to = scanner.nextInt();

        if (from < 1 || from > 5 || to < 1 || to > 5) {
            System.out.println("Error: Invalid unit choice! Please enter a number between 1 and 5.");
            return;
        }

        System.out.print("Enter value: ");
        if (!scanner.hasNextDouble()) { System.out.println("Invalid number!"); scanner.next(); return; }
        double val = scanner.nextDouble();

        double grams = switch (from) {
            case 1 -> val;
            case 2 -> val * 1000.0;
            case 3 -> val * 453.59237;
            case 4 -> val * 28.349523125;
            case 5 -> val * 1000000.0;
            default -> 0;
        };

        double result = switch (to) {
            case 1 -> grams;
            case 2 -> grams / 1000.0;
            case 3 -> grams / 453.59237;
            case 4 -> grams / 28.349523125;
            case 5 -> grams / 1000000.0;
            default -> 0;
        };

        String fromName = switch (from) { case 1 -> "Gram"; case 2 -> "Kilogram"; case 3 -> "Pound"; case 4 -> "Ounce"; default -> "Metric Ton"; };
        String toName = switch (to) { case 1 -> "Gram"; case 2 -> "Kilogram"; case 3 -> "Pound"; case 4 -> "Ounce"; default -> "Metric Ton"; };

        System.out.println("Result: " + val + " " + fromName + " = " + result + " " + toName);
    }

    private static void convertVolume(Scanner scanner) {
        System.out.println("\n--- Volume Converter ---");
        System.out.println("Units: 1=Milliliter, 2=Liter, 3=US Gallon, 4=Cubic Meter, 5=Imperial Gallon, 6=Barrel (Oil)");

        System.out.print("From unit (1-6): ");
        int from = scanner.nextInt();
        System.out.print("To unit (1-6): ");
        int to = scanner.nextInt();

        if (from < 1 || from > 6 || to < 1 || to > 6) {
            System.out.println("Error: Invalid unit choice! Please enter a number between 1 and 6.");
            return;
        }

        System.out.print("Enter value: ");
        if (!scanner.hasNextDouble()) { System.out.println("Invalid number!"); scanner.next(); return; }
        double val = scanner.nextDouble();

        double ml = switch (from) {
            case 1 -> val;
            case 2 -> val * 1000.0;
            case 3 -> val * 3785.411784;
            case 4 -> val * 1000000.0;
            case 5 -> val * 4546.09;
            case 6 -> val * 158987.294928;
            default -> 0;
        };

        double result = switch (to) {
            case 1 -> ml;
            case 2 -> ml / 1000.0;
            case 3 -> ml / 3785.411784;
            case 4 -> ml / 1000000.0;
            case 5 -> ml / 4546.09;
            case 6 -> ml / 158987.294928;
            default -> 0;
        };

        String fromName = switch (from) { case 1 -> "Milliliter"; case 2 -> "Liter"; case 3 -> "US Gallon"; case 4 -> "Cubic Meter"; case 5 -> "Imperial Gallon"; default -> "Barrel"; };
        String toName = switch (to) { case 1 -> "Milliliter"; case 2 -> "Liter"; case 3 -> "US Gallon"; case 4 -> "Cubic Meter"; case 5 -> "Imperial Gallon"; default -> "Barrel"; };

        System.out.println("Result: " + val + " " + fromName + " = " + result + " " + toName);
    }

    private static void convertCurrency(Scanner scanner) {
        System.out.println("\n--- Currency Converter ---");
        System.out.println("Currencies: 1=EUR, 2=USD, 3=JPY");

        System.out.print("From currency (1-3): ");
        int from = scanner.nextInt();
        System.out.print("To currency (1-3): ");
        int to = scanner.nextInt();

        if (from < 1 || from > 3 || to < 1 || to > 3) {
            System.out.println("Error: Invalid unit choice! Please enter a number between 1 and 3.");
            return;
        }

        System.out.print("Enter amount: ");
        if (!scanner.hasNextDouble()) { System.out.println("Invalid number!"); scanner.next(); return; }
        double amount = scanner.nextDouble();

        double euros = switch (from) {
            case 1 -> amount;
            case 2 -> amount * 0.92;
            case 3 -> amount * 0.0060;
            default -> 0;
        };

        double result = switch (to) {
            case 1 -> euros;
            case 2 -> euros / 0.92;
            case 3 -> euros / 0.0060;
            default -> 0;
        };

        String fromName = switch (from) { case 1 -> "EUR"; case 2 -> "USD"; default -> "JPY"; };
        String toName = switch (to) { case 1 -> "EUR"; case 2 -> "USD"; default -> "JPY"; };

        System.out.println("Result: " + amount + " " + fromName + " = " + result + " " + toName);
    }

    private static void convertSpeed(Scanner scanner) {
        System.out.println("\n--- Speed Converter ---");
        System.out.println("Units: 1=km/h, 2=mph, 3=m/s, 4=Knots, 5=Speed of Light (c)");

        System.out.print("From unit (1-5): ");
        int from = scanner.nextInt();
        System.out.print("To unit (1-5): ");
        int to = scanner.nextInt();

        if (from < 1 || from > 5 || to < 1 || to > 5) {
            System.out.println("Error: Invalid unit choice! Please enter a number between 1 and 5.");
            return;
        }

        System.out.print("Enter speed: ");
        if (!scanner.hasNextDouble()) { System.out.println("Invalid number!"); scanner.next(); return; }
        double val = scanner.nextDouble();

        double mps = switch (from) {
            case 1 -> val / 3.6;
            case 2 -> val * 0.44704;
            case 3 -> val;
            case 4 -> val * 0.514444;
            case 5 -> val * 299792458.0;
            default -> 0;
        };

        double result = switch (to) {
            case 1 -> mps * 3.6;
            case 2 -> mps / 0.44704;
            case 3 -> mps;
            case 4 -> mps / 0.514444;
            case 5 -> mps / 299792458.0;
            default -> 0;
        };

        String fromName = switch (from) { case 1 -> "km/h"; case 2 -> "mph"; case 3 -> "m/s"; case 4 -> "Knots"; default -> "c"; };
        String toName = switch (to) { case 1 -> "km/h"; case 2 -> "mph"; case 3 -> "m/s"; case 4 -> "Knots"; default -> "c"; };

        System.out.println("Result: " + val + " " + fromName + " = " + result + " " + toName);
    }
    private static void convertTime(Scanner scanner) {
        System.out.println("\n--- Time Format Converter ---");
        System.out.println("Formats: 1 = HH:mm:ss to mm:ss, 2 = mm:ss to HH:mm:ss");

        System.out.print("Choose conversion direction (1-2): ");

        if (!scanner.hasNextInt()) {
            System.out.println("Error: Invalid choice!");
            scanner.next();
            return;
        }
        int choice = scanner.nextInt();

        if (choice < 1 || choice > 2) {
            System.out.println("Error: Invalid choice! Please enter 1 or 2.");
            return;
        }

        System.out.print("Enter time string: ");
        String input = scanner.next();

        switch (choice) {
            case 1 -> {

                if (!input.matches("\\d+:\\d+:\\d+")) {
                    System.out.println("Error: Invalid format! Must be HH:mm:ss (e.g., 02:15:30)");
                    return;
                }
                String[] parts = input.split(":");
                long hours = Long.parseLong(parts[0]);
                long minutes = Long.parseLong(parts[1]);
                long seconds = Long.parseLong(parts[2]);

                long extraMinutes = seconds / 60;
                long remainingSeconds = seconds % 60;

                long totalMinutes = (hours * 60) + minutes + extraMinutes;

                String result = String.format("%02d:%02d", totalMinutes, remainingSeconds);
                System.out.println("Result: " + input + " (HH:mm:ss) = " + result + " (mm:ss)");
            }
            case 2 -> {
                if (!input.matches("\\d+:\\d+")) {
                    System.out.println("Error: Invalid format! Must be mm:ss (e.g., 135:30)");
                    return;
                }
                String[] parts = input.split(":");
                long totalMinutes = Long.parseLong(parts[0]);
                long seconds = Long.parseLong(parts[1]);

                long extraMinutes = seconds / 60;
                long remainingSeconds = seconds % 60;

                totalMinutes += extraMinutes;

                long hours = totalMinutes / 60;
                long remainingMinutes = totalMinutes % 60;

                String result = String.format("%02d:%02d:%02d", hours, remainingMinutes, remainingSeconds);
                System.out.println("Result: " + input + " (mm:ss) = " + result + " (HH:mm:ss)");
            }
        }
    }
}