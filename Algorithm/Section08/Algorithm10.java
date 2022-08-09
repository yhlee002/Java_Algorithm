package Algorithm.Section08;

import java.util.Scanner;

public class Algorithm10 {
    static int[][] matrix = new int[8][8];
    static int[] ym = {-1, 0, 1, 0};
    static int[] xm = {0, 1, 0, -1};
    static boolean[][] checked = new boolean[8][8];
    static int cnt = 0;

    void DFS(int y, int x) {
        if (x == 7 && y == 7) cnt++;
        else {
            // 상하좌우 노드 살피기(값이 0인 경우 이동하는 재귀 함수 호출)
            // 왔던 노드가 아닌 이상 값이 0인 경우가 없는 경우에는 더이상 재귀 X
            for (int i = 0; i < 4; i++) {
                int my = y + ym[i];
                int mx = x + xm[i];
                if (my > 0 && my <= 7 && mx > 0 && mx <= 7) {
                    int val = matrix[my][mx];
                    if (val == 0) {
                        if (!checked[my][mx]) {
                            checked[my][mx] = true;
                            DFS(my, mx);
                            checked[my][mx] = false;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Algorithm10 main = new Algorithm10();
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        checked[1][1] = true;
        main.DFS(1, 1);
        System.out.println(cnt);
    }

}

