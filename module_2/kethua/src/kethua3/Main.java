package kethua3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input X: ");
        float x = Float.parseFloat(scanner.nextLine());
        System.out.println("Input Y: ");
        float y = Float.parseFloat(scanner.nextLine());
        Point testPoint = new Point();
        testPoint.setXY(x, y);
        System.out.println(testPoint.toString());
        System.out.println("input xSpeed: ");
        float xSpeed = Float.parseFloat(scanner.nextLine());
        System.out.println("input ySpeed: ");
        float ySpeed = Float.parseFloat(scanner.nextLine());
        MovablePoint testMovablePoint = new MovablePoint(x, y, xSpeed, ySpeed);
        System.out.println(testMovablePoint.toString());
        testMovablePoint.move();
        System.out.println("index of Point after moving: \n" + testMovablePoint.toString());
    }
}
