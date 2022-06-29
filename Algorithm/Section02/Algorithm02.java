package Algorithm.Section02;

import java.util.*;

public class Algorithm02 {
  private int solution(int num, List<Integer> list) {
    int answer = 1; // 첫 번째는 항상 보임
    int max = list.get(0);
    for (int i = 1; i < num; i++) {
      if (list.get(i) > max) {
        max = list.get(i);
        answer++;
      }
    }

    return answer;
  }
  public static void main(String args[]) {
    Algorithm02 al = new Algorithm02();
    Scanner sc = new Scanner(System.in);
    int cnt = sc.nextInt();
    sc.nextLine();
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < cnt; i++) {
      list.add(sc.nextInt());
    }
    System.out.println(al.solution(cnt, list));
  }
}