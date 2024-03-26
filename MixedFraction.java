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

public class MixedFraction extends Fraction{
    private int wholeNumber;

    /**
     * constructs a mixed fraction with whole number 0, numerator 0, and denominator 1
     */
    public MixedFraction() {
        wholeNumber = 0;
    }

    /**
     * constructs a mixed fraction with specified whole number and fraction
     * @param wholeNumber
     * @param fraction
     */
    public MixedFraction(int wholeNumber, Fraction fraction) {
        super(fraction.getNumerator(), fraction.getDenominator());
        this.wholeNumber = wholeNumber;
    }

    /**
     * constructs a mixed fraction with specified whole number, numerator
     * and denominator
     * @param wholeNumber
     * @param numerator
     * @param denominator
     */
    public MixedFraction(int wholeNumber, int numerator, int denominator) {
        super(numerator, denominator);
        this.wholeNumber = wholeNumber;
    }

    /**
     * constructs a mixed fraction with values from a specified fraction
     * @param fraction
     */
    public MixedFraction(Fraction fraction) {
        int numerator = fraction.getNumerator()%fraction.getDenominator();
        int denominator = fraction.getDenominator();
        setNumerator(numerator);
        setDenominator(denominator);
        wholeNumber = fraction.getNumerator()/fraction.getDenominator();
    }

    /**
     * sets the whole number of the mixed fraction
     * @param wholeNumber
     */
    public void setWholeNumber(int wholeNumber) {
        this.wholeNumber = wholeNumber;
    }

    /**
     * sets the fraction part of the mixed fraction
     * @param fraction
     */
    public void setFraction(Fraction fraction) {
        setNumerator(fraction.getNumerator());
        setDenominator(fraction.getDenominator());
    }

    /**
     * returns the whole number of the mixed fraction
     * @return int
     */
    public int getWholeNumberPart() {
        return wholeNumber;
    }

    /**
     * returns the fraction part of the mixed fraction
     * @return Fraction
     */
    public Fraction getFractionPart() {
        return new Fraction(getNumerator(), getDenominator());
    }

    /**
     * returns the converted to fraction form of the mixed fraction
     * @return Fraction
     */
    public Fraction toFraction() {
        int numerator = getNumerator()+(wholeNumber*getDenominator());
        int denominator = getDenominator();
        return new Fraction(numerator, denominator);
    }

    /**
     * returns the string value of the mixed fraction
     * @return String
     */
    @Override
    public String toString() {
        return wholeNumber+" "+getFractionPart().toString();
    }

    /**
     * returns the floating point value of the mixed fraction
     * @return double
     */
    @Override
    public double toDouble() {
        return wholeNumber+getFractionPart().toDouble();
    }

    /**
     * returns the sum of two fractions
     * @param other
     * @return
     */
    @Override
    public MixedFraction add(Fraction other) {
        if (other instanceof MixedFraction) {
            return new MixedFraction(toFraction().add(((MixedFraction) other).toFraction()));
        }
        return new MixedFraction(toFraction().add(other));
    }

    /**
     * returns the difference of two fractions
     * @param other
     * @return Mixed Fraction
     */
    @Override
    public MixedFraction subtract(Fraction other) {
        if (other instanceof MixedFraction) {
            return new MixedFraction(toFraction().subtract(((MixedFraction) other).toFraction()));
        }
        return new MixedFraction(toFraction().subtract(other));
    }

    /**
     * returns the product of two fractions
     * @param other
     * @return Mixed Fraction
     */
    @Override
    public MixedFraction multiplyBy(Fraction other) {
        if (other instanceof MixedFraction) {
            return new MixedFraction(toFraction().multiplyBy(((MixedFraction) other).toFraction()));
        }
        return new MixedFraction(toFraction().multiplyBy(other));
    }

    /**
     * returns the quotient of two fractions
     * @param other
     * @return Mixed Fraction
     */
    @Override
    public MixedFraction divideBy(Fraction other) {
        if (other instanceof MixedFraction) {
            return new MixedFraction(toFraction().divideBy(((MixedFraction) other).toFraction()));
        }
        return new MixedFraction(toFraction().divideBy(other));
    }

    /**
     * returns the reduction of a mixed fraction
     * @return Mixed Fraction
     */
    @Override
    public MixedFraction simplify() {
        return new MixedFraction(toFraction().simplify());
    }

}
