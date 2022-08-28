package Algorithm.Section10;

import java.util.Scanner;

public class Algorithm02 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] result = new int[n + 2];
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= n + 1; i++) {
            result[i] = result[i - 2] + result[i - 1];
        }

        System.out.println(result[n + 1]);

    }
}