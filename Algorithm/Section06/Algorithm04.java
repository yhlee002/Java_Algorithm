package Algorithm.Section06;

import java.util.Scanner;

/*
    LRU (=Least Recently Used)
    캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 N개의 작업을 처리한 후
    캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력
    첫 줄에 캐시의 크기인 S(3<=S<=10)와 작업의 개수 N(5<=N<=1,000)이 입력
    다음 줄에 N개의 작업번호가 처리순으로 입력(작업번호는 1 ~ 100)
 */
public class Algorithm04 {
    private int[] solution(int s, int n, int[] list) {
        int[] answer = new int[s];
//        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int task = list[i];

            boolean flag = true;
            int sameIdx = 0;
            for (int j = 0; j < answer.length; j++) {
                if (task == answer[j]) {
                    flag = false;
                    sameIdx = j;
                    break;
                }
            }

            if (flag) {
                // 가장 오래된 데이터 제거(poll) 후 한 인덱스씩 미루기
                for (int j = answer.length - 1; j >= 1; j--) {
                    answer[j] = answer[j - 1];
                }
            } else {
                for (int j = sameIdx; j >= 1; j--) {
                    answer[j] = answer[j - 1];
                }
            }
            answer[0] = task;
        }
        return answer;
    }

    public static void main(String[] args) {
        Algorithm04 al = new Algorithm04();
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        for (int x : al.solution(s, n, arr)) System.out.print(x + " ");
    }
}
