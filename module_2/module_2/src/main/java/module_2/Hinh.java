package module_2;

import java.util.Scanner;

public class Hinh {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Draw the rectangle");
            System.out.println("2. Draw the triangle square");
            System.out.println("3. Draw  isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Draw the rectangle");
                    System.out.print("Width : ");
                    int Width = input.nextInt();
                    System.out.print("Height : ");
                    int Height = input.nextInt();
                    for (int i = 0; i < Height; i++) {
                        System.out.print("\n");
                        for (int j = 0; j < Width; j++) {
                            System.out.print("*");
                        }
                    }
                    System.out.print("\n");
                    break;

                case 2:
                    System.out.println("Draw the triangle square");
                    System.out.print("Height : ");
                    int triHeight = input.nextInt();
                    int choice1 = -1;
                    while (choice1 != 0) {

                        System.out.println("Choose the angle of the triangle \n" +
                                "1. Top-left \n" +
                                "2. Top-right \n" +
                                "3. Bottom-left \n" +
                                "4. Bottom-right\n" +
                                "0. Exit");
                        choice1 = input.nextInt();
                        switch (choice1) {
                            case 1:
                                for (int i = triHeight; i >= 1; i--) {
                                    for (int j = 1; j <= i; j++) {
                                        System.out.print("*");
                                    }
                                    System.out.println();

                                }
                                break;
                            case 2:
                                for (int i = triHeight; i >= 1; i--) {
                                    for (int j = 1; j <= triHeight - i; j++) {
                                        System.out.print(" ");
                                    }
                                    for (int j = 1; j <= i; j++) {

                                        System.out.print("*");
                                    }
                                    System.out.println();

                                }
                                break;
                            case 3:
                                for (int i = 1; i <= triHeight; i++) {
                                    for (int j = 1; j <= i; j++) {
                                        System.out.print("*");
                                    }
                                    System.out.println();
                                }
                                break;
                            case 4:
                                for (int i = 1; i <= triHeight; i++) {
                                    for (int j = 1; j <= triHeight - i; j++) {
                                        System.out.print(" ");
                                    }
                                    for (int j = 1; j <= i; j++) {
                                        System.out.print("*");
                                    }
                                    System.out.println();
                                }
                                break;
                            case 0:
                                System.exit(0);
                            default:
                                System.out.println("Khong hop le");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Draw isosceles triangle");
                    System.out.print("Height : ");
                    int cao = input.nextInt();
                    for (int i = 1; i <= cao; i++) {
                        for (int j = 1; j <= cao - i; j++) {
                            System.out.print(" ");
                        }
                        for (int k = 1; k <= 2 * i - 1; k++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }

    }
}
