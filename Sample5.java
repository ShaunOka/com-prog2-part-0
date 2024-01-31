package prelims;

/*
Name/Author : Oka, Shaun Gerald D.
Class Code  : 9308A/9308B
Course No.  : CS 122/122L
Schedule    : 2:30pm - 3:30pm MTH (9308A) / 1:30pm - 3:00 pm TF (9308B)
Date        : January 30, 2024
 */
public class Sample5 {
    /**
     * ALGORITHM
     * 1. declare and initialize variable duration to 461012
     * 2. print duration in different formats
     * 3. declare and initialize variable pi to Math.PI
     * 4. print pi in different formats
     * @param args
     */
    public static void main(String[] args) {
        long duration = 461012;
        System.out.printf("%d%s%n", duration, "seconds");
        System.out.printf("%08d%n", duration);
        System.out.printf("%+8d%n", duration);
        System.out.printf("%,8d%n", duration);
        System.out.printf("%+,8d%n%n", duration);
        double pi = Math.PI;
        System.out.printf("%s%f%n", "Value of pi = ", pi);
        System.out.printf("%.3f%n", pi);
        System.out.printf("%10.3f%n", pi);
        System.out.printf("%-10.3f%n", pi);
    } // end of main
} // end of class
/*
Sample Output:
461012seconds
00461012
 +461012
 461,012
+461,012

Value of pi = 3.141593
3.142
     3.142
3.142

Process finished with exit code 0
 */