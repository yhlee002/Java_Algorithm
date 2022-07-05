package Algorithm.Section03;

import java.util.Scanner;

public class Algorithm04 {
    private int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = 0, rt = 0;

        int sum = arr[0];
        while (lt <= rt && rt < n) {
            if (sum < m) {
                if (rt == n - 1) break;
                else sum += arr[++rt];
            }
            else if (sum > m) sum -= arr[lt++];
            else {
                answer++;
                if (rt == n - 1) break;
                else sum += arr[++rt];
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
