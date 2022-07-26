package Algorithm.Section07;

import java.util.Scanner;

// 피보나치 재귀(메모이제이션)
// ex. 7 입력 시  '1 1 2 3 5 8 13' 출력
public class Algorithm04 {
    static int[] result;
    static int recurse(int n) {
        if (n == 1 || n == 2) return result[n] = 1;
        else return result[n] = recurse(n - 2) + recurse(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        result = new int[num + 1];
        recurse(num);
        for (int i = 1; i <= num; i++) System.out.print(result[i] + " ");
    }
}
