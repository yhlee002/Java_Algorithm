package Algorithm;

import java.util.Scanner;

// 대소문자 변경
// 2022.06.27 Character.isLowerCase(), isUpperCase() 사용하는 방식으로 수정
public class Algorithm02 {
    private String solution(String str) {
        String result = "";
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) result += Character.toUpperCase(c);
            else result += Character.toLowerCase(c);
        }
        return result;
    }
    public static void main(String[] args) {
        Algorithm02 al = new Algorithm02();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(); // 띄어쓰기를 허용하지 않을 때는 next()로도 충분함

        String answer = al.solution(str);
        System.out.println(answer);
    }
}
