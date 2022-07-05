package Algorithm.Section03;

import java.util.*;
/*
    N일 동안의 매출 중 연속 K일 동안의 최대 매출액 출력
    첫 줄에 N(5 <= N <= 100000)일, K(2 <= k <= N)일 입력
    다음 줄에 N일 간의 일일 매출액 입력
 */
public class Algorithm03 {
    private int solution(int n, int k,  int[] arr) {
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) sum += arr[i];
        answer = sum;

        for (int i = k; i < n; i++) {
            sum = sum - arr[i - k] + arr[i];
            if (answer < sum) answer = sum;
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

        System.out.println(al.solution(n, k, arr));
    }
}