package ITEnterpriseExamples.Simulation;

import java.util.*;
/**
 * 사다리 타기
 */
public class LaddarGame {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution1(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(solution1(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(solution1(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(solution1(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));

        System.out.println(Arrays.toString(solution2(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(solution2(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(solution2(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(solution2(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }

    // 각 학생들이 독립적으로 순서대로 사다리를 타는 경우
    private static char[] solution1(int n, int[][] ladder) {
        char[] answer = new char[n];
        int num = (int) 'A';

        // 1부터 n까지 모든 자리에서 출발
        for (int i = 1; i <= n; i++) {
            int current = i;
            int j = 0;
            while (j < ladder.length) {
                for (int l = 0; l < ladder[j].length; l++) {
                    if (ladder[j][l] == current) {
                        current += 1;
                        break;
                    } else if (ladder[j][l] == current - 1) {
                        current -= 1;
                    }
                }
                j++;
            }

            answer[current - 1] = (char) (num + i - 1);
        }

        return answer;
    }

    // 동시에 타는 경우
    private static char[] solution2(int n, int[][] ladder) {
        char[] answer = new char[n];
        int num = (int) 'A';

        // 알파벳 설정
        for (int i = 0; i < n; i++) {
            answer[i] = (char)(num + i);
        }

        // 사다리 타기 과정을 통해 위치 변경
        for (int[] line : ladder) {
            for (int k : line) {
                char tmp = answer[k];
                answer[k] = answer[k - 1];
                answer[k - 1] = tmp;
            }
        }
        return answer;
    }
}
