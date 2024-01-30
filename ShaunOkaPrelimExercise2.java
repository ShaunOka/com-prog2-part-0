package prelims;
/**
 * Name of Student/Programmer: Oka, Shaun Gerald D.
 * CLASS CODE & Schedule: 9308A/9308B & 2:30pm - 3:30pm MTH (9308A) / 1:30pm - 3:00 pm TF (9308B)
 * Date: January 30, 2024
 * Instructor: Dale D. Miguel
 */
import java.util.Scanner;
public class ShaunOkaPrelimExercise2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double number1, number2 = 0.0, runningResult = 0.0;
        char operator;
        boolean validInput = true;
        number1 = promptNumber(scan);
        while (true) {
            operator = promptOperator(scan);
            if (operator != '=') {
                number2 = promptNumber(scan);
            }
            switch (operator) {
                case '+':
                    runningResult = addition(number1, number2);
                    break;
                case '-':
                    runningResult = subtraction(number1, number2);
                    break;
                case '*':
                    runningResult = multiplication(number1, number2);
                    break;
                case '/':
                    runningResult = division(number1, number2);
                    break;
                case '=':
                    System.out.printf("Final result = %.1f%n", number1);
                    System.exit(0);
                    break;
                default: System.out.println("Error operator not valid.");
            }
            number1 = runningResult;
        }
    } // end of main
    public static double promptNumber(Scanner scan) {
        double number = 0.0;
        boolean validInput = true;
        do {
            try {
                System.out.print("Enter a number: ");
                number = Double.parseDouble(scan.nextLine());
            } catch (NumberFormatException error) {
                System.out.println("Please enter only numbers.");
                validInput = false;
            }
            return number;
        } while (!validInput);
    }
    public static char promptOperator(Scanner scan) {
        char operator = 'x';
        String temp ="";
        do {
            System.out.print("Enter an arithmetic operator (+-*/=): ");
            temp = scan.nextLine();
            operator = temp.charAt(0);
            if (temp.length() > 1 || !String.valueOf(operator).matches("[+\\-*/=]")) {
                System.out.println("Please enter only one of the '+-*/=' characters");
            }
        } while (temp.length() > 1 || !String.valueOf(operator).matches("[+\\-*/=]"));
        return operator;
    }
    public static double addition(double number1, double number2) {
        System.out.printf("Running result = %.1f%n", number1+number2);
        return number1+number2;
    }
    public static double subtraction(double number1, double number2) {
        System.out.printf("Running result = %.1f%n", number1-number2);
        return number1-number2;
    }
    public static double multiplication(double number1, double number2) {
        System.out.printf("Running result = %.1f%n", number1*number2);
        return number1*number2;
    }
    public static double division(double number1, double number2) {
        System.out.printf("Running result = %.1f%n", number1/number2);
        return number1/number2;
    }
} // end of class