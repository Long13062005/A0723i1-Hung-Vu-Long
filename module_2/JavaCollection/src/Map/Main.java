package Map;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	   public static void main(String[] args) {
	        String inputString;
	        Scanner sc = new Scanner(System.in);
	        inputString = sc.nextLine();

 	        Map<String, Integer> wordCountMap = new TreeMap<>();

 	        String[] words = inputString.split("\\s+");  
	        for (String word : words) {
 	            String cleanedWord = word.toLowerCase();  

 	            if (wordCountMap.containsKey(cleanedWord)) {
 	                int count = wordCountMap.get(cleanedWord);
	                wordCountMap.put(cleanedWord, count + 1);
	            } else {
 	                wordCountMap.put(cleanedWord, 1);
	            }
	        }

 	        System.out.println("Word Count Map:");
	        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue());
	        }
	    }
}
