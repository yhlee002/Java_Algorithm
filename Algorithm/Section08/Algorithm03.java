package Algorithm.Section08;

import java.util.Scanner;

// 최대 점수 구하기(DFS)
public class Algorithm03 {
    static int max;
    static int n; // 1 <= n <= 20
    static int m; // 10 <= m <= 300
    static int[] times;
    static int[] points;
    static boolean[] checked;

    static void getMaxSum(int idx) {
        if (idx <= n) {
            checked[idx] = true;
            getMaxSum(idx + 1);

            checked[idx] = false;
            getMaxSum(idx + 1);
        } else {
            int sum = 0;
            int result = 0;
            for (int i = 1; i < n + 1; i++ ) {
                if (checked[i]) {
                    sum += times[i];
                    result += points[i];
                }
            }

            if (sum <= m && result > max) max = result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        checked = new boolean[n + 1];
        times = new int[n + 1];
        points = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            points[i] = sc.nextInt();
            times[i] = sc.nextInt();
        }

        getMaxSum(1);
        System.out.println(max);
    }
}
