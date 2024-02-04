/*
 * Name of Student/Programmer: Oka, Shaun Gerald D.
 * CLASS CODE & Schedule: 9308A/9308B & 2:30pm - 3:30pm MTH (9308A) / 1:30pm - 3:00 pm TF (9308B)
 * Date: February 6, 2024
 * Instructor: Dale D. Miguel
 */

import java.util.Scanner;
public class OkaShaunGeraldStudentRecordsViaParallelArrays {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        OkaShaunGeraldStudentRecordsViaParallelArrays programKo;
        try {
            programKo = new OkaShaunGeraldStudentRecordsViaParallelArrays();
            programKo.run();
        } catch (Exception exception){
            exception.printStackTrace();
        }
        System.exit(0);
    } // end of main
    /**
     Declare, instantiate and populate the needed arrays then perform necessary
     sorting and other manipulations
     */
    public void run() throws Exception {
        int size = readInteger("Please enter size", 1, Integer.MAX_VALUE);
        String[] id = new String[size];
        String[] name = new String[size];
        String[] course = new String[size];
        int[] yearLevel = new int[size];
        byte[] prelimGrade = new byte[size];
        byte[] midtermGrade = new byte[size];
        byte[] tentativeFinalGrade = new byte[size];
        byte[] finalGrade = new byte[size];
        int count;
        boolean validNumber = false;
        count = readInteger("Please enter number of student records to be creates", 1, 50);
        populateArrays(id, name, course, yearLevel, prelimGrade, midtermGrade, tentativeFinalGrade,
                finalGrade);
    }
    public int readInteger(String prompt, int min, int max) {
        int value = -1;
        boolean validValue = false;
        while (!validValue) {
            try {
                System.out.printf("%s: ", prompt);
                value = Integer.parseInt(scan.nextLine());
                if (value<min || value>max) {
                    System.out.printf("Please enter a number greater than %d and lower than %d%n", min, max);
                } else {
                    validValue = true;
                }
            } catch (NumberFormatException numberException) {
                validValue = false;
                System.out.println("ERROR: Invalid integer.");
                System.out.println("Please try again.");
            }
        }
        return value;
    }
    public void populateArrays(String[] id, String[] name, String[] course, int[] yearLevel,
                               byte[] prelimGrade, byte[] midtermGrade, byte[] tentativeFinalGrade,
                               byte[] finalGrade) {
        String[][] stringStudentRecords = {id, name, course};
        String[] stringNames = {"id", "name", "course"}
        byte[][] byteStudentRecords = {prelimGrade, midtermGrade, tentativeFinalGrade, finalGrade};
        String[] byteNames = {"preliminary", "midterm", "tentative final", "final"};
        for 

    }
}
