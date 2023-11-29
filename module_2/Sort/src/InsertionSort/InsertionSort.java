package InsertionSort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
	public static void insertionSort(int[] array) {
        int n = array.length;
        
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }
    }
	 public static void main(String[] args) {
	        int size = 10; // Specify the size of the array
	        int[] array = new int[size];
	        Random random = new Random();

	        for (int i = 0; i < size; i++) {
	            array[i] = random.nextInt(100); // Generates random integers between 0 (inclusive) and 100 (exclusive)
	        }
	        System.out.println("Random Array:");
	        System.out.println(Arrays.toString(array));
	        System.out.println("sau khi sap xep : ");
	        insertionSort(array);
	        System.out.println(Arrays.toString(array));
	        }
}
