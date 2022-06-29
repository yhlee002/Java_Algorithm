package Algorithm.Section01;

import java.util.Scanner;

// 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
// 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축
public class Algorithm11 {
    private String solution(String str) {
        String answer = "";

        Character preChar = null;
        int cnt = 1;
        for (char c : str.toCharArray()) {
            if (preChar == null) {
                answer += c;
                preChar = c;
            }else {
                if (c == preChar) {
                    cnt++;
                } else {
                    if (cnt != 1) answer += cnt;
                    answer += c;

                    preChar = c;
                    cnt = 1;
                }
            }
        }

        if (cnt != 1) answer += cnt;
        return answer;
    }

    public static void main(String[] args) {
        Algorithm11 al = new Algorithm11();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(al.solution(str));
    }
}
