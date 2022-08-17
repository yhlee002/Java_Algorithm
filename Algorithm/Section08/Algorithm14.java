package Algorithm.Section08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Algorithm14 {
    static int n;
    static int m;
    static int[][] matrix;
    static List<Point> list;
    static List<Point> customers;
    static boolean[] checked;
    static int min = Integer.MAX_VALUE;

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    void DFS(int idx, int cnt) {
        if (cnt == m) {
            int total = 0;

            // 해당 피자집에 대한 집들의 거리
            for (int i = 0; i < customers.size(); i++) {
                int dist = Integer.MAX_VALUE; // 각 집의 피자배달거리
                for (int j = 0; j < list.size(); j++) {
                    if (checked[j]) {
                        int y = Math.abs(customers.get(i).y - list.get(j).y);
                        int x = Math.abs(customers.get(i).x - list.get(j).x);
                        dist = Math.min(dist, y + x);
                    }

                }
                total += dist;
            }

            min = Math.min(min, total);
        } else {
            if (idx + 1 < list.size()) {
                checked[idx] = true;
                DFS(idx + 1, cnt + 1);
                checked[idx] = false;
                DFS(idx + 1, cnt);
            }
        }
    }

    public static void main(String args[]) {
        Algorithm14 main = new Algorithm14();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        matrix = new int[n + 1][n + 1];
        list = new ArrayList<>();
        customers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = sc.nextInt();
                if (matrix[i][j] == 2) list.add(new Point(i, j));
                else if (matrix[i][j] == 1) customers.add(new Point(i, j));
            }
        }
        checked = new boolean[list.size()];
        main.DFS(0, 0);
        System.out.println(min);
    }

}