package Algorithm.Section10;

import java.util.Arrays;
import java.util.Scanner;

public class Algorithm03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 1;
        int n = sc.nextInt();
        int[] list = new int[n];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) list[i] = sc.nextInt();
        Arrays.fill(result, 1);

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (list[j] < list[i]) {
                    int cnt = result[j] + 1;
                    if (result[i] < cnt) result[i] = cnt;
                    answer = Math.max(answer, cnt);
                }
            }
        }
        System.out.println(answer);
    }
}
