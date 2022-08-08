package Algorithm.Section08;

import java.util.Scanner;

// 조합수(메모이제이션)
public class Algorithm07 {
    static int n;
    static int r;
    static int[][] result;

    int getCombinations(int v, int x) {
        if (v == x || x == 0) {
            result[v][x] = 1;
        } else {
            result[v][x] = getCombinations(v - 1, x - 1) + getCombinations(v - 1, x);
        }
        return result[v][x];
    }

    public static void main(String[] args) {
        Algorithm07 main = new Algorithm07();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();

        result = new int[n + 1][r + 1];
        System.out.println(main.getCombinations(n, r));
    }
}
