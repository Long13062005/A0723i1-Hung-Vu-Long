package String;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class binarySearch {
	public static int binarySearch(int[] arr,int number,int left,int right) {
		while(right >= left) {
			int middle = (left + right) /2;

			if(arr[middle] == number) {
				return middle;
			} else if (number > arr[middle]) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap kich thuoc cua mang : ");
		int size = sc.nextInt();
		int[] randomArr = new int[size];
		Random random = new Random();
		   for (int i = 0; i < size; i++) {
	            randomArr[i] = random.nextInt(100); // Generates random in
	        }
		   Arrays.sort(randomArr);
			 System.out.println("Random Array: " + Arrays.toString(randomArr));
			 System.out.println("Chon value muon tim : ");
			 int number = sc.nextInt();
			 System.out.println("Chi so cua value la : " + binarySearch(randomArr, number,0, randomArr.length - 1));
			 
	}

}
