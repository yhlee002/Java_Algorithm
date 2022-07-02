package Algorithm.Section01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// N개의 단어가 주어지면 각 단어를 뒤집어 출력
public class Algorithm04 {
    private List<String> solution(List<String> list) {
        List<String> answer = new ArrayList<>();

        for (String str : list) {
            /* 1) StringBuilder 사용
            String reverseStr = new StringBuilder(str).reverse().toString();
            answer.add(reverseStr);
            */

            // 2) 앞뒤를 전환(단어 양 끝단에서부터 순서대로 문자를 교환)
            char[] chars = str.toCharArray();
            int lt = 0, rt = str.length() - 1; // left, right

            while (lt <= rt) {
                char temp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = temp;
                lt++;
                rt--;
            }
            answer.add(String.valueOf(chars));

        }
        return answer;
    }
    public static void main(String[] args) {
        Algorithm04 al = new Algorithm04();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String str = sc.next();
            list.add(str);
        }

        List<String> result = al.solution(list);
        for (String s : result) System.out.println(s);
    }
}