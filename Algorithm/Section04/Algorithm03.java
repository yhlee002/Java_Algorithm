package Algorithm.Section04;

import java.util.*;

/*
    N일 동안의 매출 기록을 보고 K일 동안의 매출액의 종류를 구간별로 출력
    첫 줄에 N과 K 입력
    다음 줄에 N일 동안의 매출 기록 입력
    각 구간의 매출액 종류(수)를 출력
 */
public class Algorithm03 {
    private List<Integer> solution(int n, int k, int[] arr) {
        List<Integer> answer = new ArrayList<>();

        Map<Integer, Integer> map = null;
        for (int i = 0; i <= n - k; i++) {
            int cnt = 0;
            map = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            }
            for (Integer m : map.keySet()) cnt++;
            answer.add(cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        Algorithm03 al = new Algorithm03();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        for (Integer m : al.solution(n, k, arr)) System.out.printf("%d ", m);
    }
}
