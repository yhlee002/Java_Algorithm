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

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k - 1; i++) map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.size());

            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++;
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
        for (Integer m : al.solution(n, k, arr)) System.out.print(m + " ");
    }
}
