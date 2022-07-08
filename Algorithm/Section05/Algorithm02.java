package Algorithm.Section05;

import java.util.Scanner;

/*
    괄호문자제거
    입력된 문자열에서 소괄호('()') 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력

 */
public class Algorithm02 {
    private String solution(String str) {
        // '('가 나오면 cnt++, ')'가 나오면 cnt--가 되어야 함
        // cnt가 0 보다 클 때 값은 추가되지 않음
        String answer = "";
        int cnt = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') cnt++;
            else if (c == ')') cnt--;

            if (cnt == 0 && c != ')' && c != '(') answer += c;
        }

        return answer;
    }

    public static void main(String[] args) {
        Algorithm02 al = new Algorithm02();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(al.solution(str));
    }
}
