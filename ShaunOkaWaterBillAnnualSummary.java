/*
Name/Author : Oka, Shaun Gerald D.
Class Code  : 9308A/9308B
Course No.  : CS 122/122L
Schedule    : 2:30pm - 3:30pm MTH (9308A) / 1:30pm - 3:00 pm TF (9308B)
Date        : January 23, 2024
 */
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
public class ShaunOkaWaterBillAnnualSummary{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] beginWater = new int[12];
        int[] presentWater = new int[12];
        int[] cubicMeterUsed = new int[12];
        double[] duePayment = new double[12];
        int cutOffResidential = 12;
        int cutOffCommercial = 30;
        double minResidential = 180.00F;
        double minCommercial = 600.00F;
        float priceResidential = 30.00F;
        float priceCommercial = 50.00F;
        introduction();
        System.out.print("Please enter your name: ");
        String consumerName = scanner.nextLine();
        char consumerType = whichConsumer(scanner);
        beginWater[0] = beginRead(scanner);
        for (int index = 0; index < presentWater.length; index++) {
            presentWater[index] = presentRead(scanner, index, beginWater);
            if (index < presentWater.length - 1) {
                beginWater[index+1] = presentWater[index];
            }
            cubicMeterUsed[index] = presentWater[index]-beginWater[index];
            duePayment[index] = computePayment(cubicMeterUsed[index], consumerType, cutOffResidential, cutOffCommercial,
                    minResidential, minCommercial, priceResidential, priceCommercial);
        }
        summary(consumerName, consumerType, beginWater, presentWater, cubicMeterUsed, duePayment);
    }
    /**
      ALGORITHM:
      1. display a welcome message with the program's name.
      2. describe the program's purpose (summarizing water bills for the year).
      3. describe the rates of residential and commercial consumers
     */
    public static void introduction() {
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
    /** ALGORITHM:
     1. declare variables to store input "temp" and consumer type.
     2. initiate loop to prompt for valid input.
     3. in the loop:
     - prompt user to enter consumer type (r or c).
     - read the user's input as a string.
     - get the lower-cased first character of the input as the consumer type.
     - check if input has only one character and is valid (r or c).
     - if invalid, display error message and continue looping.
     - if valid, break the loop.
     4. return the valid consumer type.
     */
    public static char whichConsumer(Scanner scanner) {
        String temp;
        char consumerType;
        do {
            System.out.print("Please enter type of consumer, r for residential or c for commercial: ");
            temp = scanner.nextLine();
            consumerType = temp.toLowerCase().charAt(0);
            if (temp.length() > 1 || consumerType != 'r' && consumerType != 'c') {
                System.out.println("Please choose to type only r or c");
            }
        } while (temp.length() > 1 || consumerType != 'r' && consumerType != 'c');
        return consumerType;
    }
    /** ALGORITHM:
     1. declare variable for the reading in the beginning of the year.
     2. enter loop that continues if invalid.
     3. prompt user the meter reading.
     4. parse the input as integer.
     5. if parsing fails, display error message.
     6. if parsing succeeds, check if reading is negative.
     7. if negative, display error message.
     8. if valid, break the loop.
     9. return reading.
     */
    public static int beginRead(Scanner scanner) {
        int beginWater = 0;
        do {
            try {
                System.out.print("Please enter meter reading at the start of the year: ");
                beginWater = Integer.parseInt(scanner.nextLine());
                if (beginWater < 0) {
                    System.out.println("Please only type a positive value");
                }
            } catch (NumberFormatException error) {
                beginWater = -1;
                System.out.println("Please only type digit characters");
            }
        } while (beginWater < 0);
        return beginWater;
    }
    /** ALGORITHM:
     1. declare variable to store present water reading.
     2. enter loop that continues if invalid.
     3. prompt user to enter the meter reading for the specified month.
     4. parse input as integer.
     5. if failed, display an error message.
     6. if succeeded, check reading if less than the previous reading.
     7. if invalid, display error message.
     8. if valid, break loop.
     9. return the valid reading.
     */
    public static int presentRead(Scanner scanner, int index, int[] beginWater) {
        int presentWater = 0;
        do {
            try {
                System.out.print("Please enter meter reading for "+monthWord(index+1)+": ");
                presentWater = Integer.parseInt(scanner.nextLine());
                if (presentWater < beginWater[index]) {
                    System.out.println("Value must be greater than previous reading");
                }
            } catch (NumberFormatException error) {
                presentWater = -1;
                System.out.println("Please only type digit characters");
            }
        } while (presentWater < beginWater[index]);
        return presentWater;
    }
    /** ALGORITHM:
     1. use switch statement to map month number 1-12.
     2. for each case 1-12, return appropriate month name as string.
     3. if month number is outside 1-12, return empty string.
     */
    public static String monthWord(int index) {
        return switch (index) {
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
    }
    /** ALGORITHM:
     1. initialize duePayment variable to 0.
     2. use switch statement to check consumer type.
     3. if residential:
     - if consumption is more than the minimum, duePayment due is minimum bill plus excess consumption * rate.
     - else, set duePayment to minimum bill.
     4. if commercial:
     - if consumption is more than the minimum, duePayment due is minimum bill plus excess consumption * rate.
     - else, set duePayment to minimum bill.
     5. return duePayment.
     */
    public static double computePayment(int cubicMeterUsed, char consumerType,  int cutOffResidential, int cutOffCommercial,
                                       double minResidential, double minCommercial, float priceResidential, float priceCommercial){
        double duePayment = 0.00;
        switch (consumerType) {
            case 'r':
                if (cubicMeterUsed > cutOffResidential) {
                    duePayment = minResidential + (cubicMeterUsed - cutOffResidential)*priceResidential;
                } else {
                    duePayment = minResidential;
                }
                break;

            case 'c':
                if (cubicMeterUsed > cutOffCommercial) {
                    duePayment = minCommercial + (cubicMeterUsed - cutOffCommercial)*priceCommercial;
                } else {
                    duePayment = minResidential;
                }
                break;
        }
        return duePayment;
    }
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
    public static void summary(String consumerName, char consumerType, int[] beginWater, int[] presentWater, int[] cubicMeterUsed, double[] duePayment) {
        System.out.printf("%nAnnual Water Bill Summary%n");
        System.out.println("Name of Consumer: " + consumerName);
        System.out.print("Type of consumer: ");
        switch (consumerType) {
            case 'r' -> System.out.println("Residential");
            case 'c' -> System.out.println("Commercial");
        }
        System.out.println("Meter reading at the beginning of year = " + beginWater[0] + " cubic meters");
        System.out.printf("%15s%15s%15s%20s%n", "---------------", "--------------", "---------------", "--------------------");
        System.out.printf("%15s%15s%15s%20s%n", "Month", "End Reading", "Consumption", "Amount Paid");
        System.out.printf("%15s%15s%15s%20s%n", "---------------", "--------------", "---------------", "--------------------");
        for (int index=0; index < beginWater.length; index++){
            System.out.printf("%15s%15d%15d%20.2f%n", monthWord(index+1), presentWater[index],cubicMeterUsed[index] , duePayment[index]);
        }
        System.out.printf("%15s%15s%15s%20s%n", "---------------", "--------------", "---------------", "--------------------");
        System.out.println("Average Monthly Reading = "+ average(cubicMeterUsed));
        System.out.println("Average Monthly Payment = "+ average(duePayment));
        System.out.println("Month with Lowest Water Consumption = "+ monthWord((lowest(cubicMeterUsed) + 1)));
        System.out.println("Month with Highest Water Consumption = "+ monthWord((highest(cubicMeterUsed) + 1)));
        System.out.printf("%15s%15s%15s%20s%n", "---------------", "--------------", "---------------", "--------------------");
        return;
    }
    /**Computes and returns the average of the elements an array of integers*/
    public static double average(int[] numberArray) {
        double averageNumber = 0.00;
        for (int element:numberArray) {
            averageNumber += element;
        }
        averageNumber = averageNumber/numberArray.length;
        return averageNumber;
    }
    /**Computes and returns the average of the elements an array of floating point values*/
    public static double average(double[] numberArray) {
        double averageNumber = 0.00;
        for (double element:numberArray) {
            averageNumber += element;
        }
        averageNumber = averageNumber/numberArray.length;
        return averageNumber;
    }
    /**The following method finds and returns the index of the element with the lowest value
     from an array of positive integers. The Linear Search algorithm is applied.*/
    public static int lowest(int[] numberArray) {
        int index = 0;
        int result = numberArray[0];
        for (int element:numberArray){
            if (element < result) {
                result = element;
            }
        }
        for (index = 0; index < numberArray.length; index++) {
            if (numberArray[index] == result) {
                return index;
            }
        }
        return -1;
    }
    /**Finds and returns the index of the element with the highest value from an array of integers*/
    public static int highest(int[] numberArray) {
        int index = 0;
        int result = numberArray[0];
        for (int element:numberArray){
            if (element > result) {
                result = element;
            }
        }
        for (index = 0; index < numberArray.length; index++) {
            if (numberArray[index] == result) {
                return index;
            }
        }
        return -1;
    }
}

/*
SHOW A SAMPLE RUN OF THE PROGRAM WITHIN THIS COMMENT DELIMITERS

/// Welcome to Shaun's Annual Water Bill Services! \\\
This program will summarize your water bill for the entire year.

Residential consumers that doesn't exceed 12 cubic meters get a minimum payment of 180.00 per month
Exceeding water consumed have a price of 30.00 per cubic meter

Commercial consumers that doesn't exceed 30 cubic meters get a minimum payment of 600.00 per month
Exceeding water consumed have a price of 50.00 per cubic meter

Please enter your name: Shaun
Please enter type of consumer, r for residential or c for commercial: adwwd
Please choose to type only r or c
Please enter type of consumer, r for residential or c for commercial: rc
Please choose to type only r or c
Please enter type of consumer, r for residential or c for commercial: c
Please enter meter reading at the start of the year: adwwa
Please only type digit characters
Please enter meter reading at the start of the year: -1
Please only type a positive value
Please enter meter reading at the start of the year: 0
Please enter meter reading for January: 1
Please enter meter reading for February: 5
Please enter meter reading for March: 10
Please enter meter reading for April: 25
Please enter meter reading for May: 24
Value must be greater than previous reading
Please enter meter reading for May: 26
Please enter meter reading for June: 30
Please enter meter reading for July: 40
Please enter meter reading for August: 57
Please enter meter reading for September: 70
Please enter meter reading for October: 120
Please enter meter reading for November: 300
Please enter meter reading for December: 500

Annual Water Bill Summary
Name of Consumer: Shaun
Type of consumer: Commercial
Meter reading at the beginning of year = 0 cubic meters
--------------- -------------------------------------------------
          Month    End Reading    Consumption         Amount Paid
--------------- -------------------------------------------------
        January              1              1              180.00
       February              5              4              180.00
          March             10              5              180.00
          April             25             15              180.00
            May             26              1              180.00
           June             30              4              180.00
           July             40             10              180.00
         August             57             17              180.00
      September             70             13              180.00
        October            120             50             1600.00
       November            300            180             8100.00
       December            500            200             9100.00
--------------- -------------------------------------------------
Average Monthly Reading = 41.666666666666664
Average Monthly Payment = 1701.6666666666667
Month with Lowest Water Consumption = January
Month with Highest Water Consumption = December
--------------- -------------------------------------------------

Process finished with exit code 0

*/