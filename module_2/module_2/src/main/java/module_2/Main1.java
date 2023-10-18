package module_2;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        int usd, vnd;
        int rate = 23000;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter USD convert to VND : ");
        usd = Integer.parseInt(sc.nextLine());
        vnd = usd * rate;
        System.out.println("VND : " + vnd + "D");
    }
}
