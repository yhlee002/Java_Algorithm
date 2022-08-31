package Algorithm.Section10;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 최대점수 구하기(냅색 알고리즘)
public class Algorithm06 {
    static int n;
    static int m;
    static int[] result;
    static Problem[] list;

    static class Problem implements Comparable<Problem> {
        int score;
        int time;

        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }

        @Override
        public int compareTo(Problem p) {
            return this.time - p.time;
        }
    }

    public void solution() {
        // 각 문제는 한번밖에 풀 수 없는 점에 유의할 것 💫
        result[0] = 0;
        for (int i = 0; i < list.length; i++) {
            for (int j = m; j >= list[i].time; j--) {
                result[j] = Math.max(result[j], result[j - list[i].time] + list[i].score);
            }
        }
    }

    public static void main(String[] args) {
        Algorithm06 main = new Algorithm06();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 문제 수
        m = sc.nextInt(); // 제한 시간
        result = new int[m + 1];
        list = new Problem[n];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            list[i] = new Problem(s, t);
        }
        Arrays.sort(list);
        Arrays.fill(result, 0);

        main.solution();
        System.out.println(result[m]);
    }
}
