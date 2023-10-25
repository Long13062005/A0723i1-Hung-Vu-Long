import java.util.Scanner;

public class xoamang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap kich thuoc : ");
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
        System.out.print("Nhập phần tử cần xoá (X): ");
        int X = sc.nextInt();

        int index_del = -1;
        for (int i = 0; i < number; i++) {
            if (a[i] == X) {
                index_del = i;
                break;
            }
        }

        if (index_del == -1) {
            System.out.println("Phần tử không xuất hiện trong mảng.");
        } else {
            for (int i = index_del; i < number - 1; i++) {
                a[i] = a[i + 1];
            }
            number--;

            System.out.println("Mảng sau khi xoá:");
            for (int i = 0; i < number; i++) {
                System.out.print(a[i] + " ");
            }
        }
    }
}
