package Algorithm.Section08;

import java.util.Scanner;

public class Algorithm03_1 {
    static int n;
    static int m;
    static int[] points;
    static int[] times;
    static int max;

    void getMaxSum(int L, int timeSum, int pointSum, int[] times, int[] points) {
        if (L <= n) {
            getMaxSum(L + 1, timeSum + times[L], pointSum + points[L], times, points);
            getMaxSum(L + 1, timeSum, pointSum, times, points);
        } else {
            if (timeSum <= m && max < pointSum) max = pointSum;
        }
    }

    public static void main(String[] args) {
        Algorithm03_1 main = new Algorithm03_1();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        times = new int[n + 1];
        points = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            points[i] = sc.nextInt();
            times[i] = sc.nextInt();
        }

        main.getMaxSum(0, 0, 0, times, points);
        System.out.println(max);
    }
}
