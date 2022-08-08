package Algorithm.Section08;

import java.util.Scanner;

public class Algorithm08 {
    static int n;
    static int f;
    static int[][] list;
    static int[] result;
    static boolean[] checked;
    static String answer = "";

    int getCombination(int v, int k) {
        if (list[v][k] == 0) {
            if (v == k || k == 0) list[v][k] = 1;
            else {
                list[v][k] = getCombination(v - 1, k - 1) + getCombination(v - 1, k);
            }
        }

        return list[v][k];
    }

    void DFS(int L, int sum) {
        if (L == n) {
            if (sum == f && answer.length() == 0) {
                for (int x : result) answer += x + " ";
            }
            return;
        }
        else {
            for (int i = 1; i <= n; i++) {
                if (!checked[i]) {
                    checked[i] = true;
                    result[L] = i;
                    DFS(L + 1, sum + i * getCombination(n - 1, L));
                    checked[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Algorithm08 main = new Algorithm08();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        list = new int[n + 1][n + 1];
        checked = new boolean[n + 1];
        result = new int[n];
        main.getCombination(n, n - 1);

        main.DFS(0, 0);
        System.out.println(answer);
    }
}