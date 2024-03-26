package edu.slu.prog2;

public abstract class Shape {
    private String name;
    protected int sides; // number of sides
    public Shape(String n) {
        name = n;
    }
    public String toString() {
        return String.format("Name: %s, No. of Sides: %d", name, sides);
    }

    public int getSides() {
        return sides;
    }
    public abstract double area();
    public abstract double perimeter();
}
