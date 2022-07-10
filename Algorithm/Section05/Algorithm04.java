package Algorithm.Section05;

import java.util.Arrays;
import java.util.Scanner;

/*
    후위식 연산
    첫 줄에 후위연산식이 주어지면 그 결과를 출력
 */
public class Algorithm04 {
    private int solution(String str) {
        int answer = Integer.MIN_VALUE;
        int idx = 0; // current stack pointer
        int[] stack = new int[100]; // stack maximum length is smaller than 100
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack[idx++] = Integer.parseInt(String.valueOf(c)); // push
            } else { // operator
                int rt = stack[--idx];
                stack[idx] = 0;
                int lt = stack[--idx];
                stack[idx] = 0;
                switch (c) {
                    case '+':
                        stack[idx++] = lt + rt;
                        break;
                    case '-':
                        stack[idx++] = lt - rt;
                        break;
                    case '*':
                        stack[idx++] = lt * rt;
                        break;
                    case '/':
                        stack[idx++] = lt / rt;
                        break;
                }
            }
        }
        answer = stack[idx - 1]; // pop

        return answer;
    }

    public static void main(String[] args) {
        Algorithm04 al = new Algorithm04();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println(al.solution(str));
    }
}
