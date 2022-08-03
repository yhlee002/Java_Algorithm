package Algorithm.Section08;

import java.util.Scanner;

// 합이 같은 부분집합(DFS : 아마존 인터뷰) 2
public class Algorithm01_1 {
    static String answer = "NO";
    static int n, total;
    static int[] list;

    void DFS(int L, int sum, int [] list) {
        if (L < n) {
            DFS(L + 1, sum + list[L], list);
            DFS(L + 1, sum, list);
        } else {
            if (sum * 2 == total) answer = "YES";
            return;
        }
    }

    public static void main(String[] args) {
        Algorithm01_1 main = new Algorithm01_1();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
            total += list[i];
        }

        main.DFS(0, 0, list);
        System.out.println(answer);
    }
}
