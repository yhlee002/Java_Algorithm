package Algorithm.Section09;

import java.util.*;

// 다익스트라 알고리즘
// 1번 노드에서 n - 1개의 노드(2부터 시작)까지의 최단 거리 구하기
public class Algorithm05 {
    static int n;
    static int m;
    static List<ArrayList<Edge>> list = new ArrayList<ArrayList<Edge>>();
    static int[] dist;

    static class Edge implements Comparable<Edge> {
        int vertex; // 꼭짓점
        int cost; // 가중치(비용)

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        public int compareTo(Edge e) {
            return this.cost - e.cost; // 가중치가 적은 것을 먼저 poll 하도록 함
        }
    }

    void solution() {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(1, 0)); // 1번 노드에서 시작
        dist[1] = 0;
        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            int curr = e.vertex;
            int currCost = e.cost;

            if (currCost > dist[curr]) continue; // 이미 메모이라이즈한 값보다 클 경우에는 굳이 할 필요가 없음.
            for (Edge obj : list.get(curr)) {
                if (dist[obj.vertex] > currCost + obj.cost) { // dist[i]가 Integer.MAX_VALUE일 때에는 currCost가 더 클 수 없음을 이용
                    dist[obj.vertex] = currCost + obj.cost; // 메모이라이즈한 값을 더 작은 값으로 대체
                    queue.offer(new Edge(obj.vertex, currCost + obj.cost)); // 다른 노드로의 이동에 사용할 수 있게 현재 노드와 현재까지의 가중치를 큐에 저장
                }
            }
        }
    }

    public static void main(String[] args) {
        Algorithm05 main = new Algorithm05();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // node size
        m = sc.nextInt(); // edge size
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE); // 최솟값으로 대체하기 위해 해당 배열의 모든 인덱스에 최댓값을 넣음
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>()); // node number와 index가 일치할 수 있게 0부터 넣음
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.get(a).add(new Edge(b, c));
        }

        main.solution();
        for (int i = 2; i <= n; i++) {
            if (dist[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dist[i]);
            else System.out.println(i + " : impossible");
        }
    }
}
