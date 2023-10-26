import java.util.Scanner;

public class tong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Kich thuoc hang mang  : ");
        int n1 = sc.nextInt();
        System.out.print("Kich thuoc cot mang : ");
        int n2 = sc.nextInt();
        int[][] arr = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                System.out.print("Nhập phần tử ở hàng " + (i + 1) + " cột " + (j + 1) + " : ");
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Mảng vừa nhập:");
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        int choice;
        do {
            System.out.print("Chọn cột bạn muốn tính tổng: ");
            choice = sc.nextInt();
            int sum = 0;
            if (choice < 0 || choice >= n2) {
                System.out.println("Không hợp lệ. Vui lòng chọn lại.");
            } else {
                for (int i = 0; i < n1; i++) {
                    sum += arr[i][choice];
                }
                System.out.println("Tổng của cột " + choice + " là: " + sum);
            }
        } while (choice < 0 || choice >= n2);
    }
}
