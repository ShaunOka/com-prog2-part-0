package src;
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
        double number;
        char operator;
        boolean validInput = true;
        while (true) {
            do {
                try {
                    System.out.print("Enter a number: ");
                    number = Double.parseDouble(scan.nextLine());
                } catch (NumberFormatException error) {
                    System.out.println("Please only enter numbers.");
                    validInput = false;
                }
            } while (!validInput);
            
        }   
    }
}