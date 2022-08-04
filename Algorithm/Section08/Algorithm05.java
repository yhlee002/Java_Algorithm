package Algorithm.Section08;

import java.util.*;

// 동전 교환
public class Algorithm05 {
    static int min;
    static int n;
    static int m;
    static int[] list;

    void DFS(int L, int sum, int[] result) {
        if (sum < m) {
            for (int i = 0; i < n; i++) {
                result[L] = list[i];
                DFS(L + 1, sum + list[i], result);
            }
        } else {
//            for (int i = 0; i < L; i++) System.out.print(result[i] + " ");
//            System.out.println();
            if (sum == m && min > L) min = L;
        }
    }

    public static void main(String[] args) {
        Algorithm05 main = new Algorithm05();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new int[n];
        for (int i = 0; i < n; i++) list[i] = sc.nextInt();
        m = sc.nextInt();

        min = Integer.MAX_VALUE;
        int[] result = new int[m]; // 동전 금액은 항상 자연수(1 이상)이므로
        main.DFS(0, 0, result);
        System.out.println(min);
    }
}
