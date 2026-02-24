package Java;

import java.util.Scanner;

public class quadratic {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the value of a, b, c: ");
        int a = kb.nextInt();
        int b = kb.nextInt();
        int c = kb.nextInt();
        int D = b * b - 4 * a * c;
        double root1, root2;
        if (D < 0) {
            System.out.println("Imaginary Roots");
        } else if (D == 0) {
            root1 = -b /( 2 * a);
            root2 = root1;
            System.out.println("Root 1: " + root1);
            System.out.println("Root 2: " + root2);
        } else {
            root1 = (-b + Math.sqrt(D)) / 2 * a;
            root2 = (-b - Math.sqrt(D)) / 2 * a;
            System.out.println("Root 1: " + root1);
            System.out.println("Root 2: " + root2);
        }

    }
}
