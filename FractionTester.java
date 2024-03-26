/*
 * Name of Student/Programmers:
 * Balanza, Clian
 * Morano, Ian
 * Oka, Shaun Gerald
 * Orlino, Maki
 * Perdido, Jiro
 * Torres, Kate
 * CLASS CODE & Schedule: 9308A/9308B & 2:30pm - 3:30pm MTH (9308A) / 1:30pm - 3:00 pm TF (9308B)
 * Date: March , 2024
 * Instructor: Dale D. Miguel
 */

// code ni Shaun
package edu.slu.prog2;

import java.util.Scanner;

public class FractionTester {
    static Scanner kbd = new Scanner(System.in);

    /**
     * main entry of the program
     * @param args
     */
    public static void main(String[] args) {
        FractionTester groupTester;
        try {
            groupTester = new FractionTester();
            groupTester.run();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.exit(0);
    }

    /*
   ALGORITHM:
     1. Welcome the user to the Fraction Tester.
     2. Enter an infinite loop for ongoing operation:
         a. Display the menu of choices.
         b. Prompt the user to enter their choice (1-6).
         c. Validate the user's choice, ensuring it's within the valid range (1-6).
         d. Determine the fraction type based on the user's choice.
         e. Perform the selected operation on fractions:
            - Case 1: Add fractions.
            - Case 2: Subtract fractions.
            - Case 3: Multiply fractions.
            - Case 4: Divide fractions.
            - Case 5: Simplify a fraction.
            - Case 6: Exit the Fraction Tester (break the loop).
         f. Display the result in both simplified fraction form and decimal form.
         g. Prompt the user to press Enter to continue.
     3. Exit the run method upon choice 6.
   */
    /**
     * manages the main method of the program
     * @throws Exception
     */
    public void run() throws Exception {
        Fraction result = new Fraction();
        byte choice; // holds the type of operation chosen
        byte type; // holds the type of fraction
        System.out.println("Welcome to Fraction Tester!");
        while (true) {
            displayMenu();
            choice = (byte) readNumber("Please enter number of choice: ", 1, 6);
            type = displayFractionType(choice);
            switch (choice) {
                case 1 -> result = readFraction1(type).add(readFraction2(type));
                case 2 -> result = readFraction1(type).subtract(readFraction2(type));
                case 3 -> result = readFraction1(type).multiplyBy(readFraction2(type));
                case 4 -> result = readFraction1(type).divideBy(readFraction2(type));
                case 5 -> result = readFraction1(type).simplify();
                case 6 -> {
                    System.out.println("""
                            Thank you for using Fraction Tester!
                            Tester exiting...""");
                    return;
                }
            }
            System.out.printf("Result: %s or %.2f%n", result.simplify(), result.toDouble());
            System.out.print("Please press enter to continue...");
            kbd.nextLine();
        }
    }
    /*
     * ALGORITHM:
     * 1. Initialize a Fraction object to store results and variables for user choices.
     * 2. Display a welcome message.
     * 3. Enter a loop that continues until the user chooses to exit:
     *      a. Display the menu of fraction operations.
     *      b. Prompt the user to choose an operation (1-6).
     *      c. If the choice is not to exit:
     *          i. Display options for fraction types.
     *          ii. Prompt the user to choose a fraction type (1-3).
     *      d. invoke the operation method to complete operation of fraction/s
     *      e. Display the result in both simplified fraction form and decimal format.
     *      f. Wait for user input to clear the screen before continuing.
     */

    /**
     * displays the arithmetic operations menu for user
     */
    private void displayMenu() {
        System.out.println("""
                * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
                |    Please choose:              |
                |    1.) Add                     |
                |    2.) Subtract                |
                |    3.) Multiply                |
                |    4.) Divide                  |
                |    5.) Simplify                |
                |    6.) Exit                    |
                * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *""");
    }

    /*
     * ALGORITHM:
     * 1. Initialize variables for the number to be read and a flag to indicate valid input.
     * 2. Enter a loop that continues until valid input is received:
     *      a. Display the prompt for input.
     *      b. Attempt to parse the user's input as an integer:
     *          i. If parsing is successful:
     *              1. Check if the number is within the specified range (min to max).
     *              2. If valid, set validInput to true to exit the loop.
     *              3. If not valid, display an error message and continue.
     *         ii. If parsing fails (NumberFormatException):
     *              1. Display an error message for invalid input.
     * 3. Return the valid integer that was read.
     */
    /**
     * prompts the user to enter a number and returns if valid
     * @param prompt
     * @param min
     * @param max
     * @return Fraction
     */
    public int readNumber(String prompt, int min, int max) {
        int number = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.printf("%s", prompt);
            try {
                number = Integer.parseInt(kbd.nextLine());
                if (number >= min && number <= max) {
                    validInput = true;
                } else {
                    System.out.printf("Please enter a number with a minimum of %d and a maximum of %d.%n", min, max);
                }
            } catch (NumberFormatException exception) {
                System.out.println("ERROR: Invalid number.");
                System.out.println("Please try again.");
            }
        }
        return number;
    }

    /**
     * displays the fraction type for the user and prompts for the type
     */
    private byte displayFractionType(byte choice) {
        byte type = (byte) -1;
        if (choice == 6) { // if user exits
            return type;
        } else if (choice != 5) { // if user chose to add/minus/multiply/divide
            System.out.println("""
                    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
                    |    Please choose fractions:    |
                    |    1.) Two Im/Proper           |
                    |    2.) Mixed and Im/Proper     |
                    |    3.) Two Mixed               |
                    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *""");
        } else { // if user chose to simplify
            System.out.println("""
                    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
                    |    Please choose fraction:     |
                    |    1.) Im/Proper               |
                    |    2.) Mixed                   |
                    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *""");
        }
        type = (byte) readNumber("Please enter number of choice: ", 1, 3);
        return type;
    }

    /*
     * ALGORITHM:
     * 1. Initialize variables to store numerator, denominator, and whole number (for mixed fractions).
     * 2. Create a new Fraction object to store the result.
     * 3. Prompt the user to enter a fraction based on the chosen type:
     *      a. For im/proper fractions (type 1):
     *          i. Prompt for the numerator (allowing any integer value).
     *          ii. Prompt for the denominator (ensuring it's not zero or negative).
     *          iii. Create a new Fraction object with the entered values.
     *      b. For mixed fractions (type 2 or 3):
     *          i. Prompt for the whole number portion (ensuring it's not zero or negative).
     *          ii. Prompt for the numerator (allowing any integer value).
     *          iii. Prompt for the denominator
     *          iv. Create a new MixedFraction object with the entered values.
     * 4. Return the created Fraction or MixedFraction object.
     */
    /**
     * prompts the user to enter a fraction according to type chosen and returns the fraction
     * @param type
     * @return Fraction
     */
    public Fraction readFraction1(byte type) {
        Fraction result = new Fraction();
        int numerator = 0;
        int denominator = 1;
        int wholeNumber = 0;
        System.out.println("Please enter a fraction (1)");
        switch (type) {
            case 1:
                numerator = readNumber("Please enter numerator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                denominator = readNumber("Please enter denominator: ", 1, Integer.MAX_VALUE);
                result = new Fraction(numerator, denominator);
                break;
            case 2:
            case 3:
                wholeNumber = readNumber("Please enter a whole number: ", 0, Integer.MAX_VALUE);
                numerator = readNumber("Please enter numerator: ", 0, Integer.MAX_VALUE);
                        denominator = readNumber("Please enter denominator: ", 1, Integer.MAX_VALUE);
                result = new MixedFraction(wholeNumber, numerator, denominator);
                break;
        }
        return result;
    }

    /*
     * ALGORITHM:
     * 1. Initialize variables to store numerator, denominator, and whole number (for mixed fractions).
     * 2. Create a new Fraction object to store the result.
     * 3. Prompt the user to enter a fraction based on the chosen type:
     *      a. For im/proper fractions (type 1 or 2):
     *          i. Prompt for the numerator (allowing any integer value).
     *          ii. Prompt for the denominator (ensuring it's not zero or negative).
     *          iii. Create a new Fraction object with the entered values.
     *      b. For mixed fractions (type 3):
     *          i. Prompt for the whole number portion (ensuring it's not zero or negative).
     *          ii. Prompt for the numerator (allowing any integer value).
     *          iii. Prompt for the denominator (ensuring it's not zero or negative).
     *          iv. Create a new MixedFraction object with the entered values.
     * 4. Return the created Fraction or MixedFraction object.
     */

    /**
     * prompts the user to enter a fraction according to type chosen and returns the fraction
     * @param type
     * @return Fraction
     */
    public Fraction readFraction2(byte type) {
        Fraction result = new Fraction();
        int numerator = 0;
        int denominator = 1;
        int wholeNumber = 0;
        System.out.println("Please enter a fraction (2)");
        switch (type) {
            case 1:
            case 2:
                numerator = readNumber("Please enter numerator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                denominator = readNumber("Please enter denominator: ", 1, Integer.MAX_VALUE);
                result = new Fraction(numerator, denominator);
                break;
            case 3:
                wholeNumber = readNumber("Please enter a whole number: ", 0, Integer.MAX_VALUE);
                numerator = readNumber("Please enter numerator: ", 0, Integer.MAX_VALUE);
                denominator = readNumber("Please enter denominator: ", 1, Integer.MAX_VALUE);
                result = new MixedFraction(wholeNumber, numerator, denominator);
                break;
        }
        return result;
    }
}
