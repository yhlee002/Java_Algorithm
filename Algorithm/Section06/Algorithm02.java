package Algorithm.Section06;

import java.util.Scanner;

/*
    버블정렬(오름차순)
 */
public class Algorithm02 {
    private int[] solution(int n, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) { // 버블 정렬은 n번의 회차를 실행할 때마다 맨 뒤에서 n개 인덱스의 값 정렬
                if (arr[j] > arr[j + 1]) change(arr, j, j + 1);
            }
        }

        return arr;
    }

    private void change(int[] arr, int x, int z) {
        int tmp = arr[x];
        arr[x] = arr[z];
        arr[z] = tmp;
    }

    public static void main(String[] args) {
        Algorithm02 al = new Algorithm02();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        for (int x : al.solution(n, arr)) System.out.print(x + " ");
    }
}