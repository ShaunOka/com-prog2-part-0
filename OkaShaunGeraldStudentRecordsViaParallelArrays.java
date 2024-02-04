/*
 * Name of Student/Programmer: Oka, Shaun Gerald D.
 * CLASS CODE & Schedule: 9308A/9308B & 2:30pm - 3:30pm MTH (9308A) / 1:30pm - 3:00 pm TF (9308B)
 * Date: February 6, 2024
 * Instructor: Dale D. Miguel
 */
/*Student Records Keeping Using Parallel Arrays
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
        }
        System.exit(0);
    } // end of main
    /**
     Declare, instantiate and populate the needed arrays then perform necessary
     sorting and other manipulations
     */
    public void run() throws Exception {
        /* TO DO: Instantiate the arrays such that each will have a length=size */
        int count = readNumber("Please enter number of student records to be created: ", 1, 50);
        String[] id = new String[count];
        String[] name = new String[count];
        String[] course = new String[count];
        int[] yearLevel = new int[count];
        byte[] prelimGrade = new byte[count];
        byte[] midtermGrade = new byte[count];
        byte[] tentativeFinalGrade = new byte[count];
        byte[] finalGrade = new byte[count];
        /* Read the number of students to be recorded from the keyboard */
        /* When testing your program, enter a few number of students (e.g. 5) so
        that your test will not need a lot of inputs */
        /* TO DO: Invoke the method that will fill the arrays with elements */
        populateArrays(id, name, course, yearLevel, prelimGrade, midtermGrade, tentativeFinalGrade,
                finalGrade);
        /* Show the students following the order by which they were entered */
        System.out.println("Original Order Data");
        displayArrays(id, name, course, yearLevel, prelimGrade, midtermGrade, tentativeFinalGrade, finalGrade);
        //TO DO: Invoke the method for displaying the array elements

    }
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
                }
            } catch (NumberFormatException numberException) {
                validValue = false;
                System.out.println("ERROR: Invalid number.");
                System.out.println("Please try again.");
            }
        }
        return value;
    }
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
            System.out.print("Please enter preliminary grade: ");
            prelimGrade[index] = (byte)(readNumber("", 65, 99));
            System.out.print("Please enter midterm grade: ");
            midtermGrade[index] = (byte)(readNumber("", 65, 99));
            System.out.print("Please enter tentative final grade: ");
            tentativeFinalGrade[index] = (byte)(readNumber("", 65, 99));
            finalGrade[index] = (byte)((prelimGrade[index]+midtermGrade[index]+tentativeFinalGrade[index])/finalGrade.length);
        }
    }
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
        System.out.printf("%46s%n", "Student Record");
        System.out.printf("%20s%11s%11s%11s%11s%11s%17s%11s%n", "Name", "ID", "Course", "Year", "Prelims", "Midterm", "Tentative Final", "Finals");
        for (int index = 0; index < id.length; index++) {
            System.out.printf("%20s%11s%11s%11d%11d%11d%17d%11d%n", name[index], id[index], course[index],
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
    }
}
