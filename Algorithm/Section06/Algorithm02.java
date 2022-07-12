package Algorithm.Section06;

import java.util.Scanner;

/*
    버블정렬(오름차순)
 */
public class Algorithm02 {
    private int[] solution(int n, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
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