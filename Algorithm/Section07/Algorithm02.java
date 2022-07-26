package Algorithm.Section07;

import java.util.Scanner;

// 이진수 출력(재귀)
public class Algorithm02 {
    static void printBinaryR(int n) {
        if (n > 0) {
            printBinaryR(n / 2);
            System.out.print(n % 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        printBinaryR(num);
    }
}
