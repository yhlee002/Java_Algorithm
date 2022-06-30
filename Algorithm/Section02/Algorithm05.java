package Algorithm.Section02;

import java.util.Scanner;

/*
    자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력(에라토스테네스 체)
 */
public class Algorithm05 {
    private int solution(int num) {
        int result = 0;
        int[] arr = new int[num + 1];
        for (int i = 2; i <= num; i++) {
            if (arr[i] == 0) {
                for (int j = 1; j * i <= num; j++) {
                    arr[j * i] = 1;
                }
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Algorithm05 al = new Algorithm05();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(al.solution(num));
    }
}
