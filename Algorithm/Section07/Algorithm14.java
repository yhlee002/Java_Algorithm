package Algorithm.Section07;

import java.util.*;

// 그래프 최단거리(BFS)
public class Algorithm14 {
    static int n;
    static int m;
    static int[] result; // 1번 노드에서 해당 인덱스값의 노드로 가는 최소 간선수
    static boolean[] checked;
    static List<Integer>[] list;

    static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            int n = q.poll();

            for (int x : list[n]) {
                if (!checked[x]) {
                    checked[x] = true;
                    q.offer(x);
                    if (result[x] == 0) result[x] = result[n] + 1; // 최초 발견 시 부모 노드로의 최소 간선수 + 1
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 6
        m = sc.nextInt(); // 9
        result = new int[n + 1];
        checked = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
        }

        // 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 2번 정점부터 차례대로 출력
        checked[1] = true;
        result[1] = 0;
        BFS(1);

        for (int i = 2; i < n + 1; i++) System.out.println(i + " : " + result[i]);
    }
}
