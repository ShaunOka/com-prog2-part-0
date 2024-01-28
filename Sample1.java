/*
Name/Author : Oka, Shaun Gerald D.
Class Code  : 9308A/9308B
Course No.  : CS 122/122L
Schedule    : 2:30pm - 3:30pm MTH (9308A) / 1:30pm - 3:00 pm TF (9308B)
Date        : January 30, 2024
 */
import java.util.Scanner;
public class Sample1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int age = 0;
        String name;
        System.out.print("Please enter your age: ");
        age = Integer.parseInt(scan.nextLine());
        System.out.print("Please enter your name: ");
        name = scan.nextLine();
        System.out.printf("Hello %s! Being %d years old is fun.", name, age);
        System.exit(0);
    } // end of main
} // end of class
