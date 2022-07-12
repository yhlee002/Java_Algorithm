package Algorithm.Section06;

import java.util.Scanner;

/*
    중복 확인
    선생님이 N명의 반 학생들에게 1부터 10,000,000까지의 자연수 중에서 각자가 좋아하는 숫자 하나 적어 내라고 할 때
    만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력
    N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력

    첫 번째 줄에 자연수 N(5<=N<=100,000) 입력
    다음 줄에 학생들이 적어 낸 N개의 자연수 입력
 */
public class Algorithm05 {
    private char solution(int n, int[] arr) {
        // 오름차순으로 정렬한 후 두 개의 인덱스씩 비교(for문)하여 같을 경우 'D'
        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] >= tmp) {
                if (arr[j] == tmp) return 'D';
                arr[j + 1] = arr[j--];
            }
            arr[j + 1] = tmp;
        }

        return 'U';
    }

    public static void main(String[] args) {
        Algorithm05 al = new Algorithm05();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(al.solution(n, arr));
    }
}
