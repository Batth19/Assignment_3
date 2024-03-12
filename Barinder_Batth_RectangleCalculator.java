package org.example;

import java.util.Scanner;
abstract class Shape {

    public abstract double Areavalue();

    // Override toString method to return area
    @Override
    public String toString() {
        return "Area: " + Areavalue();
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double Areavalue() {
        return Math.PI * radius * radius;
    }
}

class Square extends Shape {
    private double width;

    public Square(double width) {
        this.width = width;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    @Override
    public double Areavalue() {
        return width * width;
    }
}

class Rectangle extends Square {
    private double height;
    public Rectangle(double width, double height) {
        super(width);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    @Override
    public double Areavalue() {
        return getWidth() * height;
    }
}

public class Barinder_Batth_RectangleCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String repeat = "y";

        while (repeat.equalsIgnoreCase("y")) {
            System.out.print("Enter shape type (C/S/R):");
            String shapeType = input.next();

            if (shapeType.equalsIgnoreCase("C")) {
                double radius = inputDoubleValue("Enter radius value: ", input, 0.0, Double.MAX_VALUE);
                Circle circle = new Circle(radius);
                System.out.println(circle);
            } else if (shapeType.equalsIgnoreCase("S")) {
                double width = inputDoubleValue("Enter width value: ", input, 0.0, Double.MAX_VALUE);
                Square square = new Square(width);
                System.out.println(square);
            } else if (shapeType.equalsIgnoreCase("R")) {
                double width = inputDoubleValue("Enter width value: ", input, 0.0, Double.MAX_VALUE);
                double height = inputDoubleValue("Enter height value: ", input, 0.0, Double.MAX_VALUE);
                Rectangle rectangle = new Rectangle(width, height);
                System.out.println(rectangle);
            } else {
                System.out.println("Invalid Entry");
            }

            repeat = inputContinue(input);
        }
        System.out.println("Thanks for using");
        input.close();
    }

    public static double inputDoubleValue(String prompt, Scanner sc, double minValue, double maxValue) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                double userInputValue = sc.nextDouble();
                if (userInputValue > minValue && userInputValue < maxValue) {
                    return userInputValue;
                } else {
                    System.out.println("Number should be between " + minValue + " and " + maxValue + ".");
                }
            } else {
                System.out.println("Invalid Entry");
                sc.next();
            }
        }
    }

    public static String inputContinue(Scanner sc) {
        while (true) {
            System.out.print("Continue? (y/n): ");
            String input = sc.next();
            if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")) {
                return input;
            } else {
                System.out.println("Error! Entry must be 'y' or 'n'. Try again.");
            }
        }
    }
}
