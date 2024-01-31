package prelims;

/*
Name/Author : Oka, Shaun Gerald D.
Class Code  : 9308A/9308B
Course No.  : CS 122/122L
Schedule    : 2:30pm - 3:30pm MTH (9308A) / 1:30pm - 3:00 pm TF (9308B)
Date        : January 30, 2024
 */
public class IfElseDemo {
    /**
     * ALGORITHM
     * 1. declare variables testScore and grade
     * 2. initialize testScore
     * 3. use if, else-if, and else statements to determine equivalent grade from score
     * 4. print grade
     * @param args
     */
    public static void main(String[] args) {
        int testScore = 76;
        char grade;
        if (testScore >= 90) {
            grade = 'A';
        } else if (testScore >= 80) {
            grade = 'B';
        } else if (testScore >= 70) {
            grade = 'C';
        } else if (testScore >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        } // end of if
        System.out.printf("Grade = %s%n", grade);
        System.exit(0);
    } // end of main
} // end of class
/*
Sample Output:
Grade = C

Process finished with exit code 0
 */
