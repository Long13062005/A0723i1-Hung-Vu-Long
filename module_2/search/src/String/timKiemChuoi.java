package String;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class timKiemChuoi {
	public static void timKiemChuoi(String inputString) {
		 LinkedList<Character> max = new LinkedList<>();

	        // Tìm chuỗi tăng dần có độ dài lớn nhất
	        for (int i = 0; i < inputString.length(); i++) {
	            LinkedList<Character> list = new LinkedList<>();
	            list.add(inputString.charAt(i));
	            for (int j = i + 1; j < inputString.length(); j++) {
	                if (inputString.charAt(j) > list.getLast()) {
	                    list.add(inputString.charAt(j));
	                }
	            }
	            if (list.size() > max.size()) {
	                max.clear();
	                max.addAll(list);
	            }
	            list.clear();
	        }

	        // Hiển thị chuỗi tăng dần dài nhất
	        for (Character ch : max) {
	            System.out.print(ch);
	        }
	        System.out.println();
	        
	}
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Nhập vào một chuỗi: ");
	        String inputString = scanner.nextLine();
	        timKiemChuoi(inputString);
	       
	    }
}
