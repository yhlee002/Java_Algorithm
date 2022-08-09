package Algorithm.Section08;

import java.util.*;

public class Algorithm09 {
    static int n;
    static int m;
    static boolean[] checked;
    static int[] result;
    static Set<String> set;


    void DFS (int L, int start) {
        if (L == m) {
            String str = "";
            int[] arr = Arrays.stream(result).sorted().toArray();
            for (int i = 0; i < m; i++) {
                str += arr[i] + " ";
            }
            if (!set.contains(str)) {
                set.add(str);
                System.out.println(str);
            }
        } else {
            for (int i = start; i <= n; i++) {
                if (!checked[i]) {
                    checked[i] = true;
                    result[L] = i;
                    DFS(L + 1, start);
                    checked[i] = false;
                }
            }
        }
    }

    public static void main(String args[]) {
        Algorithm09 main = new Algorithm09();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        result = new int[m];
        checked = new boolean[n + 1];
        set = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            main.DFS(0, i);
        }
    }
}