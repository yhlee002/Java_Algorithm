package Algorithm.Section03;

import java.util.Scanner;

/*
    양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력
 */
public class Algorithm05 {
    private int solution(int num) {
        int answer = 0;
        /* 첫 번째 방식(two-pointer 방식)
        int m = num/2 + 1;
        int[] arr = new int[m];
        for(int i = 0; i < arr.length; i++) arr[i] = i + 1;

        int lt = 0, sum = 0;
        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if (sum == num) answer++;
            while (sum > num) {
                sum -= arr[lt++];
                if (sum == num) answer++;
            }
        }
         */

        // 두 번째 방식(수학적 방식)
        int cnt = 1;
        num--; // 연속 1 번째 수에 1 부여
        while (num > 0) {
            cnt++; // 2, 3, 4, ... 부여(연속 m 번째 수)
            num = num - cnt; // 2, 3, 4, ... 개의 수로 나누어 떨어지는지 여부 확인
            if (num % cnt == 0) answer++;

        }

        return answer;
    }

    public static void main(String[] str) {
        Algorithm05 al = new Algorithm05();
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        System.out.println(al.solution(num));
    }
}
