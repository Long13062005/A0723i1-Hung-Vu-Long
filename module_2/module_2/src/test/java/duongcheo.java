import java.util.Scanner;

public class duongcheo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Kich thuoc hang,cot mang  : ");
        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Nhập phần tử ở hàng " + (i + 1) + " cột " + (j + 1) + " : ");
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Mảng vừa nhập:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j == n - 1 || i == j) {
                    sum += arr[i][j];
                }
            }
        }
        System.out.println(sum);
    }
}
