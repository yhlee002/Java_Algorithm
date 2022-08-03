package Algorithm.Section08;

import java.util.Scanner;

// 바둑이 승차(DFS)
public class Algorithm02 {
    static int max; // 부분집합의 합 중 최댓값
    static int c;
    static int n;
    static int[] list;
    static boolean[] selected;

    static void getMaxSum(int idx) {
        if (idx <= n) {
            selected[idx] = true;
            getMaxSum(idx + 1);

            selected[idx] = false;
            getMaxSum(idx + 1);
        } else {
            int sum = 0;
            for (int i = 1; i < n + 1; i++) {
                if (selected[i]) sum += list[i];
            }
            if (sum <= c && sum > max) max = sum;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt(); // 트럭에 실을 수 있는 최대 무게
        n = sc.nextInt(); // 바둑이 수

        selected = new boolean[n + 1];
        list = new int[n + 1];
        for (int i = 1; i < n + 1; i++) list[i] = sc.nextInt(); // 바둑이들의 무게

        getMaxSum(1);
        System.out.println(max);
    }
}
