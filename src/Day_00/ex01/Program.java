package Day_00.ex01;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num < 2) {
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
        if (num == 2) {
            System.out.println("true 1");
            System.exit(0);
        }
        if ((num % 2) == 0) {
            System.out.println("false 1");
            System.exit(0);
        }
        int count = sqrt(num);
        if (count != -1) {
            System.out.println("false " + count);
            System.exit(0);
        }
        count = 0;
        for (int i = 3; i < num; i += 2) {
            if ((num % i) == 0) {
                System.out.println("false " + ++count);
                System.exit(0);
            }
            ++count;
        }
        System.out.println("true " + count);
        System.exit(0);
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
}
