import java.util.Scanner;

public class Taschenrechner {
    static char operator = ' ';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            hauptMenue();
            eingabe(scanner);
        } while (operator != 'e');
        scanner.close();
    }

    public static void hauptMenue() {
        System.out.println("+---------- Taschenrechner ----------+");
        System.out.println("|--- Algebra      : 'a' eingeben. ---|");
        System.out.println("|--- Funktionen   : 'f' eingeben. ---|");
        System.out.println("|--- Zahlensysteme: 'z' eingeben. ---|");
        System.out.println("|------------------------------------|");
        System.out.println("|--- Exit         : 'e' eingeben. ---|");
        System.out.println("+------------------------------------+");
    }

    public static void eingabe(Scanner scanner) {
        operator = scanner.next().charAt(0);
        switch (operator) {
            case 'a':
                TaschenrechnerAlgebra.main(null);
                break;
            case 'f':
                TaschenrechnerFunktionen.main(null);
                break;
            case 'z':
                TaschenrechnerZahlensysteme.main(null);
                break;
            case 'e':
                System.out.println("Das Programm wurde beendet!");
                break;
            default:
                System.out.println("Ungültige Eingabe! Das Programm wird beendet.");
                break;
        }
    }

    static class TaschenrechnerAlgebra {
        static double num1 = 0; // Variablen Initialisieren
        static double num2 = 0;
        static double ergebnis = 0;
        static char operator; // Operator Initialisieren
        static boolean validResult; // Ergebnis erlaubt oder nicht

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            do {
                algebraMenue();
                eingabe(scanner);
                if (operator != 'e') {
                    berechnungSwitch();
                    ausgabe();
                }
            } while (operator != 'e');

            scanner.close();
        }

        public static void algebraMenue() {
            System.out.println("+--------------Taschenrechner--------------+");
            System.out.println("|---    Addition:       '+' eingeben.   ---|");
            System.out.println("|---    Subtraktion:    '-' eingeben.   ---|");
            System.out.println("|---    Multiplikation: '*' eingeben.   ---|");
            System.out.println("|---    Division:       '/' eingeben.   ---|");
            System.out.println("|---    Summenformel:   's' eingeben.   ---|");
            System.out.println("|------------------------------------------|");
            System.out.println("|---    Exit:           'e' eingeben.   ---|");
            System.out.println("+------------------------------------------+");
        }

        public static void eingabe(Scanner scanner) {
            operator = scanner.next().charAt(0);
            if (operator != 'e') {
                System.out.print("Gib deine erste Zahl ein: ");
                num1 = scanner.nextDouble();
                System.out.print("Gib deine zweite Zahl ein: ");
                num2 = scanner.nextDouble();
            } else {
                Taschenrechner.main(null);
            }
        }

        public static void berechnungSwitch() {
            validResult = true; // Annahme Ergebnis erlaubt

            switch (operator) {
                case '+':
                    ergebnis = num1 + num2;
                    break;
                case '-':
                    ergebnis = num1 - num2;
                    break;
                case '*':
                    ergebnis = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        ergebnis = num1 / num2;
                    } else {
                        validResult = false;
                        System.out.println("Du kannst nicht durch Null teilen!");
                    }
                    break;
                case 's':
                    ergebnis = (num2 * (num2 + 1) / 2) - ((num1 - 1) * num1 / 2);
                    break;
                case 'e':
                    System.out.println("Das Programm wurde beendet!");
                    break;
                default:
                    System.out.println("Ungültige Eingabe! Das Programm wird beendet.");
                    validResult = false; // Ergebnis falsch wenn case = default
                    operator = 'e'; // Operator = 'e' um Programm zu verlassen
                    break;
            }
        }

        public static void ausgabe() {
            System.out.println();
            if (validResult) {
                System.out.println("Dein Ergebnis ist: " + ergebnis);
            }
            System.out.println();
        }
    }

    static class TaschenrechnerFunktionen {
        static char operator;
        static double schrittweite = 0, startwert = 0, endwert = 0, steigung = 0, achsenabschnitt = 0;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            do {
                funktionenMenue();
                eingabe(scanner);
                if (operator != 'e') {
                    berechnung();
                }
            } while (operator != 'e');

            scanner.close();
        }

        public static void funktionenMenue() {
            System.out.println();
            System.out.println("+----------- Funktionen -----------+");
            System.out.println("|--- Linear     : 'l' eingeben. ---|");
            System.out.println("|----------------------------------|");
            System.out.println("|--- Exit       : 'e' eingeben. ---|");
            System.out.println("+----------------------------------+");
        }

        public static void eingabe(Scanner scanner) {
            operator = scanner.next().charAt(0);

            switch (operator) {
                case 'l':
                    System.out.println("Schrittweite: ");
                    schrittweite = scanner.nextDouble();

                    System.out.println("Startwert: ");
                    startwert = scanner.nextDouble();

                    System.out.println("Endwert: ");
                    endwert = scanner.nextDouble();

                    System.out.println("Steigung: ");
                    steigung = scanner.nextDouble();

                    System.out.println("Achsenabschnitt: ");
                    achsenabschnitt = scanner.nextDouble();
                    break;
                case 'e':
                    Taschenrechner.main(null);
            }

        }

        public static void berechnung() {
            for (double x = startwert; x <= endwert; x += schrittweite) {
                double y;

                if (operator == 'l') {
                    y = steigung * x + achsenabschnitt; // f(x)= m * x + b
                } else {
                    System.out.println("Ungültiger Operator");
                    return;
                }

                System.out.println("( x = " + x + " | y = " + y + ")"); // (X/Y)
            }
        }
    }

    static class TaschenrechnerZahlensysteme {

        static char operator;

        public static void main(String[] args) {
             Scanner scanner = new Scanner(System.in);

            do {
                zahlensystemeMenue();
                eingabe(scanner);
            } while (operator != 'e');

            scanner.close();
        }

        public static void zahlensystemeMenue() {
            System.out.println();
            System.out.println("+---------- Zahlensysteme ----------+");
            System.out.println("|--- Binär       : 'b' eingeben. ---|");
            System.out.println("|--- Dezimal     : 'd' eingeben. ---|");
            System.out.println("|-----------------------------------|");
            System.out.println("|--- Exit        : 'e' eingeben. ---|");
            System.out.println("+-----------------------------------+");
            System.out.println();

        }

        public static void eingabe(Scanner scanner) {

            operator = scanner.next().charAt(0);

            switch (operator) {

                case 'b':
                    decToBin(scanner);
                    break;
                case 'd':
                    binToDec(scanner);
                    break;
                case 'e':
                    Taschenrechner.main(null);
                default:
                    System.out.println("ungültiger operator");
            }

        }
    }

    public static void decToBin(Scanner s) {
        int dezimalzahl = 0;

        System.out.println("ihre dezimalzahl: ");
        dezimalzahl = s.nextInt();

        String bin = "";

        while (dezimalzahl > 0) {
            int rest = dezimalzahl % 2;
            dezimalzahl /= 2;

            bin = rest + bin;
        }
        System.out.println(bin);

    }

    public static void binToDec(Scanner s) {
        String bin = "0";

        System.out.println("ihre binärzahl: ");
        bin = s.next();

        int dec = 0;

        for (int i = bin.length() - 1; i >= 0; i--) {
            int zahl = bin.charAt(i) - '0';

            dec += zahl * Math.pow(2, bin.length() - i - 1);
        }
        System.out.println(dec);
    }
}