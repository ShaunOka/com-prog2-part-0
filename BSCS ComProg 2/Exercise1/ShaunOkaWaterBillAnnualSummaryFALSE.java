/** (Hypothetical Annual Water Bill Summary Problem )
 The water bills for the 12 months of a year by a water service
 subscriber is summarized as follows.
 Inputs:
 Water Meter Reading at the beginning of the year (i.e. January 1)
 Water Meter Readings at the end of each of the 12 months
 Payment Rates (Minimum Bill, price of water per cubic meter)
 Outputs:
 Cubic meters of water consumed for each month (monthly consumption)
 Amount paid for each month based on given rates (monthly payment)
 Average of monthly consumptions
 Average of monthly payments
 The month during which the amount of water consumed is highest
 The month during which the amount of water consumed is lowest
 Algorithm
 1.Read the name of the water consumer (consumer).
 2.Read The classification (consumerType) of the consumer such
 that the only valid values for consumerType is "commercial" or "residential".
 3.Read water meter reading in cubic meters at the beginning of the year([0]).
 4.For month 1 to 12
 Read the water meter reading in cubic meters at the end of the month (presentR) such
 that presentR cannot be less than previousR. Store the value in an array.
 Compute the volume of water consumed for the month (consumption)
 by subtracting the previousR from presentR. Store the value in an array.
 Compute the amount due (amountDue) from the consumer based on
 the following rules
 If consumerType is residential and consumption <= 12, the amount due is 180.00
 If consumerType is residential and consumption > 12, the amount due is 180.00 + (consumption – 12)*30.00
 If consumerType is commercial and consumption <= 30, the amount due is 600.00
 If consumerType is commercial and consumption > 30, the amount due is 600.00 + (consumption – 30)*50.00
 Store the value in an array.
 5. Determine the average of the monthly water consumptions.
 6. Determine the average of the monthly payments.
 7. Determine the month during which water consumed is highest.
 8. Determine the month during which water consumed is least.
 9. Print the name of the consumer.
 10. Print the consumer type.
 11. Print the water meter reading at the beginning of the year.
 12. Print a table showing the 12 months, water meter readings at
 the end of each month, the amount paid due to the water
 consumption for each month.
 13. Print the average of the monthly water consumptions.
 14. Print the average of the monthly payments.
 15. Print the month during which water consumption is highest.
 16. Print the month during which water consumption is lowest.
 */
// You may modify the algorithm/program as you deem necessary

import java.util.Scanner;
public class ShaunOkaWaterBillAnnualSummaryFALSE {
    public static void main(String[] args) {
        int[] presentReading = new int[12];
        int[] startReading = new int[12];
        Scanner scanner = new Scanner(System.in);
        String consumer=""; // to hold name of consumer
        char consumerType = 'x'; // to hold type of consumer
        int[] cubicMeterUsed = new int[12]; /* to hold number of cubic meters of water used for 12 months */
        int minCMResidential=12; /*to hold cut-off for minimum Bill for residential consumers */
        double minBillResidential=180.00; // minimum bill for <= 12 Cubic Meters used
        float rateResidential =30.00F; //cost of 1 Cubic Meter above the min. consumption
        int minCMCommercial=30; /* to hold cut-off for minimum Bill for commercial consumers*/
        double minBillCommercial=600.00; // minimum bill for <= 20Cubic Meters used
        float rateCommercial =50.00F; /*cost of 1 Cubic Meter above the min. consumption for commercial consumers*/
        double[] amountDue= new double[12]; // to hold the amount paid for 12 months
        showIntroduction();
        System.out.print("Enter the name of the water consumer: ");
        consumer = scanner.nextLine();
        consumerType = readTypeOfConsumer(scanner);
        startReading[0] = readStartReading(scanner);
        for (int index=0; index < cubicMeterUsed.length; index++){
            presentReading[index] = readEndOfMonthReading(startReading[index], (index+1), scanner);
            if (index < (cubicMeterUsed.length - 1))
                startReading[index+1] = presentReading[index];
            cubicMeterUsed[index] = presentReading[index] - startReading[index];
            amountDue[index] = computeAmountDue(cubicMeterUsed[index], consumerType, minCMResidential, minBillResidential,
                    minCMCommercial, minBillCommercial, rateResidential, rateCommercial);
        }
        showSummary(consumer, consumerType, startReading, presentReading, cubicMeterUsed, amountDue);
        System.exit(0);
    } // end of main method
    /**Computes and returns the average of the elements an array of floating point numbers*/
    public static double computeAverage(double[] values){
        double total=0; // to hold the total of all elements
        double average=0; // to hold the average
        for (double element : values) // add the elements
            total += element;
        //compute the average
        average = total/values.length ; // total divided by number of elements
        return average;
    }
    /**Computes and returns the average of the elements an array of integers*/
    public static double computeAverage(int[] values){
        double total=0; // to hold the total of all elements
        double average=0; // to hold the average
        for (int element : values) // add the elements
            total = total + element;
        //compute the average
        average = (double) total/values.length ; //total divided by number of elements
        return average;
    }
    /**The following method finds and returns the index of the element with the lowest value
    from an array of positive integers. The Linear Search algorithm is applied.*/
    public static int findLowest(int[] values){
        int result=values[0]; // let lowest be the first element
        for (int element : values ) // find out if an element after the first is lower
            if (element < result)
                result = element; // then set lowest index to the index of lower element
        int index = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == result) {
                index = i;
                break;
            }
        }
        return index;
    }
    /**Finds and returns the index of the element with the highest value from an array of integers*/
    public static int findHighest(int[] values){
        int result=values[0]; // let highest be the first element
        for (int element: values ) // find out if an element after the first is higher
            if (element > result)
                result = element; //then set highest index to the index of higher element
        int index = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == result) {
                index = i;
                break;
            }
        }
        return index;
    }
    // REQUIRED: Show the algorithm through a multiline comment
     /** ALGORITHM:
         1. display header for summary.
         2. print name.
         3. print type of consumer (residential or commercial).
         4. print initial meter reading.
         5. print a table header for the month, end reading, consumption, and amount paid.
         6. iterate through each month:
             - print month name.
             - print end reading for that month.
             - print water consumption for that month.
             - print amount paid for that month.
         7. print dividing line after the table.
         8. print average monthly consumption.
         9. print average monthly payment.
         10. print month with the lowest water consumption.
         11. print month with the highest water consumption.
         12. print final dividing line.
     */
    public static void showSummary(String consumer, char consumerType, int[] startReading,
                                   int[] presentReading, int[] cubicMeterUsed, double[] amountDue){
        System.out.println();
        System.out.println("Annual Water Bill Summary");
        System.out.println("Name of Consumer: " + consumer);
        System.out.print("Type of consumer: ");
        if (Character.toLowerCase(consumerType) == 'r')
            System.out.println("Residential");
        if (Character.toLowerCase(consumerType) == 'c')

            System.out.println("Commercial");
        System.out.println("Meter reading at the beginning of year = " + startReading[0] + " cubic meters");
                System.out.printf("%15s%15s%15s%20s%n", "---------------", "--------------", "---------------", "--------------------");
                System.out.printf("%15s%15s%15s%20s%n", "Month", "End Reading", "Consumption", "Amount Paid");
                                System.out.printf("%15s%15s%15s%20s%n", "---------------", "--------------", "---------------", "--------------------");
        for (int index=0; index < startReading.length; index++){
            System.out.printf("%15s%15d%15d%20.2f%n", monthInWord(index+1), presentReading[index],cubicMeterUsed[index] , amountDue[index]);
        }
        System.out.printf("%15s%15s%15s%20s%n", "---------------", "--------------", "---------------", "--------------------");
        System.out.println("Average Monthly Reading = "+ computeAverage(cubicMeterUsed));
        System.out.println("Average Monthly Payment = "+ computeAverage(amountDue));
        System.out.println("Month with Lowest Water Consumption = "+ monthInWord((findLowest(cubicMeterUsed) + 1)));
        System.out.println("Month with Highest Water Consumption = "+ monthInWord((findHighest(cubicMeterUsed) + 1)));
        System.out.printf("%15s%15s%15s%20s%n", "---------------", "--------------", "---------------", "--------------------");
        return;
    }
    // REQUIRED: Show the algorithm through a multiline comment
    /** ALGORITHM:
        1. use switch statement to map month number (1-12).
        2. for each case (1-12), return appropriate month name as string.
        3. if month number is outside range (1-12), return empty string.
     */
    public static String monthInWord(int month){
        // end of switch
        String monthWord = switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "";
        };
        return monthWord;
    } // end of monthInWord method
    //REQUIRED: Provide the algorithm and the code
    /**
      ALGORITHM:
      1. display a welcome message with the program's name.
      2. describe the program's purpose (summarizing water bills for the year).
      3. describe the rates of residential and commercial consumers
     */
    public static void showIntroduction(){
    // REQUIRED: Provide the code
        System.out.println("/// Welcome to Shaun's Annual Water Bill Services! \\\\\\");
        System.out.println("This program will summarize your water bill for the entire year.");
        /*
        If consumerType is residential and consumption <= 12, the amount due is 180.00
        If consumerType is residential and consumption > 12, the amount due is 180.00 + (consumption – 12)*30.00
        If consumerType is commercial and consumption <= 30, the amount due is 600.00
        If consumerType is commercial and consumption > 30, the amount due is 600.00 + (consumption – 30)*50.00
        */
        System.out.println("""
                
                Residential consumers that doesn't exceed 12 cubic meters get a minimum payment of 180.00 per month
                Exceeding water consumed have a price of 30.00 per cubic meter
                
                Commercial consumers that doesn't exceed 30 cubic meters get a minimum payment of 600.00 per month
                Exceeding water consumed have a price of 50.00 per cubic meter
                """);
        return;
    }
    // REQUIRED: Provide the algorithm and provide missing statements to complete the code
    /** ALGORITHM:
      1. declare variables for the reading and flag.
      2. enter loop that continues if there are still input problems or the reading is invalid.
      3. prompt user the meter reading.
      4. parse the input as integer.
      5. if parsing fails, set flag and display error message.
      6. if parsing succeeds, check if reading is negative.
      7. if negative, display error message.
      8. if valid, break the loop.
      9. return reading.
    */
    public static int readStartReading(Scanner scanner){
        /* REQUIRED: Declare local variables */
        boolean problemFlag;
        int reading = 0;
        do {
            problemFlag = false;
            try {
                System.out.print("Enter the meter reading at the beginning of the year: ");
                // REQUIRED: Provide the input statement
                reading = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException x){
                problemFlag = true;
                System.out.println("You have to enter a number.");
            }
            if (reading < 0){
                System.out.println("The beginning meter reading cannot be negative.");
            }
        } while (reading < 0 || problemFlag);
        return reading;
    }
    // REQUIRED: Provide the algorithm and provide the missing statements to complete the code
    /** ALGORITHM:
        1. declare variables to store reading and flag.
        2. enter loop that continues if there are input problems or if invalid.
        3. prompt user to enter the meter reading for the specified month.
        4. parse input as integer.
        5. if failed, set the flag and display an error message.
        6. if succeeded, check reading if less than the previous reading.
        7. if invalid, display error message.
        8. if valid, break loop.
        9. return the valid reading.
     */
    public static int readEndOfMonthReading(int startReading, int index, Scanner scanner){
        /*REQUIRED: Declare local variables */
        int reading = 0;
        boolean pFlag;
        do {
            try {
                pFlag = false;
                System.out.print("Enter the meter reading for month " + monthInWord(index) + ": ");
                //REQUIRED: Provide the necessary input statement
                reading = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException x){
                pFlag = true;
                System.out.println("You have to enter a number.");
            }
            if (reading < startReading){
                System.out.println("Invalid datum entry! The present reading must be greater than the previous reading.");
            }
        } while (reading < startReading || pFlag);
        return reading;
    }
    // REQUIRED: Provide the algorithm and provide the missing statements to complete the code
    /** ALGORITHM:
        1. declare variables to store input "temp" and consumer type "t".
        2. initiate loop to prompt for valid input.
        3. in the loop:
            - prompt user to enter consumer type (r or c).
            - read the user's input as a string.
            - get the first character of the input as the consumer type.
            - check if input is valid (r, R, c, or C) and has only one character.
            - if invalid, display error message and continue looping.
            - if valid, break the loop.
        4. return the valid consumer type.
    */
    public static char readTypeOfConsumer(Scanner scanner){
        /*REQUIRED: Declare local variables */
        String temp;
        char type;
        do {
            System.out.print("Enter the type of the consumer, you may type r for residential or c for commercial: ");
            //REQUIRED: Provide needed statement(s)
            temp = scanner.nextLine();
            type = temp.charAt(0);
            if (type != 'r' && type != 'R' && type != 'c' && type != 'C' || temp.length() > 1) {
                System.out.println("The valid types are r for residential and c for commercial.");
            }
        } while (type != 'r' && type != 'R' && type != 'c' && type != 'C' || temp.length() > 1);
        return type;
    }

    // REQUIRED: Show the algorithm through a multiline comment
    /** ALGORITHM:
        1. initialize amount variable to 0.
        2. use switch statement to check consumer type.
        3. if residential:
            - if consumption is less than or equal to minimum, set amount to minimum bill.
            - else, amount due is minimum bill plus excess consumption * rate.
        4. if commercial:
            - if consumption is less than or equal to minimum, set amount to minimum bill.
            - else, amount due is minimum bill plus excess consumption * rate.
        5. return amount.
     */
    public static double computeAmountDue(int cubicMeterUsed, char consumerType, int minCMResidential, double minBillResidential, int minCMCommercial,
                                          double minBillCommercial, float rateResidential, float rateCommercial){
        double amount = 0;
        switch (consumerType){
            case 'r':
            case 'R':
                if ( cubicMeterUsed <= minCMResidential ) {
                    amount = minBillResidential;
                }
                else {
                    amount = minBillResidential + (cubicMeterUsed-minCMResidential)*rateResidential;
                }
                break;
            case 'c':
            case 'C':
                if ( cubicMeterUsed <= minCMCommercial ) {
                    amount = minBillCommercial;
                }
                else {
                    amount = minBillCommercial + (cubicMeterUsed-minCMCommercial)*rateCommercial;
                }
        }
        return amount;
    }
} // end of class

/*
SHOW A SAMPLE RUN OF THE PROGRAM WITHIN THIS COMMENT DELIMITERS
/// Welcome to Shaun's Annual Water Bill Services! \\\
This program will summarize your water bill for the entire year.

Residential consumers that doesn't exceed 12 cubic meters get a minimum payment of 180.00 per month
Exceeding water consumed have a price of 30.00 per cubic meter

Commercial consumers that doesn't exceed 30 cubic meters get a minimum payment of 600.00 per month
Exceeding water consumed have a price of 50.00 per cubic meter

Enter the name of the water consumer: Shaun
Enter the type of the consumer, you may type r for residential or c for commercial: rc
The valid types are r for residential and c for commercial.
Enter the type of the consumer, you may type r for residential or c for commercial: cr
The valid types are r for residential and c for commercial.
Enter the type of the consumer, you may type r for residential or c for commercial: r
Enter the meter reading at the beginning of the year: -1
The beginning meter reading cannot be negative.
Enter the meter reading at the beginning of the year: 0
Enter the meter reading for month January: -1
Invalid datum entry! The present reading must be greater than the previous reading.
Enter the meter reading for month January: 1
Enter the meter reading for month February: 10
Enter the meter reading for month March: 20
Enter the meter reading for month April: 50
Enter the meter reading for month May: 70
Enter the meter reading for month June: 100
Enter the meter reading for month July: 150
Enter the meter reading for month August: 260
Enter the meter reading for month September: 500
Enter the meter reading for month October: 680
Enter the meter reading for month November: 870
Enter the meter reading for month December: 930

Annual Water Bill Summary
Name of Consumer: Shaun
Type of consumer: Residential
Meter reading at the beginning of year = 0 cubic meters
--------------- -------------------------------------------------
          Month    End Reading    Consumption         Amount Paid
--------------- -------------------------------------------------
        January              1              1              180.00
       February             10              9              180.00
          March             20             10              180.00
          April             50             30              720.00
            May             70             20              420.00
           June            100             30              720.00
           July            150             50             1320.00
         August            260            110             3120.00
      September            500            240             7020.00
        October            680            180             5220.00
       November            870            190             5520.00
       December            930             60             1620.00
--------------- -------------------------------------------------
Average Monthly Reading = 77.5
Average Monthly Payment = 2185.0
Month with Lowest Water Consumption = January
Month with Highest Water Consumption = September
--------------- -------------------------------------------------

Process finished with exit code 0

*/
