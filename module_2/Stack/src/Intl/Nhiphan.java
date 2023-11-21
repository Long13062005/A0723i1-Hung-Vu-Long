package Intl;

import java.util.Scanner;
import java.util.Stack;

public class Nhiphan {
	

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		String a1 = null ;
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so thap phan : ");
		int number = sc.nextInt();
		while(true) {
			stack.push(number % 2); 
			if(number / 2 == 0) {
				break;
			}
			number = number / 2;
		}
		Stack<Integer> iu = new Stack<>();
		int a = stack.size();
		for (int i = 0; i < a; i++) {
			System.out.print(iu.push(stack.pop()));
        }
	}
}
