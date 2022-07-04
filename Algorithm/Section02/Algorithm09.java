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

        int sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                sum1 += grid[i][j];
                sum2 += grid[j][i]; // i, j를 서로 바꾸면 열의 합을 구할 수 있음
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
            sum1 = sum2 = 0;
        }


        for (int i = 0; i < num; i++) {
            sum3 += grid[i][i];
            sum4 += grid[i][num - i - 1];
        }

        answer = Math.max(answer, sum3);
        answer = Math.max(answer, sum4);

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
