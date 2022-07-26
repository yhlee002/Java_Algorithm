package Algorithm.Section07;

import java.util.Scanner;

// 팩토리얼(재귀)
public class Algorithm03 {
    static int recurse(int n) {
        if (n > 0) {
            return n * recurse(n - 1);
        } else return 1;

        /* 아래와 같이 풀 수도 있음
            if (n == 1) return 1;
            else return n * recurse(n - 1);
         */
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(recurse(num));;
    }
}
