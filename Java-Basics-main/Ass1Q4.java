package Java;

import java.util.Scanner;

// Define the Shape interface
interface Shape {
    double area();
    double perimeter();
}

// Implement the Shape interface for a Circle
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

// Implement the Shape interface for a Rectangle
class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

// Implement the Shape interface for a Triangle
class Triangle implements Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double area() {
        // Using Heron's formula to calculate the area of a triangle
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }
}

public class Ass1Q4 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.println("Choose a shape to calculate its area and perimeter:");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        System.out.print("Enter your choice (1/2/3): ");
        int choice = kb.nextInt();

        double area = 0.0;
        double perimeter = 0.0;

        switch (choice) {
            case 1:
                System.out.print("Enter the radius of the circle: ");
                double radius = kb.nextDouble();
                Circle circle = new Circle(radius);
                area = circle.area();
                perimeter = circle.perimeter();
                break;
            case 2:
                System.out.print("Enter the length of the rectangle: ");
                double length = kb.nextDouble();
                System.out.print("Enter the width of the rectangle: ");
                double width = kb.nextDouble();
                Rectangle rectangle = new Rectangle(length, width);
                area = rectangle.area();
                perimeter = rectangle.perimeter();
                break;
            case 3:
                System.out.print("Enter the lengths of the three sides of the triangle (space-separated): ");
                double side1 = kb.nextDouble();
                double side2 = kb.nextDouble();
                double side3 = kb.nextDouble();
                Triangle triangle = new Triangle(side1, side2, side3);
                area = triangle.area();
                perimeter = triangle.perimeter();
                break;
            default:
                System.out.println("Invalid choice.");
                kb.close();
                System.exit(0);
        }

        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);

        kb.close();
    }
}

