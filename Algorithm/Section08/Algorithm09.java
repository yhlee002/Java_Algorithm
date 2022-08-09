package Algorithm.Section08;

import java.util.*;

public class Algorithm09 {
    static int n;
    static int m;
//    static boolean[] checked;
    static int[] result;
//    static Set<String> set;


    void DFS (int L, int start) {
        if (L == m) {
            for (int x : result) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = start; i <= n; i++) {
                result[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String args[]) {
        Algorithm09 main = new Algorithm09();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        result = new int[m];

        main.DFS(0, 1);

    }
}