package Algorithm.Section08;

import java.util.*;

// 동전 교환
public class Algorithm05 {
    static int min;
    static int n;
    static int m;
    static int[] list;

    // recursive
    void DFSR(int L, int sum) {
        if (sum > m) return;
        if (L >= min) return;

        if (sum == m)  min = Math.min(min, L);
        else {
            for (int i = 0; i < n; i++) {
                DFSR(L + 1, sum + list[i]);
            }
        }
    }


    // stack에서 사용
    static class Result {
        int size; // 동전 개수
        int sum; // 합친 금액

        public Result(int size, int sum) {
            this.size = size;
            this.sum = sum;
        }
    }
    // stack
    int DFS() {
        int min = m;
        Stack<Result> stack = new Stack<>();
        stack.push(new Result(0, 0));
        while (!stack.isEmpty()) {
            Result r = stack.pop();

            if (r.size + 1 < min) {
                for (int i = 0; i < n; i++) {
                    int x = r.sum + list[i];
                    if (x == m) min = Math.min(r.size + 1, min);
                    else if (x < m) stack.push(new Result(r.size + 1, x));
                    else continue;
                }
            }
        }

        return min;
    }

    // level traversal
    void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        int L = 0;
        while (!q.isEmpty()) {
            if (L >= min) return;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int r = q.poll();
                if (r > m) continue;
                if (r == m) min = Math.min(L, min);
                for (int j = 0; j < n; j++) {
                    int x = r + list[j];
                    q.offer(x);
                }
            }
            L++;
        }
    }

    public static void main(String[] args) {
        Algorithm05 main = new Algorithm05();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new int[n];
        for (int i = n - 1; i >= 0; i--) list[i] = sc.nextInt();
        m = sc.nextInt();
        min = m; // recursive, level traversal에서 사용

        // recursive(DFS)
        main.DFSR(0, 0);
        System.out.println(min);
        // stack(DFS)
        System.out.println(main.DFS());
        // level traversal(BFS)
//        min = m;
//        main.BFS();
//        System.out.println(min);
    }
}
