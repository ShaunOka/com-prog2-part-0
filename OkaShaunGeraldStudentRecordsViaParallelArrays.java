/*
 * Name of Student/Programmer: Oka, Shaun Gerald D.
 * CLASS CODE & Schedule: 9308A/9308B & 2:30pm - 3:30pm MTH (9308A) / 1:30pm - 3:00 pm TF (9308B)
 * Date: February 6, 2024
 * Instructor: Dale D. Miguel
 */
/*
* Student Records Keeping Using Parallel Arrays
*
* An ID number, a name, a course, a year level and others are
* attributed to a student. Hence, eight arrays are
* used: An array that stores ID numbers, an array that
* stores names, an array that stores courses, an array
* that stores year levels, etc. The eight arrays are treated
* as parallel arrays such that the first elements of the
* eight arrays are actual attributes (ID number, name, course,
* year level, etc. ) of one student, the second elements are
* actual attributes of another student, and so on.
*
* REQUIRED:
* Complete and show a sample run (sample output) of the following
*program.
*The sample run should be shown below as part of this multiline comment
**/
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
        } // end
        System.exit(0);
    } // end of main
    /**
     Declare, instantiate and populate the needed arrays then perform necessary
     sorting and other manipulations
     */
    public void run() throws Exception {
        /* TO DO: Instantiate the arrays such that each will have a length=size */
        int count = readNumber("Please enter number of student records to be created: ", 1, 50);
        String[] id = new String[count]; // array for id
        String[] name = new String[count]; // array for name
        String[] course = new String[count]; // array for course
        int[] yearLevel = new int[count]; // array for year level
        byte[] prelimGrade = new byte[count]; // array for preliminary grades
        byte[] midtermGrade = new byte[count]; // array for midterm grades
        byte[] tentativeFinalGrade = new byte[count]; // array for tentative final grades
        byte[] finalGrade = new byte[count]; // array for final grades
        /* Read the number of students to be recorded from the keyboard */
        /* When testing your program, enter a few number of students (e.g. 5) so
        that your test will not need a lot of inputs */
        /* TO DO: Invoke the method that will fill the arrays with elements */
        populateArrays(id, name, course, yearLevel, prelimGrade, midtermGrade, tentativeFinalGrade,
                finalGrade);
        /* Show the students following the order by which they were entered */
        System.out.println("\nOriginal Order Data");
        displayArrays(id, name, course, yearLevel, prelimGrade, midtermGrade, tentativeFinalGrade, finalGrade);
        //TO DO: Invoke the method for displaying the array elements
        // Show the students in sorted order
        System.out.println("\nSorted Data");
        sortArrays(id, name, course, yearLevel, prelimGrade, midtermGrade, tentativeFinalGrade, finalGrade);
        displayArrays(id, name, course, yearLevel, prelimGrade, midtermGrade, tentativeFinalGrade, finalGrade);
        /* TO DO : Invoke the method that will sort the arrays in parallel */
        // TO DO: Invoke the method for displaying the array elements

    } // end of run
    /** Returns an integer read from the keyboard. The integer must be
     * in the range lowLimit to upLimit.
     */
    public int readNumber(String prompt, int min, int max) {
        int value = -1;
        boolean validValue = false;
        while (!validValue) {
            try {
                System.out.printf("%s", prompt);
                value = Integer.parseInt(scan.nextLine());
                if (value<min || value>max) {
                    System.out.printf("Please enter a number minimum of %d and maximum of %d%n", min, max);
                } else {
                    validValue = true;
                } // end of else if
            } catch (NumberFormatException numberException) {
                validValue = false;
                System.out.println("ERROR: Invalid number.");
                System.out.println("Please try again.");
            } // end of catch
        } // end of loop
        return value;
    } // end of readNumber
    /**
     * Put elements into arrays (parallel arrays) for ID numbers, names, course,
     * year levels, prelim grade, midterm grade, tentative final grade, and
     * final grade
     **/
    public void populateArrays(String[] id, String[] name, String[] course, int[] yearLevel,
        byte[] prelimGrade, byte[] midtermGrade, byte[] tentativeFinalGrade, byte[] finalGrade) {
        //TO DO. Insert appropriate lines of codes
        /* When accepting a value of prelim grade, midterm grade and tentative final
        grade, validate the input in order to ensure that the value entered is an integer
        in the range 65 to 99 */
        /* The final grade should be computed as the average of the prelim grade,
        Midterm grade and tentative final grade */
        for (int index = 0; index < id.length; index++) {
            System.out.printf("Student record (%d):%n", index+1);
            System.out.print("Please enter id number: ");
            id[index] = scan.nextLine();
            System.out.print("Please enter name: ");
            name[index] = scan.nextLine();
            System.out.print("Please enter course: ");
            course[index] = scan.nextLine();
            yearLevel[index] = readNumber("Please enter year level: ", 1, 7);
            prelimGrade[index] = (byte)(readNumber("Please enter preliminary grade: ", 65, 99));
            midtermGrade[index] = (byte)(readNumber("Please enter midterm grade: ", 65, 99));
            tentativeFinalGrade[index] = (byte)(readNumber("Please enter tentative final grade: ", 65, 99));
            finalGrade[index] = (byte)((prelimGrade[index]+midtermGrade[index]+tentativeFinalGrade[index])/3);
        } // end of loop
    } // end of populateArrays
    /**
     * Show the elements of the arrays on the screen.
     **/
    public void displayArrays(String[] id, String[] name, String[] course, int[] yearLevel,
                              byte[] prelimGrade, byte[] midtermGrade, byte[] tentativeFinalGrade, byte[] finalGrade) {
        for (int index = 0; index <= 50; index++) {
            System.out.print("<");
        }
        System.out.print("-");
        for (int index = 0; index <= 50; index++) {
            System.out.print(">");
        }
        System.out.println();
        System.out.printf("%n%20s%11s%17s%7s%10s%11s%18s%9s%n", "Name", "ID", "Course", "Year", "Prelims", "Midterms", "Tentative Final", "Finals");
        for (int index = 0; index < id.length; index++) {
            System.out.printf("%20s%11s%17s%7d%10d%11d%18d%9d%n", name[index], id[index], course[index],
             yearLevel[index], prelimGrade[index], midtermGrade[index], tentativeFinalGrade[index],
             finalGrade[index]);
        }
        System.out.println();
        for (int index = 0; index <= 50; index++) {
            System.out.print("<");
        }
        System.out.print("-");
        for (int index = 0; index <= 50; index++) {
            System.out.print(">");
        }
        System.out.println();
    } // end of
    /** Sort the elements of the eight arrays in parallel (i.e. When
     * there is a need to swap elements of the array n,
     * the corresponding elements in other arrays should also
     * be swapped.) such that the elements of array n
     * are lexicographically arranged. (SPECIFY the Sort Algorithm
     * that you will follow.
     */
    public void sortArrays(String[] id, String[] name, String[] course, int[] yearLevel,
                           byte[] prelimGrade, byte[] midtermGrade, byte[] tentativeFinalGrade, byte[] finalGrade) {
        int sortIndex = 0;

        for (int index1 = 0; index1 < name.length; index1++) {
            for (int index2 = index1 + 1; index2 < name.length; index2++) {
                if (name[index1].compareTo(name[index2]) > 0) {
                    sortIndex = index2;
                }
            }
            String tempName = name[sortIndex];
            name[sortIndex] = name[index1];
            name[index1] = tempName;

            String tempID = id[sortIndex];
            id[sortIndex] = id[index1];
            id[index1] = tempID;

            String tempCourse = course[sortIndex];
            course[sortIndex] = course[index1];
            course[index1] = tempCourse;

            int tempYearLevel = yearLevel[sortIndex];
            yearLevel[sortIndex] = yearLevel[index1];
            yearLevel[index1] = tempYearLevel;

            byte tempPrelim = prelimGrade[sortIndex];
            prelimGrade[sortIndex] = prelimGrade[index1];
            prelimGrade[index1] = tempPrelim;

            byte tempMidterm = midtermGrade[sortIndex];
            midtermGrade[sortIndex] = midtermGrade[index1];
            midtermGrade[index1] = tempMidterm;

            byte tempTFinal = tentativeFinalGrade[sortIndex];
            tentativeFinalGrade[sortIndex] = tentativeFinalGrade[index1];
            tentativeFinalGrade[index1] = tempTFinal;

            byte tempFinal = finalGrade[sortIndex];
            finalGrade[sortIndex] = finalGrade[index1];
            finalGrade[index1] = tempFinal;
        } // end of nested loops
    } // end of sortArrays
}
/*
Please enter number of student records to be created: 3
Student record (1):
Please enter id number: 123
Please enter name: Oka, Shaun
Please enter course: BSCS
Please enter year level: 1
Please enter preliminary grade: 99
Please enter midterm grade: 98
Please enter tentative final grade: 97
Student record (2):
Please enter id number: 124
Please enter name: B, Shaun
Please enter course: BSMMA
Please enter year level: 96
Please enter a number minimum of 1 and maximum of 7
Please enter year level: 2
Please enter preliminary grade: 96
Please enter midterm grade: 95
Please enter tentative final grade: 94
Student record (3):
Please enter id number: 125
Please enter name: Y, Oka
Please enter course: BSIT
Please enter year level: 3
Please enter preliminary grade: 93
Please enter midterm grade: 92
Please enter tentative final grade: 91

Original Order Data
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

                Name         ID           Course   Year   Prelims   Midterms   Tentative Final   Finals
          Oka, Shaun        123             BSCS      1        99         98                97       98
            B, Shaun        124            BSMMA      2        96         95                94       95
              Y, Oka        125             BSIT      3        93         92                91       92

<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

Sorted Data
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

                Name         ID           Course   Year   Prelims   Midterms   Tentative Final   Finals
            B, Shaun        124            BSMMA      2        96         95                94       95
          Oka, Shaun        123             BSCS      1        99         98                97       98
              Y, Oka        125             BSIT      3        93         92                91       92

<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

Process finished with exit code 0
 */
