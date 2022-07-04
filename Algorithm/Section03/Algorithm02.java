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

        boolean[] result = new boolean[1000000001];
        for (int i = 0; i < a.length; i++) {
            if (result[a[i]]) continue;

            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    result[a[i]] = true;
                    answer.add(a[i]);
                    break;
                }
            }
        }

        Collections.sort(answer, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : o1 < o2 ? -1 : 0;
            }
        });

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

        List<Integer> result = al.solution(a, b);
        for (int i : result) System.out.print(i + " ");
    }
}
