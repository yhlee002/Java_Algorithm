package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
// 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력
public class Algorithm05 {
    private String solution(String str) {
        String answer = "";
        String str2 = str.replaceAll("[^/A-Za-z/g]", "");
        int j = str2.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int bt = (byte) c;
            if (65 <= bt && bt <= 90 || bt >= 97 && bt < 122) {
                answer += str2.charAt(j--);
            } else {
                answer += str.substring(i, i + 1);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Algorithm05 al = new Algorithm05();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(al.solution(str));
    }
}
