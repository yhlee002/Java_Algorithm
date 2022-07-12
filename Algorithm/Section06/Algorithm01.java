package Algorithm.Section06;

import java.util.Scanner;

/*
    선택정렬(오름차순)
 */

public class Algorithm01 {
    private int[] solution(int n, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIdx] > arr[j]) minIdx = j;
            }

            change(arr, i, minIdx);
        }

        return arr;
    }

    private void change(int[] arr, int x, int z) {
        int tmp = arr[x];
        arr[x] = arr[z];
        arr[z] = tmp;
    }

    public static void main(String[] args) {
        Algorithm01 al = new Algorithm01();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        for (int x : al.solution(n, arr)) System.out.print(x + " ");
    }
}