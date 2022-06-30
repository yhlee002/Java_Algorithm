package Algorithm.Section02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력
    첫 줄에 자연수의 개수 N(3<=N<=100) 입력, 다음 줄에 N개의 자연수 입력
    첫 줄에 뒤집은 소수 출력(입력되었던 순서대로 출력)
 */
public class Algorithm06 {
  private List<Integer> solution(int num, List<Integer> list) {
    List<Integer> answer = new ArrayList<>();
    for (int i = 0; i < num; i++) {
      int orgVal = list.get(i);
      String valStr = "";
      int val = 0;

      char[] chars = String.valueOf(orgVal).toCharArray();

      for (int j = chars.length - 1; j >= 0 ; j--){
        valStr += chars[j];
      }

      val = Integer.parseInt(valStr);

      if (val > 1 && isPrime(val)) answer.add(val);
    }

    return answer;
  }

  private boolean isPrime(int val) {
    int[] arr = new int[val + 1];
    for (int i = 2; i <= val; i++) {
      if (arr[i] == 0) {
        for (int j = 2; j*i <= val; j++) arr[j*i] = 1;
      }
    }

    if (arr[val] == 0) return true;
    return false;
  }

  public static void main(String args[]) {
    Algorithm06 al = new Algorithm06();
    Scanner sc = new Scanner(System.in);
    int cnt = sc.nextInt();
    sc.nextLine();
    List<Integer> list = new ArrayList<Integer>();

    for (int i = 0; i < cnt; i++) {
      list.add(sc.nextInt());
    }

    List<Integer> result = al.solution(cnt, list);
    for (int i = 0; i < result.size(); i++) {
      System.out.print(result.get(i) + " ");
    }
  }
}
