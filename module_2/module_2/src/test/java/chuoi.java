import java.util.Scanner;

public class chuoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Bước 1: Khai báo chuỗi và gán giá trị
        System.out.print("Nhập chuỗi: ");
        String str = sc.nextLine();

        // Bước 2: Khai báo một biến ký tự và gán hoặc nhập giá trị
        System.out.print("Nhập ký tự cần đếm: ");
        char targetChar = sc.next().charAt(0);

        // Bước 3: Khai báo biến count và gán giá trị 0
        int count = 0;

        // Bước 4: Sử dụng vòng lặp để đếm số lần ký tự xuất hiện trong chuỗi
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == targetChar) {
                count++;
            }
        }

        // Bước 5: In ra giá trị biến đếm
        System.out.println("Số lần ký tự '" + targetChar + "' xuất hiện trong chuỗi: " + count);

    }
}
