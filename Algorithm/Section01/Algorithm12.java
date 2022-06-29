package Algorithm.Section01;

import java.util.Scanner;

// 암호 해독(#을 1로, *을 0으로 변환하여 얻는 이진수를 다시 문자로 변환)
// 입력 : 첫 줄에는 보낸 문자의 수, 다음 줄에는 문자 수의 일곱배에 해당하는 수의 '#'와 '*'로 이루어진 문자열 입력
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
        int cnt = sc.nextInt();
        sc.nextLine();
        String str = sc.next();

        System.out.println(al.solution(str));
    }
}
