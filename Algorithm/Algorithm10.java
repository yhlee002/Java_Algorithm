package Algorithm;

import java.util.Scanner;

// 계단 오르기
public class Algorithm10 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] result = new int[n + 1];
    result[1] = 1;
    result[2] = 2;
    for (int i = 3; i <= n; i++) {
      result[i] = result[i - 2] + result[i - 1];
    }

    System.out.println(result[n]);
  }
}
