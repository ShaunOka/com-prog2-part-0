package edu.slu.prog2;

public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;
    public Triangle(String name, double s1, double s2, double s3) {
        super(name);
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    @Override
    public double area() {
        double area;
        double semiPerimeter = perimeter()/2;
        area = Math.sqrt((semiPerimeter*(semiPerimeter-side1)*(semiPerimeter-side2)*(semiPerimeter-side3)));
        return area;
    }

    @Override
    public double perimeter() {
        return side1+side2+side3;
    }
}
