package Algorithm.Section08;

import java.util.Scanner;

// 섬나라 아일랜드(DFS 방식 풀이)
public class Algorithm13 {
    static int n;
    static int[][] matrix;
    static int[] ym = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] xm = {0, 1, 1, 1, 0, -1, -1, -1};
    static int cnt= 0;

    void DFS() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = 0;
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
            if (my >= 0 && mx >= 0 && my < n && mx < n) {
                if (matrix[my][mx] == 1) {
                    matrix[my][mx] = 0;
                    DFS(my, mx);
                }
            }
        }
    }

    public static void main(String[] args) {
        Algorithm13 main = new Algorithm13();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        main.DFS();
        System.out.println(cnt);
    }
}
