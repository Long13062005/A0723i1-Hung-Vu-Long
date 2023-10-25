import java.util.Scanner;

public class max {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Kich thuoc hang mang  : ");
        int n1 = sc.nextInt();
        System.out.print("Kich thuoc cot mang : ");
        int n2 = sc.nextInt();
        float[][] arr = new float[n1][n2];
        for (int i = 0; i < n1; i++) {
            System.out.print("Nhap phan tu o hang " + (i + 1) + " o cot " + 0 + " : ");
            arr[i][1] = sc.nextFloat();
            for (int j = 0; j < n2; j++) {
                System.out.print("Nhap phan tu o hang " + (i + 1) + " o cot " + (j + 1) + " : ");
                arr[i][j] = sc.nextFloat();
            }
        }
        float max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        System.out.println("Phần tử lớn nhất trong mảng hai chiều là: " + max);

    }
}
