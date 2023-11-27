package String;

import java.util.LinkedList;
import java.util.Scanner;

public class maxString {
	static Scanner sc = new Scanner(System.in);
	public static void maxChuoi(String string) {
		LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) { 		//1 Vòng lặp
            if (list.size() > 1 && string.charAt(i) <= list.getLast() &&
                    list.contains(string.charAt(i))) {
                list.clear(); //1 câu lệnh
            }

            list.add(string.charAt(i)); // 1 câu lệnh

            if (list.size() > max.size()) { // 1 câu lệnh
                max.clear();
                max.addAll(list);
            }
        }

        // Hiển thị chuỗi liên tiếp dài nhất
        for (Character ch: max) { // 1 vòng lặp
            System.out.print(ch); // 1 câu lệnh
        }
        System.out.println();

	}
	public static void main(String[] args) {
		System.out.print("Nhập chuỗi: ");
        String string = sc.nextLine();
        maxChuoi(string);
	}
}
