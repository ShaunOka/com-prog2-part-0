/*
Name/Author : Oka, Shaun Gerald D.
Class Code  : 9308A/9308B
Course No.  : CS 122/122L
Schedule    : 2:30pm - 3:30pm MTH (9308A) / 1:30pm - 3:00 pm TF (9308B)
Date        : January 30, 2024
 */
public class Grade {
    /**
     * ALGORITHM
     * 1. declare and initialize variable grade
     * 2. use if, else-if, and else statements to determine remarks from grade
     * 3. print remarks
     * @param args
     */
    public static void main(String[] args) {
        double grade = 92.0;
        if (grade >= 90) {
            System.out.printf("Excellent!%n");
        } else if (grade < 90 && grade >= 80) {
            System.out.printf("Study harder!%n");
        } else {
            System.out.printf("Sorry you failed.%n");
        } // end of if
        System.exit(0);
    } // end of main
} // end of class
/*
Sample Output:
Excellent!

Process finished with exit code 0
 */