package Algorithm.Section07;

import java.util.Scanner;

// 재귀 함수
// 정수 N을 입력받아 1부터 N까지의 정수를 순서대로 출력
public class Algorithm01 {
    static void printR(int n) {
        if (n > 0) {
            printR(n - 1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printR(n);
    }
}
