package Algorithm.Section02;

import java.util.*;

public class Algorithm03 {
  private List<String> solution(int num, List<Integer> aList, List<Integer> bList) {
    List<String> answer = new ArrayList<>();
    for (int i = 0; i < num; i++) {
      if (aList.get(i) < bList.get(i)) {
        if (aList.get(i) == 1 && bList.get(i) == 3) answer.add("A");
        else answer.add("B");
      } else if (aList.get(i) > bList.get(i)) {
        if (aList.get(i) == 3 && bList.get(i) == 1)
          answer.add("B");
        else answer.add("A");
      } else {
        answer.add("D");
      }
    }

    return answer;
  }
  public static void main(String args[]) {
    Algorithm03 al = new Algorithm03();
    Scanner sc = new Scanner(System.in);
    int cnt = sc.nextInt();
    sc.nextLine();
    List<Integer> aList = new ArrayList<Integer>();
    List<Integer> bList = new ArrayList<Integer>();
    for (int i = 0; i < cnt; i++) {
      aList.add(sc.nextInt());
    }

    for (int i = 0; i < cnt; i++) {
      bList.add(sc.nextInt());
    }

    List<String> result = al.solution(cnt, aList, bList);
    for(int i = 0; i < cnt; i++) {
      System.out.println(result.get(i));
    }
  }
}