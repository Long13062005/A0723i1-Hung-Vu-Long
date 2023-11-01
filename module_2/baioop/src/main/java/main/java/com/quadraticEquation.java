package main.java.com;

import java.util.Scanner;

public class quadraticEquation {
    double a, b, c;

    public quadraticEquation() {
        a = 0;
        b = 0;
        c = 0;
    }

    public quadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant() {
        return (b * b) - 4 * a * c;
    }

    public double getRoot1() {
        return (-b + Math.pow(((b * b) - 4 * a * c), 0.5)) / (2 * a);
    }

    public double getRoot2() {
        return (-b - Math.pow(((b * b) - 4 * a * c), 0.5)) / (2 * a);
    }

    public double rootEqual() {
        return (-b) / (2 * a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("a : ");
        double a = sc.nextDouble();
        System.out.print("b : ");
        double b = sc.nextDouble();
        System.out.print("c : ");
        double c = sc.nextDouble();
        quadraticEquation test = new quadraticEquation(a, b, c);
        if (test.getDiscriminant() < 0) {
            System.out.println("The equation has no roots");
        } else {
            if (test.getDiscriminant() == 0) {
                System.out.println("x = " + test.rootEqual());
            } else {
                System.out.println("x1 = " + test.getRoot1());
                System.out.println("x2 = " + test.getRoot2());
            }
        }
    }
}
