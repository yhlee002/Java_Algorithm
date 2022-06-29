package Algorithm.Section01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// N개의 단어가 주어지면 각 단어를 뒤집어 출력
public class Algorithm04 {
    private List<String> solution(List<String> list) {
        List<String> answer = new ArrayList<>();

        for (String str : list) {
            char[] chars = str.toCharArray();
            int j = 0;
            String reverseChars = "";
            for (int i = chars.length - 1; i >= 0; i--) {
                reverseChars += chars[i];
            }
            answer.add(reverseChars);
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