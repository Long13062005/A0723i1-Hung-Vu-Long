package module_2;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number to convert : ");
        int n = Integer.parseInt(sc.nextLine());
        if (n <= 10 && n >= 0) {
            switch (n) {
                case 0:
                    System.out.println("zero");
                    break;
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 3:
                    System.out.println("three");
                    break;
                case 4:
                    System.out.println("four");
                    break;
                case 5:
                    System.out.println("five");
                    break;
                case 6:
                    System.out.println("six");
                    break;
                case 7:
                    System.out.println("seven");
                    break;
                case 8:
                    System.out.println("eight");
                    break;
                case 9:
                    System.out.println("nine");
                    break;
                case 10:
                    System.out.println("ten");
                    break;
                default:
                    System.out.println("out of ability");
                    break;
            }
        } else if (n > 10 && n <= 20) {
            int one = n % 10;
            switch (one) {
                case 0:
                    System.out.println("Twenty");
                    break;
                case 1:
                    System.out.println("eleven");
                    break;
                case 2:
                    System.out.println("twelve");
                    break;
                case 3:
                    System.out.println("thirteen");
                    break;
                case 4:
                    System.out.println("fourteen");
                    break;
                case 5:
                    System.out.println("fifteen");
                    break;
                case 6:
                    System.out.println("sixteen");
                    break;
                case 7:
                    System.out.println("seventeen");
                    break;
                case 8:
                    System.out.println("eightteen");
                    break;
                case 9:
                    System.out.println("nineteen");
                    break;
                default:
                    System.out.println("out of ability");
                    break;
            }
        } else if (n > 20 && n <= 99) {
            int two = n / 10;
            int ones = n % 10;
            switch (two) {
                case 2:
                    System.out.print("twenty");
                    break;
                case 3:
                    System.out.print("thirty");
                    break;
                case 4:
                    System.out.print("fourty");
                    break;
                case 5:
                    System.out.print("fifty");
                    break;
                case 6:
                    System.out.print("sixty");
                    break;
                case 7:
                    System.out.print("seventy");
                    break;
                case 8:
                    System.out.print("eighty");
                    break;
                case 9:
                    System.out.print("ninety");
                    break;
                default:
                    System.out.print("out of ability ");
                    break;
            }
            switch (ones) {
                case 0:
                    System.out.println(" zero");
                    break;
                case 1:
                    System.out.println(" one");
                    break;
                case 2:
                    System.out.println(" two");
                    break;
                case 3:
                    System.out.println(" three");
                    break;
                case 4:
                    System.out.println(" four");
                    break;
                case 5:
                    System.out.println(" five");
                    break;
                case 6:
                    System.out.println(" six");
                    break;
                case 7:
                    System.out.println(" seven");
                    break;
                case 8:
                    System.out.println(" eight");
                    break;
                case 9:
                    System.out.println(" nine");
                    break;
                default:
                    System.out.println("out of ability");
                    break;
            }

        } else if (n >= 100 && n < 1000) {
            int three = n / 100;
            int two = (n % 100) / 10;
            int ones = n % 10;
            switch (three) {
                case 1:
                    System.out.print("One hundred ");
                    break;
                case 2:
                    System.out.print("Two hundred ");
                    break;
                case 3:
                    System.out.print("Three hundred ");
                    break;
                case 4:
                    System.out.print("Four hundred ");
                    break;
                case 5:
                    System.out.print("Five hundred ");
                    break;
                case 6:
                    System.out.print("Six hundred ");
                    break;
                case 7:
                    System.out.print("Seven hundred ");
                    break;
                case 8:
                    System.out.print("Eight hundred ");
                    break;
                case 9:
                    System.out.print("Nine hundred ");
                    break;
                default:
                    System.out.print("out of ability");
                    break;
            }
            switch (two) {
                case 1:
                    System.out.print(" one ");
                    break;
                case 2:
                    System.out.print(" twenty ");
                    break;
                case 3:
                    System.out.print(" thirty ");
                    break;
                case 4:
                    System.out.print(" fourty ");
                    break;
                case 5:
                    System.out.print(" fifty ");
                    break;
                case 6:
                    System.out.print(" sixty ");
                    break;
                case 7:
                    System.out.print(" seventy");
                    break;
                case 8:
                    System.out.print(" eighty ");
                    break;
                case 9:
                    System.out.print(" ninety ");
                    break;
                default:
                    System.out.print("and");
                    break;
            }
            switch (ones) {
                case 0:
                    System.out.println(" zero ");
                    break;
                case 1:
                    System.out.println(" one ");
                    break;
                case 2:
                    System.out.println(" two ");
                    break;
                case 3:
                    System.out.println(" three ");
                    break;
                case 4:
                    System.out.println(" four ");
                    break;
                case 5:
                    System.out.println(" five ");
                    break;
                case 6:
                    System.out.println(" six ");
                    break;
                case 7:
                    System.out.println(" seven ");
                    break;
                case 8:
                    System.out.println(" eight ");
                    break;
                case 9:
                    System.out.println(" nine ");
                    break;
                default:
                    System.out.println("out of ability");
                    break;
            }
        }
    }
}
