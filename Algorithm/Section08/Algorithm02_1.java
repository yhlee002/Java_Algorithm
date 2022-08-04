package Algorithm.Section08;

import java.util.Scanner;

// 바둑이 승차(DFS)
public class Algorithm02_1 {
    static int c;
    static int n;
    static int[] list;
    static int max;

    void getMaxSum(int L, int sum, int[] list) {
        if (L <= n) {
            getMaxSum(L + 1, sum + list[L], list);
            getMaxSum(L + 1, sum, list);
        } else {
            if (sum > max && sum <= c) max = sum;
        }
    }

    public static void main(String[] args) {
        Algorithm02_1 main = new Algorithm02_1();
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt(); // 트럭에 실을 수 있는 최대 무게
        n = sc.nextInt(); // 바둑이 수

        list = new int[n + 1];
        for (int i = 1; i < n + 1; i++) list[i] = sc.nextInt(); // 바둑이들의 무게

        main.getMaxSum(0, 0, list);
        System.out.println(max);
    }
}
