/*
Name/Author : Oka, Shaun Gerald D.
Class Code  : 9308A/9308B
Course No.  : CS 122/122L
Schedule    : 2:30pm - 3:30pm MTH (9308A) / 1:30pm - 3:00 pm TF (9308B)
Date        : January 30, 2024
 */
import java.util.Scanner;
public class Sample1 {
    /**
     * ALGORITHM
     * 1. declare variables for age and name
     * 2. prompt user to enter age and name
     * 3. print a greeting using both age and name
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int age;
        String name;
        System.out.print("Please enter your age: ");
        age = scan.nextInt();
        // scan.nextInt() reads the integer input of user but leaves out the new line made after the input
        System.out.print("Please enter your name: ");
        name = scan.nextLine();
        // scan.nextLine() reads the leftover new line, so it uses a blank string for the "name" variable
        System.out.printf("Hello %s! Being %d years old is fun.%n", name, age);
        System.exit(0);
    } // end of main
} // end of class
/*
Sample Output:
Please enter your age: 18
Please enter your name: Hello ! Being 18 years old is fun.

Process finished with exit code 0
 */

