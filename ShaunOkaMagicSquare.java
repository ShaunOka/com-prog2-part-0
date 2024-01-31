/*
 * Name of Student/Programmer: Oka, Shaun Gerald D.
 * CLASS CODE & Schedule: 9308A/9308B & 2:30pm - 3:30pm MTH (9308A) / 1:30pm - 3:00 pm TF (9308B)
 * Date: February 2, 2024
 * Instructor: Dale D. Miguel
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*Program that generates and displays a 3 by 3, 5 by 5, 7 by 7,9 by 9, 11 by 11
*or 13 by 13 magic square. Although the program may be written such that
*a magic square with any odd number size is generated, the output screen may not be able
*to contain the magic square.
*/
public class ShaunOkaMagicSquare {
    public static void main(String[] args) {
        ShaunOkaMagicSquare test;
        try {
            test = new ShaunOkaMagicSquare();
            test.run();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.exit(0);
    } // end of main

/**General Algorithm ( Implemented in the run method. )
*1. Accept the desired size of the magic square
*2. If the size entered is an even number, give a message saying the size
* must be an odd number and repeat from step 1.
*3. If the size is less than 3 or the size is greater than 13, give a message
* saying the size must be an odd number from 3 to 13 and repeat from step 1
*4. Pass the size to the method that generates a magic square so that
* a magic square with the desired size is generated and pass the magic
* square to the method that displays the magic square.
*/
    public void run() throws Exception {
        BufferedReader keyBoard = new BufferedReader(new InputStreamReader(System.in));
        int squareSize = 0;
        System.out.println("Magic Square Generator");
        squareSize = readOddInteger(keyBoard);
        System.out.printf("%d by %d magic square%n", squareSize, squareSize);
        display(generateMagicSquare(squareSize));
    }
    /**
    ALGORITHM:
    1. initialize variables:
        - number = 0
        - choice = ""
    2. enter loop that continues until valid odd integer is entered:
        a. prompt user a positive odd integer for square size
        b. try to read input as integer:
            - if success:
                - check if odd and positive:
                - if not, display error message and continue the loop
                - if odd and positive, check if in range 3-13:
                    - if not, warn user about size and give choice to continue or not
                    - if in range, break the loop
            - if not an integer:
                - display error message and continue the loop
    3. Return the validated odd integer
    */
    public int readOddInteger(BufferedReader keyBoard){
        int number = 0;
        String choice = "";
        while (number < 0 || number % 2 == 0 || choice.equals("1")){            
            try {
                choice = "";
                System.out.print("Please enter a positive odd integer for square size: ");
                number = Integer.parseInt(keyBoard.readLine());
                if (number < 0) {
                    System.out.println("Please enter only positive integers.");
                } else if (number % 2 == 0) {
                    System.out.printf("'%d' is not an odd integer.%n", number);
                } else if (number < 3 || number > 13) {
                    System.out.printf("WARNING: '%d' may be too big or too small%n", number);
                    System.out.print("Please enter any key to continue ('1' to go back): ");
                    choice = keyBoard.readLine();
                }
            } catch (Exception exception) {
                System.out.println("Please enter only integers.");
            }
        }

        return number;
    }
    /**
    *Generates and returns a two-dimensional array that corresponds
    * to a magic square with a given size, where size is assumed to be
    * an odd integer.
    *
    *Input: size = desired size of the magic square
    *Output: two-dimensional array(i.e. size by size) representing the
    *magic square
    *
    *Processes:
    *1. Instantiate the two dimensional array called magicSquare
    *2. Initialize magicSquare such that every cell is filled with 0 by
    * giving magicSquare to the method for initializing a two-dimensional
    * array.
    *3. Let the number to be placed in the magicSquare be element and
    * let element be 1.
    *4. Let row be 0 (start from row 0)
    *5. Let col be the middle column of the row (size/2)
    *6. put element in the magicSquare at the current row and col
    *7. while element is less than size * size
    * Let element = element + 1
    * Let row = row -1 ( i.e. Move one cell up diagonally)
    * Let col = col + 1
    * If row <0 and col > size-1, go the the cell below the corner cell
    * row = row+2;
    * col = col-1
    * If row < 0, go to the last valid row
    * row = size -1
    * If col > size, go to the first column
    * col = 0
    * If magicSquare[row][col] is not 0 (there is already an element),
    * go the cell below
    * row = row +2
    * col = col-1
    * Put element in the cell indexed row and col
    *
     */
    public int[][] generateMagicSquare(int squareSize) {
        int[][] magicSquare = new int[squareSize][squareSize];
        magicSquare = initializeArray(magicSquare);
        int element = 1;
        int row = 0;
        int col = squareSize/2;
        magicSquare[row][col] = element;
        while (element < squareSize * squareSize) {
            element = element + 1;
            row = row - 1;
            col = col + 1;
            if (row < 0 && col > squareSize - 1) {
                row = row + 2;
                col = col - 1;
            }
            if (row < 0) {
                row = squareSize - 1;
            }
            if (col >= squareSize) {
                col = 0;
            }
            if (magicSquare[row][col] != 0) {
                row = row + 2;
                col = col - 1;
            }
            magicSquare[row][col] = element;
        }
        return magicSquare;
    }
    /**
    *Initializes a two-dimensional array by putting 0 to every
    *cell of the array.
    *For row 0 to the last row of the two-dimensional array
    * For column 0 to last column of each row
    * let array[row][column] = 0
     */
    public int[][] initializeArray(int[][] twoDimensionArray) {
        for (int row = 0; row < twoDimensionArray.length; row++) {
            for (int col = 0; col < twoDimensionArray.length; col++) {
                twoDimensionArray[row][col] = 0;
            }
        }
        return twoDimensionArray;
    }
    /**Displays each element of a two dimensional on a space with
    * uniform width.
    *Given: Two-dimensional array
    * For row =0 to last valid row of the given two-dimensional array
    * For column = 0 to last valid column of a row
    * Print the element at the current row and column on a fixed width space
    * Print the enter character */
    public void display(int[][] twoDimensionArray) {
        for (int row = 0; row < twoDimensionArray.length; row++) {
            for (int col = 0; col < twoDimensionArray.length; col++) {
                System.out.printf("%6d", twoDimensionArray[row][col]);
            }
            System.out.println();
        }
    }

} // end of class
/*
Sample Output:

 * Magic Square Generator
Please enter a positive odd integer for square size: -1
Please enter only positive integers.
Please enter a positive odd integer for square size: -2
Please enter only positive integers.
Please enter a positive odd integer for square size: -1
Please enter only positive integers.
Please enter a positive odd integer for square size: 0
'0' is not an odd integer.
Please enter a positive odd integer for square size: 0
'0' is not an odd integer.
Please enter a positive odd integer for square size: 1
WARNING: '1' may be too big or too small
Please enter any key to continue ('1' to go back): 1
Please enter a positive odd integer for square size: 1
WARNING: '1' may be too big or too small
Please enter any key to continue ('1' to go back): 1
Please enter a positive odd integer for square size: 15
WARNING: '15' may be too big or too small
Please enter any key to continue ('1' to go back): 1
Please enter a positive odd integer for square size: 15
WARNING: '15' may be too big or too small
Please enter any key to continue ('1' to go back): 1
Please enter a positive odd integer for square size: 9
9 by 9 magic square
    47    58    69    80     1    12    23    34    45
    57    68    79     9    11    22    33    44    46
    67    78     8    10    21    32    43    54    56
    77     7    18    20    31    42    53    55    66
     6    17    19    30    41    52    63    65    76
    16    27    29    40    51    62    64    75     5
    26    28    39    50    61    72    74     4    15
    36    38    49    60    71    73     3    14    25
    37    48    59    70    81     2    13    24    35
    
 */