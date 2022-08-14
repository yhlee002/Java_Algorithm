package Algorithm.Section08;

import java.util.Scanner;

// 섬나라 아일랜드
public class Algorithm13 {
    static int n;
    static int[][] matrix;
    static boolean[][] checked;
    static int[] ym = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] xm = {0, 1, 1, 1, 0, -1, -1, -1};
    static int cnt= 0;

    void DFS() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!checked[i][j] && matrix[i][j] == 1) {
                    checked[i][j] = true;
                    DFS(i, j);
                    cnt++;
                }
            }
        }
    }

    void DFS(int y, int x) {
        for (int i = 0; i < 8; i++) {
            int my = y + ym[i];
            int mx = x + xm[i];
            if (my > 0 && mx > 0 && my <= n && mx <= n) {
                if (!checked[my][mx] && matrix[my][mx] == 1) {
                    checked[my][mx] = true;
                    DFS(my, mx);
                }
            }
        }
    }

    public static void main(String[] args) {
        Algorithm13 main = new Algorithm13();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n + 1][n + 1];
        checked = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                main.DFS();
            }
        }

        System.out.println(cnt);

//    main.BFS();
    }
}
