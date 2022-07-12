package Algorithm.Section06;

import java.util.Scanner;

/*
    삽입정렬(오름차순)
 */
public class Algorithm03 {
    private int[] solution(int n, int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i], j;
            for (j = i - 1; j >= 0; j--) {
                if (tmp < arr[j]) arr[j + 1] = arr[j];
                else break;
            }
            arr[j + 1] = tmp;
        }

        return arr;
    }

    public static void main(String[] args) {
        Algorithm03 al = new Algorithm03();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        for (int x : al.solution(n, arr)) System.out.print(x + " ");
    }
}