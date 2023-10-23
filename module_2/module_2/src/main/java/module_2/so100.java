package module_2;

public class so100 {
    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int number = 2;

        System.out.println("20 số nguyên tố đầu tiên là:");
        while (number < 100) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
            number++;
        }
    }
}
