package prelims;

/*
 * Name of Student/Programmer: Oka, Shaun Gerald D.
 * CLASS CODE & Schedule: 9308A/9308B & 2:30pm - 3:30pm MTH (9308A) / 1:30pm - 3:00 pm TF (9308B)
 * Date: January 30, 2024
 * Instructor: Dale D. Miguel
 */
import java.util.Scanner;
public class ShaunOkaPrelimExercise2 {
    /**
     * Algorithm:
     * 1. create Scanner to read user input
     * 2. initialize variables for numbers and result
     * 3. prompt user to enter first number
     * 4. start loop that continues until user enters '='
     *     a. prompt user to enter operator (+, -, *, /, or =)
     *     b. if operator is not '=':
     *         - prompt user to enter second number
     *         - perform appropriate arithmetic operation
     *         - store result in runningResult
     *         - print running result
     *     c. if operator is '=':
     *         - print final result
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // #1. construct an object of Scanner class
        double number1, number2 = 0.0; // #2. declare floating point number variables that will be the operands
        double runningResult = 0.0; // #3. stores the result
        char operator ='x'; // #4. declare character variable for operator +-*/
        number1 = promptNumber(scan);
        while (operator != '=') { // #5. while loop that continues when operator is not '='
            operator = promptOperator(scan);
            if (operator != '=') {
                number2 = promptNumber(scan);
            }
            switch (operator) {
                case '+': // #6. case '+' should be here
                    runningResult = addition(number1, number2);
                    break;
                case '-': // #7. case '-' should be here
                    runningResult = subtraction(number1, number2);
                    break;
                case '*': // #8. case '*' should be here
                    runningResult = multiplication(number1, number2);
                    break;
                case '/': // #9. case '/' should be here
                    runningResult = division(number1, number2);
                    break;
                default:
                    System.out.printf("Final result = %.1f%n", number1);
            }
            number1 = runningResult;
        }
        System.exit(0);
    } // end of main

    /**
     * ALGORITHM:
     * 1. declare and initialize variable number and validInput
     * 2. attempt a loop that continues if validInput is false:
     *      a. set validInput to boolean value 'true'
     *      b. prompt user to enter number
     *      c. check if input is a number
     *      d. if success, break the loop
     *      e. if failed:
     *          - display error message
     *          - set validInput to false and continue loop
     * 3. return number
     * @param scan
     * @return
     */
    public static double promptNumber(Scanner scan) {
        double number = 0.0;
        boolean validInput;
        do {
            validInput = true;
            try {
                System.out.print("Enter a number: ");
                number = Double.parseDouble(scan.nextLine());
            } catch (NumberFormatException error) {
                System.out.println("Please enter only numbers.");
                validInput = false;
            }
        } while (!validInput);
        return number;
    }
    /**
     * Algorithm:
     * 1. initialize variable temp to store user input
     * 2. initialize character variable operator with placeholder value
     * 3. enter loop that continues if input operator is invalid:
     *      a. prompt user to enter arithmetic operator
     *      b. read input into temp
     *      c. get first character from temp then assign it to operator
     *      d. check if temp is only a single character and if operator is an arithmetic operator
     *          - if failed, display error message and continue loop
     * 4. return operator
     * @param scan
     * @return
     */
    public static char promptOperator(Scanner scan) {
        char operator = 'x';
        String temp ="";
        do {
            System.out.print("Enter an arithmetic operator (+-*=/): ");
            temp = scan.nextLine();
            operator = temp.charAt(0);
            if (temp.length() > 1 || !String.valueOf(operator).matches("[+\\-*/=]")) {
                System.out.println("Please enter only one of the '+-*=/' characters.");
            }
        } while (temp.length() > 1 || !String.valueOf(operator).matches("[+\\-*/=]"));
        return operator;
    }

    /**
     * ALGORITHM FOR ALL METHODS BELOW:
     * 1. take numbers 1 and 2 from parameter as input
     * 2. do the specified arithmetic operation:
     *      a. Addition: add number 1 and number 2
     *      b. Subtraction: number 1 minus number 2
     *      c. Multiplication: multiply number 1 and number 2
     *      d. Division: number 1 divided by number 2
     * 3. print and return result
     * @param number1
     * @param number2
     * @return
     */
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

/*
Sample Output:
Enter a number: test
Please enter only numbers.
Enter a number: 10
Enter an arithmetic operator (+-*=/): test
Please enter only one of the '+-*=/' characters.
Enter an arithmetic operator (+-*=/): --
Please enter only one of the '+-*=/' characters.
Enter an arithmetic operator (+-*=/): +
Enter a number: 5
Running result = 15.0
Enter an arithmetic operator (+-*=/): *
Enter a number: 2
Running result = 30.0
Enter an arithmetic operator (+-*=/): -
Enter a number: 10
Running result = 20.0
Enter an arithmetic operator (+-*=/): *
Enter a number: 3
Running result = 60.0
Enter an arithmetic operator (+-*=/): /
Enter a number: 5
Running result = 12.0
Enter an arithmetic operator (+-*=/): +
Enter a number: test
Please enter only numbers.
Enter a number: 88
Running result = 100.0
Enter an arithmetic operator (+-*=/): =
Final result = 100.0

Process finished with exit code 0

 */