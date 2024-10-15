package edu.kirkwood.java2eedemo;

public class Circle {
    // Attributes
    private double radius;

    // Default Constructor
    public Circle() {
        this.radius =  0.0;
    }

    // Parameterized Constructor
    public Circle(double radius) {
        setRadius(radius);
    }

    // Getter and Setter methods

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius < 0.0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        this.radius = radius;
    }

    // Method to calculate the area of the circle
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
