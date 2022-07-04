package Algorithm.Section03;

import java.util.*;

/*
    두 배열의 공통 원소를 추출하여 오름차순으로 정렬하여 출력
    첫 줄에 A 집합의 크기 N 입력, 다음 줄에 A 집합의 원소 나열
    다음 줄에 B 집합의 크기 M 입력, 다음 줄에 B 집합의 원소 나열
*/
public class Algorithm02 {
    private List<Integer> solution(int[] a, int[] b) {
        List<Integer> answer = new ArrayList<>();

        int idx1 = 0, idx2 = 0;
        while (idx1 < a.length && idx2 < b.length) {
            if (a[idx1] < b[idx2]) idx1++;
            else if (a[idx1] > b[idx2]) idx2++;
            else {
                answer.add(a[idx1]);
                idx1++;
                idx2++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Algorithm02 al = new Algorithm02();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        List<Integer> result = al.solution(a, b);
        for (int i : result) System.out.print(i + " ");
    }
}
