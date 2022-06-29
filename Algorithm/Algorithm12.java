package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 암호 해독(#을 1로, *을 0으로 변환하여 얻는 이진수를 다시 문자로 변환)
public class Algorithm12 {
    private String solution(String str) {
        String answer = "";
        for (int i = 0; i < str.length(); i += 7){
            String s = str.substring(i, i + 7);
            s = s.replace("#", "1").replace("*", "0");
            int num = Integer.parseInt(s, 2);
            char c = (char) num;
            answer += c;
        }

        return answer;
    }

    public static void main(String[] args) {
        Algorithm12 al = new Algorithm12();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(al.solution(str));
    }
}
