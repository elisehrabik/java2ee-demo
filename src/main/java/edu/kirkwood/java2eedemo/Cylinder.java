package edu.kirkwood.java2eedemo;

import edu.kirkwood.shared.Helpers;

public class Cylinder {
    // Attributes
    private Circle base;
    private double height;

    // Default constructor
    public Cylinder() {
        this.base = base;
        this.height = 0.0;
    }

    // Parameterized constructor
    public Cylinder(double radius, double height) {
        this.base = new Circle(radius);
        setHeight(height);
    }

    // Getter and Setter methods
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height < 0) {
            throw new IllegalArgumentException("Height cannot be negative");
        }
        this.height = height;
    }

    // Method to calculate the volume of the cylinder
    public double getVolume(){
        return height * base.getArea();
    }

    // toString Method
    @Override
    public String toString() {
        double radius = base.getRadius();
        double volume = getVolume();
        return Helpers.round(height, 2) + " * π * " + Helpers.round(radius, 2) + " = " + Helpers.round(volume, 2);
    }
}
