package Intl;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Stack;
public class TestInt {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Nhap n phan tu vao stack : ");
			int n = sc.nextInt();
			Stack<Integer> in = new Stack<>();
			for(int i = 0; i < n;i++) {
				System.out.print("Nhap so nguyen vao phan tu thu " + (i+1) + " : ");
				int so = sc.nextInt();
				in.push(so);
			}
			System.out.println(in);
			Stack<Integer> iu = new Stack<>();
			int a = in.size();
			for (int i = 0; i < a; i++) {
	            iu.push(in.pop());
	        }
			System.out.println(iu);
		}
	}


