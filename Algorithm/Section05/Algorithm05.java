package Algorithm.Section05;

import java.util.Scanner;
import java.util.Stack;

/*
    레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 ‘( ) ’ 으로 표현. 또한, 모든 ‘( ) ’는 반드시 레이저를 표현
    쇠막대기의 왼쪽 끝은 여는 괄호 ‘ ( ’ 로, 오른쪽 끝은 닫힌 괄호 ‘) ’ 로 표현
    쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때, 잘려진 쇠막대기 조각의 총 개수 출력
 */
public class Algorithm05 {
    private int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == ')') {
                stack.pop();
                if (c == str.charAt(i- 1)) {
                    answer++;
                } else {
                    answer += stack.size();
                }
            } else stack.push(c);
        }

        return answer;
    }

    public static void main(String args[]) {
        Algorithm05 al = new Algorithm05();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(al.solution(str));
    }

}
