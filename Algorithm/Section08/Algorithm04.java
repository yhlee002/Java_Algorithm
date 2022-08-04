package Algorithm.Section08;

import java.util.*;

// 중복수열 구하기
// 1 ~ N번의 번호가 적힌 구슬이 존재할 때, 중복을 허용하여 M번 뽑아 일렬로 나열하는 모든 방을 출력
// 3 <= N <= 10, 2 <= M <= N
public class Algorithm04 {
    static int n;
    static int m;

    void DFS(int L, List<Integer> result) {
        if (L < m) {
            for (int i = 1; i <= n; i++) {
                result.add(i);
                DFS(L + 1, result);
                result.remove(result.size() - 1);
            }
        } else {
            for (int x : result) System.out.print(x + " ");
            System.out.println();
        }
    }

    void DFS2(int L, int[] result) {
        if (L < m) {
            for (int i = 1; i <= n; i++) {
                result[L] = i;
                DFS2(L + 1, result);
            }
        } else {
            for (int i = 0; i < m; i++) System.out.print(result[i] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Algorithm04 main = new Algorithm04();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
//        List<Integer> result = new ArrayList<>();
//        main.DFS(0, result);

        int[] result = new int[m];
        main.DFS2(0, result);
    }
}
