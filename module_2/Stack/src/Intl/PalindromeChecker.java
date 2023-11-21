package Intl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine(); 
        
        boolean isPalindrome = checkPalindrome(inputString);

        if (isPalindrome) {
            System.out.println(inputString + " là chuỗi Palindrome.");
        } else {
            System.out.println(inputString + " không là chuỗi Palindrome.");
        }
    }

    private static boolean checkPalindrome(String inputString) {
        Queue<Character> queue = new LinkedList<>();

        for (char ch : inputString.toCharArray()) {
            queue.add(ch);
        }

        while (!queue.isEmpty()) {
            if (queue.remove() != queue.poll()) {
                return false;
            }
        }

        return true;
    }
}

