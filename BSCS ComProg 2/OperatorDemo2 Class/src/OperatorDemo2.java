/*
Name/Author : Oka, Shaun Gerald D.
Class Code  : 9308A/9308B
Course No.  : CS 122/122L
Schedule    : 2:30pm - 3:30pm MTH (9308A) / 1:30pm - 3:00 pm TF (9308B)
Date        : January 30, 2024
 */
public class OperatorDemo2 {
    /**
     * ALGORITHM
     * 1. declare and initialize variable count and adjustmentAmount
     * 2. print count to see initial count
     * 3. multiply the count to 2 and store it in adjustmentAmount before incrementing count
     * 4. print both adjustmentAmount and the incremented count
     * @param args
     */
    public static void main(String[] args) {
        int count = 5;
        int adjustmentAmount = 0;
        System.out.printf("Initial Count = %d%n", count);
        adjustmentAmount = count++ * 2;
        System.out.printf("Adjusted Count = %d%n", adjustmentAmount);
        System.out.printf("New Value of Count = %d%n", count);
        System.exit(0);
    } // end of main
} // end of class
/*
Sample Output:
Initial Count = 5
Adjusted Count = 10
New Value of Count = 6

Process finished with exit code 0
 */