package Algorithm.Section02;

/*
    (6학년) 임시 반장 정하기
    첫 줄에는 학생들의 수 입력
    다음 줄에는 N명의 학생들이 각 학년(1 ~ 5)에 몇 반이었는지 입력
    '한 번이라도' 같은 반이었던 친구가 가장 많은 친구가 임시 반장으로 출력
    임시 반장이 될 수 있는 학생이 여러 명인 경우에는 가장 작은 번호의 학생 출력
 */

import java.util.Scanner;

public class Algorithm11 {
    private int solution(int n, int[][] grid) {
        int answer = 1;

        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int[] checked = new int[n];
            for (int j = 0; j < 5; j++) {
                for (int l = 0; l < n; l++) {
                    if (l != i && grid[i][j] == grid[l][j]) { // l != i 조건이 없어도 무관
                        if (checked[l] == 0) {
                            sum++;
                            checked[l] = 1;
                        }
                    }
                }
            }

            if (sum > max) {
                answer = i + 1;
                max = sum;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Algorithm11 al = new Algorithm11();
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.nextLine();

        int[][] grid = new int[num][5];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = sc.nextInt();
            }
//            sc.nextLine();
        }
        System.out.println(al.solution(num, grid));
    }
}
