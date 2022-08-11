package Algorithm.Section08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Algorithm12 {
    static int n;
    static int m;
    static int[][] matrix;
    static int[] ym = {-1, 0, 1, 0};
    static int[] xm = {0, 1, 0, -1};
    static Queue<Node> q = new LinkedList<>();
    static int cnt = 0;
    static int checked = 0; // -1이거나 1인 토마토 (칸)

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    void BFS() {

        while (!q.isEmpty()) {
            if (checked == n * m) {
                return;
            } else {
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    Node r = q.poll();
                    for (int i = 0; i < 4; i++) {
                        int my = r.y + ym[i];
                        int mx = r.x + xm[i];
                        if (my > 0 && mx > 0 && my <= n && mx <= m) {
                            if (matrix[my][mx] == 0) {
                                matrix[my][mx] = 1;

                                checked++;
                                q.offer(new Node(my, mx));
                            }
                        }
                    }
                }
                cnt++;
            }
        }
        if (checked < n * m) cnt = -1;
    }
    public static void main(String[] args) {
        Algorithm12 main = new Algorithm12();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        matrix = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = sc.nextInt();
                if (matrix[i][j] == 1) {
                    q.offer(new Node(i, j));
                    checked++;
                } else if (matrix[i][j] == -1) checked++;
            }
        }

        main.BFS();
        System.out.println(cnt);
    }
}