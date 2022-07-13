package Algorithm.Section06;

import java.util.Scanner;

/*
    이분검색
    임의의 N개의 숫자와 N개의 수 중 한 개의 수인 M이 주어지면 오름차순으로 정렬한 다음
    이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 출력 (단 중복값은 존재하지 않음)

    첫 줄에 자연수 N(3<=N<=1,000,000)과 M 입력
    다음 줄에 N개의 자연수 입력
 */
public class Algorithm08 {
    private int solution(int n, int m, int[] list) {
        int j;

        // 삽입 정렬 사용
        for (int i = 1; i < n; i++) {
            int tmp = list[i];
            for (j = i - 1; j >= 0; j--) {
                if (list[j] > tmp) list[j + 1] = list[j];
                else break; // 해주어야 불필요한 루프 실행과 j-- 안됨
            }
            list[j + 1] = tmp;
        }

        int lt = 0, rt = n - 1;
        while (true) {
            int mid = (lt + rt) / 2;
            if (list[mid] < m) lt = mid + 1;
            else if (list[mid] > m) rt = mid - 1;
            else return mid + 1; // 인덱스가 아닌 몇 번째인지 출력
        }
    }

    public static void main(String[] args) {
        Algorithm08 al = new Algorithm08();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) list[i] = sc.nextInt();

        System.out.println(al.solution(n, m, list));
    }
}
