package Algorithm.Section05;

import java.util.Scanner;
import java.util.Stack;

/*
    올바른 괄호
    괄호가 입력되었을 때 올바른 괄호면 "YES", 아니라면 "NO" 출력
    ex. (())()는 바르게 입력된 경우, ()))(()은 바르게 입력되지 않은 경우
 */
public class Algorithm01 {
    private String solution(String str) {
        // '('가 나오면 cnt++, ')'가 나오면 cnt--가 되어야 함
        // 주의할 점은, 최종 결과만 0이 되면 되는 것이 아니라 값은 0이하로 내려가면 안됨
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') stack.push(c);
            else {
                if (stack.isEmpty()) return "NO";
                else stack.pop();
            }
        }

        if (stack.isEmpty()) return "YES";
        return "NO";
    }

    public static void main(String[] args) {
        Algorithm01 al = new Algorithm01();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(al.solution(str));
    }
}
