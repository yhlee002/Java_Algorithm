package Algorithm.Section08;

import java.util.Scanner;

public class Algorithm11 {
    static int[][] matrix = new int[8][8];
    static int[] ym = {-1, 0, 1, 0};
    static int[] xm = {0, 1, 0, -1};
    static boolean[][] checked = new boolean[8][8];
    static int cnt = 0;
    static int min = Integer.MAX_VALUE;

    void DFS(int y, int x) {
        if (x == 7 && y == 7) {
            if (min != -1) min = Math.min(min, cnt);
            else min = cnt;
        }
        else {
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                int my = y + ym[i];
                int mx = x + xm[i];
                if (my > 0 && my <= 7 && mx > 0 && mx <= 7) {
                    int val = matrix[my][mx];
                    if (val == 0) {
                        if (!checked[my][mx]) {
                            checked[my][mx] = true;
                            cnt++;
                            DFS(my, mx);
                            checked[my][mx] = false;
                            cnt--;

                            flag = true;
                        }
                    }

                }
            }

            if (!flag) min = min == Integer.MAX_VALUE ? -1 : min;
        }
    }

    public static void main(String[] args) {
        Algorithm11 main = new Algorithm11();
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        checked[1][1] = true;
        main.DFS(1, 1);
        System.out.println(min);
    }
}
