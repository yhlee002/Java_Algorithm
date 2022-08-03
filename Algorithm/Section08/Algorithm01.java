package Algorithm.Section08;

import java.util.Scanner;

// 합이 같은 부분집합(DFS : 아마존 인터뷰)
public class Algorithm01 {
    static String answer = "NO";
    static int n;
    static int[] list;

    static boolean[] selected;
    // 돌아가면서 해당 원소를 첫 배열에 넣을지(1) 말지(0)를 기록
    static void DFS(int idx) {
        if (idx <= n) {
            selected[idx] = true;
            DFS(idx + 1);

            selected[idx] = false;
            DFS(idx + 1);

        } else {
            int sum1 = 0, sum2 = 0;
            for (int i = 1; i < n + 1; i++) {
                if (selected[i]) sum1 += list[i];
                else sum2 += list[i];
            }

            if (sum1 == sum2) {
                answer = "YES";
                return;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new int[n + 1];
        selected = new boolean[11];
        for (int i = 1; i < n + 1; i++) list[i] = sc.nextInt();

        DFS(1);
        System.out.println(answer);
    }
}
