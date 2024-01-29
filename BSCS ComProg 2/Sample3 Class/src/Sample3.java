/*
Name/Author : Oka, Shaun Gerald D.
Class Code  : 9308A/9308B
Course No.  : CS 122/122L
Schedule    : 2:30pm - 3:30pm MTH (9308A) / 1:30pm - 3:00 pm TF (9308B)
Date        : January 30, 2024
 */
import java.util.Scanner;
public class Sample3 {
    /**
     * ALGORITHM
     * 1. D\declare variables age, name, and validInputAccepted
     * 2. initialize age to 0 and validInputAccepted to boolean value false
     * 3. enter loop that continues if validInputAccepted is false
     * 4. prompt and parse user input for age
     * 5. if failed, display error message
     * 6. if success, break loop
     * 7. prompt user input for name
     * 8. print greetings using age and name
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int age = 0;
        String name;
        boolean validInputAccepted = false;
        while (!validInputAccepted) {
            try {
                System.out.print("Please enter your age: ");
                age = Integer.parseInt(scan.nextLine());
                validInputAccepted = true;
            } catch (NumberFormatException error) {
                System.out.println("Please enter a whole number.");
                System.out.printf("Problem detected %s%n", error.getMessage().toLowerCase().charAt(0) + error.getMessage().substring(1));
            } // end of catch
        } // end of while
        System.out.print("Please enter name: ");
        name = scan.nextLine();
        System.out.printf("Hello %s! Being %d years old is fun.%n", name, age);
        System.exit(0);
    } // end of main
} // end of class
/*
Sample Output:
Please enter your age: your age
Please enter a whole number.
Problem detected for input string: "your age"
Please enter your age: 18
Please enter name: Shaun
Hello Shaun! Being 18 years old is fun.

Process finished with exit code 0

 */