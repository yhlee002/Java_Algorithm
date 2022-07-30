package Algorithm.Section07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 송아지 찾기(최단거리 알고리즘)
public class Algorithm08 {
    int[] checked = new int[10001];
    int[] arr = {1, -1, 5};
    void findCalf(int s, int e) {
        // 1, -1, 5만큼 이동하는 경로 세 가지로 계속 트리 전개
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        checked[s] = 1;

        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int n = q.poll();

                for (int j = 0; j < 3; j++) {
                    int x = n + arr[j];
                    if (x >= 1 && x <= 10000 && checked[x] == 0) {
                        if (x == e) {
                            System.out.println(cnt + 1);
                            return;
                        }
                        if (n < e && x == -1) continue;
                        q.offer(x);
                    }
                }
            }
            cnt++;
        }
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        Algorithm08 tree = new Algorithm08();
        int s = sc.nextInt();
        int e = sc.nextInt(); // node 값이 아래 값이 되는 모든 경로 중에 가장 낮은 단계 출력

        tree.findCalf(s, e);
    }
}
