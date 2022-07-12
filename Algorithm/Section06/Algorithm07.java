package Algorithm.Section06;

import java.util.Map;
import java.util.Scanner;

/*
    좌표 정렬
    N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬
    정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬

    첫 줄에 좌표의 개수인 N(3<=N<=100,000)이 입력
    다음 줄부터 N개의 좌표가 x, y 순으로 입력(x, y값은 양수)
    N개의 좌표를 정렬하여 출력
 */
public class Algorithm07 {
    private int[][] solution(int n, int[][] arr) {
        for (int i = 0; i < n; i++) {
            int[] tmp = arr[i];

            int j = i - 1;
            while (j >= 0 && (arr[j][0] > tmp[0] || (arr[j][0] == tmp[0] && arr[j][1] > tmp[1]))) arr[j + 1] = arr[j--];
            arr[j + 1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        Algorithm07 al = new Algorithm07();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int[] x : al.solution(n, arr)) {
            System.out.println(x[0] + " " + x[1]);
        }
    }
}
