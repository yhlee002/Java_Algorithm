package Algorithm.Section10;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Algorithm05 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Integer[] list = new Integer[n];
    for (int i = 0; i < n; i++) list[i] = sc.nextInt();
    int total = sc.nextInt();
    int[] result = new int[total + 1];
    Arrays.fill(result, Integer.MAX_VALUE);
    result[0] = 0;

    for (int i = 0; i < n; i++) {
      for (int j = list[i]; j <= total; j++) {
        result[j] = Math.min(result[j], result[j - list[i]] + 1);
      }
    }
    System.out.println(result[total]);
  }
}
