package Algorithm.Section08;

import java.util.Scanner;

// 순열 구하기
public class Algorithm06 {
    static int n;
    static int m;
    static int[] list;
    static boolean[] checked;

    void DFS(int L, int[] result) {
        if (L == m) {
            for (int x : result) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (!checked[list[i]]) {
                    checked[list[i]] = true;
                    result[L] = list[i];
                    DFS(L + 1, result);
                    checked[list[i]] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Algorithm06 main = new Algorithm06();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        list = new int[n];
        for (int i = 0; i < n; i++) list[i] = sc.nextInt();
        checked = new boolean[11]; // 10 이하의 자연수
        int[] result = new int[m];

        main.DFS(0, result);
    }
}
