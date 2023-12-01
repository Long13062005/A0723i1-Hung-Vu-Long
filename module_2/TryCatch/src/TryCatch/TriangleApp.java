package TryCatch;
import java.util.Scanner;

class IllegalTriangleException extends Exception {
    public IllegalTriangleException(String message) {
        super(message);
    }
}

class Triangle {
    private double side1, side2, side3;

    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0 || side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalTriangleException("Invalid triangle sides: " + side1 + ", " + side2 + ", " + side3);
        }

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }


public class TriangleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter side 1 of the triangle: ");
            double side1 = scanner.nextDouble();

            System.out.print("Enter side 2 of the triangle: ");
            double side2 = scanner.nextDouble();

            System.out.print("Enter side 3 of the triangle: ");
            double side3 = scanner.nextDouble();

            Triangle triangle = new Triangle(side1, side2, side3);

            System.out.println("Triangle sides: " + side1 + ", " + side2 + ", " + side3);
        } catch (IllegalTriangleException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input");
        } finally {
            scanner.close();
        }
    }
	}
}
