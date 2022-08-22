package Algorithm.Section09;

import java.util.*;

// 원더랜드(크루스칼, Union & Find)
public class Algorithm07 {
    static List<Edge> edges = new ArrayList<>();
    static int[] nodes; // 노드의 집합 결과
    static int sum = 0;

    static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return e.cost - this.cost;
        }
    }

    int find(int v) {
        if (v == nodes[v]) return v;
        else return find(nodes[v]);
    }

    void union(int v1, int v2, int cost) {
        int fv1 = find(v1);
        int fv2 = find(v2);
        if (fv1 != fv2) {
            nodes[fv1] = fv2;
            sum += cost;
        }
    }

    void solution() {
        for (Edge e : edges) {
            int v1 = e.v1;
            int v2 = e.v2;
            union(v1, v2, e.cost);
        }
    }

    public static void main(String[] args) {
        Algorithm07 main = new Algorithm07();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        nodes = new int[n + 1];
        for (int i = 1; i <= n; i++) nodes[i] = i;
        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge(v1, v2, cost));
        }
        Collections.sort(edges, Collections.reverseOrder());

        main.solution();
        System.out.println(sum);
    }
}