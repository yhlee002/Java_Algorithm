package Algorithm;

import java.util.Scanner;

public class Algorithm09 {
  private int solution(String str) {
    String answer = "";
    answer = str.replaceAll("[^0-9]", "");

    return Integer.parseInt(answer);
  }

  public static void main(String[] args) {
    Algorithm09 al = new Algorithm09();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();

    System.out.println(al.solution(str));
  }
}
