import java.util.Scanner;

public class gopmang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap kich thuoc mang 1 : ");
        int n1 = sc.nextInt();
        System.out.print("Nhap kich thuoc mang 2 : ");
        int n2 = sc.nextInt();
        int[] a3 = new int[n1 + n2];
        for (int i = 0; i < n1; i++) {
            System.out.print("Nhap phan tu thu " + i + " : ");
            a3[i] = sc.nextInt();
        }
        for (int i = n1; i < n1 + n2; i++) {
            System.out.print("Nhap phan tu thu " + i + " : ");
            a3[i] = sc.nextInt();
        }
        for (int element : a3) {
            System.out.print(element + " ");
        }

    }
}
