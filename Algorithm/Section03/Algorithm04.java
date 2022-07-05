package Algorithm.Section03;

import java.util.Scanner;

public class Algorithm04 {
    private int solution(int n, int m, int[] arr) {
        int answer = 0, lt = 0;
        int sum = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) answer++;
            while(sum > m) {
                sum -= arr[lt++];
                if (sum == m) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Algorithm04 al = new Algorithm04();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(al.solution(n, m, arr));
    }
}
