package Algorithm.Section05;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/*
    후위식 연산
    첫 줄에 후위연산식이 주어지면 그 결과를 출력
 */
public class Algorithm04 {
    private int solution(String str) {
        int answer = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) stack.push(Integer.parseInt(String.valueOf(c)));
            else { // operator
                int rt = stack.pop();
                int lt = stack.pop();

                if (c == '+') stack.push(lt + rt);
                else if (c == '-') stack.push(lt - rt);
                else if (c == '*') stack.push(lt * rt);
                else if (c == '/') stack.push(lt / rt);
            }
        }
        answer = stack.pop();

        return answer;
    }

    public static void main(String[] args) {
        Algorithm04 al = new Algorithm04();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println(al.solution(str));
    }
}
