package Day_00.ex02;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int coffeeCounter = 0, num = scanner.nextInt();
        while (num != 42) {
            if (num < 2) {
                System.err.println("Illegal Argument");
                System.exit(-1);
            }
            int sum = sumOfDigits(num);
            if (isPrimeNumber(sum)) {
                ++coffeeCounter;
            }
            num = scanner.nextInt();
        }
        System.out.println("Count of coffee-request - " + coffeeCounter);
    }

    private static boolean isPrimeNumber(int num) {
        if (num == 2) {
            return true;
        }
        if ((num % 2) == 0) {
            return false;
        }
        int count = sqrt(num);
        if (count != -1) {
            return false;
        }
        count = 0;
        for (int i = 3; i < num; i += 2) {
            if ((num % i) == 0) {
                return false;
            }
            ++count;
        }
        return true;
    }

    private static int sqrt(int num) {
        int count = 0;
        for (int i = 1; (i * i) < num; ++i) {
            if ((i * i) == num) {
                return ++count;
            }
            ++count;
        }
        return -1;
    }

    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
