package ITEnterpriseExamples.Simulation;

import java.util.Arrays;

/**
 * 청소
 */
public class Cleanup {

    public static void main(String[] args) {
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
//        System.out.println(Arrays.toString(solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        // System.out.println(Arrays.toString(solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
       System.out.println(Arrays.toString(solution(arr3, 25)));
    }

    public static int[] solution(int[][] board, int k) {
        int[] answer = new int[2]; // [0, 0]에서 시작
        int direction = 1; // top(0), right(1), bottom(2), left(3)

        int second = 0;
        while (second < k) {
            int[] next = new int[2];
            switch (direction) {
                case 0:
                    next[0] = answer[0] - 1; // 위로 이동
                    next[1] = answer[1];
                    break;
                case 1:
                    next[0] = answer[0];
                    next[1] = answer[1] + 1; // 오른쪽으로 이동
                    break;
                case 2:
                    next[0] = answer[0] + 1; // 아래로 이동
                    next[1] = answer[1];
                    break;
                case 3:
                    next[0] = answer[0];
                    next[1] = answer[1] - 1; // 왼쪽으로 이동
                    break;
            }

            if (next[0] < 0 || next[0] >= board.length
                    || next[1] < 0 || next[1] >= board[0].length
                    || board[next[0]][next[1]] == 1) {
                direction = direction < 3 ? direction + 1 : 0;
                System.out.println("[" + (second + 1) + "초] 방향 전환");
            } else {
                answer[0] = next[0];
                answer[1] = next[1];
                System.out.println("[" + (second + 1) + "초] 위치 이동(" + Arrays.toString(answer) + ")");
            }
            second++;
        }
        return answer;
    }
}
