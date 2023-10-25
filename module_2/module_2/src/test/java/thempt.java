import java.util.Scanner;

public class thempt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so phan tu : ");
        int number = sc.nextInt();
        int[] a = new int[number];
        for (int i = 0; i < number; i++) {
            System.out.print("Nhap phan tu thu " + i + " : ");
            a[i] = sc.nextInt();
        }
        for (int element : a) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.print("Nhập số cần chèn (X): ");
        int X = sc.nextInt();
        System.out.print("Nhập vị trí (index) cần chèn X vào trong mảng: ");
        int index = sc.nextInt();
        if (index < 0 || index > a.length - 1) {
            System.out.println("Không chèn được phần tử vào mảng. Vị trí không hợp lệ.");
        } else {
            int[] newArray = new int[a.length + 1];
            for (int i = 0; i < index; i++) {
                newArray[i] = a[i];
            }
            newArray[index] = X;
            for (int i = index + 1; i < newArray.length; i++) {
                newArray[i] = a[i - 1];
            }

            a = newArray;
        }
        for (int element : a) {
            System.out.print(element + " ");
        }
    }
}
