package Intl;

import java.util.Scanner;
import java.util.Stack;

public class TestStr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap n phan tu vao stack : ");
		int n = Integer.parseInt(sc.nextLine());
		Stack<String> in = new Stack<>();
		for(int i = 0; i < n;i++) {
			System.out.print("Nhap so nguyen vao phan tu thu " + (i+1) + " : ");
			String so = sc.nextLine();
			in.push(so);
		}
		System.out.println(in);
		Stack<String> iu = new Stack<>();
		int a = in.size();
		for (int i = 0; i < a; i++) {
            iu.push(in.pop());
        }
		System.out.println(iu);
	}
}


