package Algorithm.Section10;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Algorithm05 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Integer[] list = new Integer[n];
    int[] cnt = new int[n];
    for (int i = 0; i < n; i++) list[i] = sc.nextInt();
    int sum = sc.nextInt();

    Arrays.sort(list, Collections.reverseOrder());
    int temp = sum;
    for (int i = 0; i < n; i++) {
      cnt[i] = temp / list[i];
      temp = temp % list[i];
      if (temp == 0) break;
    }
    System.out.println(Arrays.stream(cnt).sum());
  }
}
