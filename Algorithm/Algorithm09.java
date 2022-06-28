package Algorithm;

import java.util.Scanner;

// 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수 생성
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