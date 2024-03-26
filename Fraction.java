/*
 * Name of Student/Programmers:
 * Balanza, Clian
 * Morano, Ian
 * Oka, Shaun Gerald
 * Orlino, Maki
 * Perdido, Jiro
 * Torres, Kate
 * CLASS CODE & Schedule: 9308A/9308B & 2:30pm - 3:30pm MTH (9308A) / 1:30pm - 3:00 pm TF (9308B)
 * Date: March , 2024
 * Instructor: Dale D. Miguel
 */

// code ni Shaun
package edu.slu.prog2;

public class Fraction {
    private int numerator;
    private int denominator;

    /**
     * constructs a fraction with numerator 0 and denominator 1
     */
    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    /**
     * constructs a fraction with numerator whole number
     * @param wholeNumber
     */
    public Fraction(int wholeNumber) {
        numerator = wholeNumber;
        denominator = 1;
    }

    /**
     * constructs a fraction with specified numerator and denominator
     * @param numerator
     * @param denominator
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * sets numerator of fraction to specified numerator
     * @param numerator
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * sets denominator of fraction to specified denominator
     * @param denominator
     */
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /**
     * returns numerator of fraction
     * @return int
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * returns denominator of fraction
     * @return int
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * returns string value of fraction
     * @return String
     */
    @Override
    public String toString() {
        return numerator+"/"+denominator;
    }

    /**
     * returns floating point value of fraction
     * @return double
     */
    public double toDouble() {
        return (double) numerator/denominator;
    }

    /**
     * returns the sum of two fractions
     * @param other
     * @return Fraction
     */
    public Fraction add(Fraction other) {
        int numerator;
        int denominator;
        if (this.denominator == other.denominator) {
            numerator = this.numerator + other.numerator;
            denominator = this.denominator;
        } else {
            denominator = calculateLCM(this.denominator, other.denominator);
            numerator = this.numerator*(denominator/this.denominator) +
                    other.numerator*(denominator/other.denominator);
        }
        return new Fraction(numerator, denominator);
    }

    /**
     * returns the difference of two fractions
     * @param other
     * @return Fraction
     */
    public Fraction subtract(Fraction other) {
        int numerator;
        int denominator;
        if (this.denominator == other.denominator) {
            numerator = this.numerator - other.numerator;
            denominator = this.denominator;
        } else {
            denominator = calculateLCM(this.denominator, other.denominator);
            numerator = this.numerator*(denominator/this.denominator) -
                    other.numerator*(denominator/other.denominator);
        }
        return new Fraction(numerator, denominator);
    }

    /**
     * returns the product of two fractions
     * @param other
     * @return Fraction
     */
    public Fraction multiplyBy(Fraction other) {
        int numerator = this.numerator * other.numerator;
        int denominator = this.denominator * other.denominator;
        return new Fraction(numerator, denominator);
    }

    /**
     * returns the quotient of two fractions
     * @param other
     * @return Fraction
     */
    public Fraction divideBy(Fraction other) {
        int numerator = this.numerator * other.denominator;
        int denominator = this.denominator * other.numerator;
        return new Fraction(numerator, denominator);
    }

    /**
     * returns the reduction of a fraction
     * @return Fraction
     */
    public Fraction simplify() {
        if (numerator == 0) {
            return this;
        }
        int gCF = calculateGCF(this.numerator, this.denominator);
        int numerator = this.numerator/gCF;
        int denominator = this.denominator/gCF;
        return new Fraction(numerator, denominator);
    }

    /**
     * returns the greatest common factor of two numbers
     * @param number1
     * @param number2
     * @return int
     */
    private int calculateGCF(int number1, int number2) {
        if (number1 < number2) {
            int temp = number1;
            number1 = number2;
            number2 = temp;
        }
        int remainder = number1%number2;
        while (remainder != 0) {
            number1 = number2;
            number2 = remainder;
            remainder = number1%number2;
        }
        return number2;
    }

    /**
     * returns the least common multiple of two numbers
     * @param number1
     * @param number2
     * @return int
     */
    private int calculateLCM(int number1, int number2) {
        return number1*number2/calculateGCF(number1, number2);
    }
}
