package Algorithm.Section05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    인형 뽑기
    첫 줄에 자연수 N(5<=N<=30) 입력
    두 번째 줄부터 N*N board 배열 입력
    board의 각 칸에는 0 이상 100 이하인 정수가 존재
    0은 빈 칸을 의미
    1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미
    board배열이 끝난 다음줄에 크레인을 동작시킨  moves 배열의 길이 M 입력
    터트려서 사라진 인형의 수 출력
 */
public class Algorithm03 {
    private int solution(int n, int[][] board, int k, int[] moves) {
        int answer = 0;
        List<Integer> stack = new ArrayList<>();
        for (int i  = 0; i < k; i++) {
            int num = moves[i];
            // Map으로 각 열에 대한 가장 위에 있는 요소의 위치(행)을 가지면 어떨까
            int idx = 0;
            while(idx < n - 1 && board[idx][num - 1] <= 0) idx++;
            if (idx < n) {
                int pickNum = board[idx][num - 1];
                board[idx][num - 1] = 0; // 제거된 인형 자리에 0 입력
                stack.add(pickNum);
                int lastItemIdx = stack.size() - 1; // 꺼낸 목록에 넣기
                if (stack.size() > 1 && stack.get(lastItemIdx) == stack.get(lastItemIdx - 1)) {
                    stack.remove(lastItemIdx);
                    stack.remove(lastItemIdx - 1);
                    answer += 2;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Algorithm03 al = new Algorithm03();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int k = sc.nextInt();
        int[] moves = new int[k];
        for (int i = 0; i < k; i++) moves[i] = sc.nextInt();

        System.out.println(al.solution(n, grid, k, moves));
    }
}
