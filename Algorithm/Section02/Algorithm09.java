package Algorithm.Section02;

import java.util.Scanner;

/*
    N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가장 큰 합을 출력
    첫 줄에는 자연수 N 입력
    다음 줄부터는 걸쳐 N개의 자연 수 입력(N번 반복)
 */
public class Algorithm09 {
    private int solution (int num, int[][] grid) {
        int answer = 0;

        // 행의 합 중 가장 큰 값 도출
        for (int i = 0; i < num; i++) {
            int sum = 0;
            for (int j = 0; j < num; j++) {
                sum += grid[i][j];
            }
            if (sum > answer) answer = sum;
        }

        // 열의 합 중 가장 큰 값 도출
        for (int i = 0; i < num; i++) {
            int sum = 0;
            for (int j = 0; j < num; j++) {
                sum += grid[j][i];
            }
            if (sum > answer) answer = sum;
        }

        // 대각선의 합 중 가장 큰 값 도출
        int diagonal = 0;
        for (int i = 0; i < num; i++) diagonal += grid[i][i];
        if (diagonal > answer) answer = diagonal;

        // 역대각선의 합 중 가장 큰 값 도출
        int revDiagonal = 0;
        for (int i = num - 1; i >= 0; i--) revDiagonal += grid[i][i];
        if (revDiagonal > answer) answer = revDiagonal;

        return answer;
    }

    public static void main(String[] args) {
        Algorithm09 al = new Algorithm09();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();

        int[][] grid = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(al.solution(num, grid));
    }
}
