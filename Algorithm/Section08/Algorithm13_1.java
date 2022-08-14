package Algorithm.Section08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 섬나라 아일랜드(BFS 방식 풀이)
public class Algorithm13_1 {
    static int n;
    static int[][] matrix;
    static int[] ym = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] xm = {0, 1, 1, 1, 0, -1, -1, -1};
    static int cnt= 0;
    static class Node {
        int y;
        int x;

        public Node (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = 0;
                    BFS(i, j);
                    cnt++;
                }
            }
        }
    }

    void BFS(int row, int col) {
        Node root = new Node(row, col);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node r = q.poll();
            for (int i = 0; i < 8; i++) {
                int y = r.y + ym[i];
                int x = r.x + xm[i];
                if (y >= 0 && y < n && x >= 0 && x < n && matrix[y][x] == 1) {
                    matrix[y][x] = 0;
                    q.offer(new Node(y, x));
                }
            }
        }
    }

    public static void main(String[] args) {
        Algorithm13_1 main = new Algorithm13_1();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        main.solution();
        System.out.println(cnt);
    }
}
