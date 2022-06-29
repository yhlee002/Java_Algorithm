package Algorithm.Section01;

import java.util.Scanner;

// 문장에서 가장 긴 단어 출력(각 단어는 띄어쓰기를 통해 구분)
public class Algorithm03 {
    private String solution(String str) {
        String answer = "";
        String[] inputArr = str.split(" ");
        for (String s : inputArr) {
            if(s.length() > answer.length()) answer = s; // 같은 길이일 때는 변경되지 않음
        }

        return answer;
    }
    public static void main(String[] args) {
        Algorithm03 al = new Algorithm03();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(al.solution(input));
    }
}
