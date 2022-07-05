package Algorithm.Section03;

import java.util.*;

public class Algorithm01 {
    private List<Integer> solution(int n, int m, int[] a, int[] b) {
        List<Integer> answer = new ArrayList<>();
        int idx1 = 0, idx2 = 0;
        while(idx1 < n && idx2 < m) {
            if (a[idx1] < b[idx2]) answer.add(a[idx1++]);
            else if (a[idx1] > b[idx2]) answer.add(b[idx2++]);
            else {
                answer.add(a[idx1++]);
                answer.add(b[idx2++]);
            }
        }
        while (idx1 < n) answer.add(a[idx1++]);
        while (idx2 < m) answer.add(b[idx2++]);

        return answer;
    }

    public static void main(String[] args) {
        Algorithm01 al = new Algorithm01();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = sc.nextInt();

        List<Integer> result = al.solution(n, m, a, b);
        for (int i = 0; i < n + m; i++) System.out.printf("%d ", result.get(i));
    }
}