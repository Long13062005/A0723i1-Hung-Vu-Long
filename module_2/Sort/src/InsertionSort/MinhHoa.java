package InsertionSort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class MinhHoa {
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
	         // Specify the size of the array
	        int[] array = {1,8,66,44,5,53,2,4};
	        
	        System.out.println(Arrays.toString(array));
	        System.out.println("sau khi sap xep : ");
	        insertionSort(array);
	        System.out.println(Arrays.toString(array));
	        }
}
