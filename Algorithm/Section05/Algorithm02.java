package Algorithm.Section05;

import java.util.Scanner;
import java.util.Stack;

/*
    괄호문자제거
    입력된 문자열에서 소괄호('()') 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력
 */
public class Algorithm02 {
    private String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == ')') {
              while (!stack.isEmpty() && stack.pop() != '(');
            } else stack.push(c);
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
