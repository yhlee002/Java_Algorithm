package Algorithm.Section09;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// 원더랜드(프림 알고리즘, Priority Queue)
public class Algorithm07_1 {
    static List<List<Edge>> list = new ArrayList<>();
    static boolean[] checked;
    static int sum = 0;

    static class Edge implements Comparable<Edge> {
        int vertex;
        int cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    void solution() {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(1, 0));

        while (!q.isEmpty()) {
            Edge e = q.poll();
            if (!checked[e.vertex]) {
                checked[e.vertex] = true;
                sum += e.cost;

                for (Edge t : list.get(e.vertex)) {
                    q.offer(t);
                }
            }
        }
    }

    public static void main(String[] args) {
        Algorithm07_1 main = new Algorithm07_1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        checked = new boolean[n + 1];
        for (int i = 0; i <= m; i++) list.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            list.get(a).add(new Edge(b, cost));
            list.get(b).add(new Edge(a, cost));
        }

        main.solution();
        System.out.println(sum);
    }
}
