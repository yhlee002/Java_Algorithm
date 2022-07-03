package Algorithm.Section02;

import java.util.Scanner;

/*
     봉우리 개수 찾기
     첫 줄에 자연수 N 입력
     다음 줄에 N*N 격자판 입력
     격자의 가장자리는 0으로 초기화
 */
public class Algorithm10 {
    private int solution(int n, int[][] grid) {
        int answer = 0;
//        boolean[][] checked = new boolean[n][n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
//                if (checked[i][j]) {
//
//                }
                if (grid[i][j] > grid[i][j - 1] && grid[i][j] > grid[i][j + 1]) {
                    if (grid[i][j] > grid[i - 1][j] && grid[i][j] > grid[i + 1][j]) {
                        answer++;

//                        checked[i][j] = checked[i][j - 1] = checked[i][j + 1] = checked[i - 1][j] = checked[i + 1][j] = true;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String args[]) {
        Algorithm10 al = new Algorithm10();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();

        int[][] grid = new int[num + 2][num + 2];
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                grid[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        System.out.println(al.solution(num, grid));
    }
}
