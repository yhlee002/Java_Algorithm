package Algorithm.Section01;

import java.util.Scanner;

// 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력
// 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
public class Algorithm06 {
    private String solution(String str) {
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i + 1);
            if (str.indexOf(s) == i) {
                answer += str.substring(i, i + 1);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Algorithm06 al = new Algorithm06();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(al.solution(str));
    }
}
