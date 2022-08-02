package Algorithm.Section07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 경로 탐색(인접 행렬) - 첫 번째 정점에서 마지막 정점으로 가는 모든 경로의 수 구하기
// 추가적으로 경로 출력까지 수행
public class Algorithm13 {
    static int cnt;
    static int n;
    static int m;
    static List<Integer>[] list;
    static List<Integer> result;

    static boolean[] checked;
    static void retrieve(int node) {
        if (node == n) {
            cnt++;
            for (int x : result) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = 0; i < list[node].size(); i++) {
                int num = list[node].get(i);
                if (!checked[num]) {
                    checked[num] = true;
                    result.add(num);
                    retrieve(num);
                    checked[num] = false;
                    result.remove(result.size() - 1);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cnt = 0;
        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList[n + 1];
        checked = new boolean[n + 1];
        result = new ArrayList<>();
        for (int i = 1; i <= n; i++) list[i] = new ArrayList();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
        }

        checked[1] = true;
        result.add(1);
        retrieve(1);
        System.out.println(cnt);
    }
}
