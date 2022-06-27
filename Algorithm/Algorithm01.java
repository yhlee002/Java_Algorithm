package Algorithm;

import java.util.Scanner;

// 해당 문자가 포함된 수 찾기
// 2022.06.27 Character.toLowerCase() 사용하는 방식으로 수정
public class Algorithm01 {
    private int solution(String str, char c) {
        int result = 0;
        for (char s : str.toCharArray()) {
            if (Character.toLowerCase(s) == Character.toLowerCase(c)) result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Algorithm01 al = new Algorithm01();

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);

        int answer = al.solution(str, c);
        System.out.println(answer);
    }
}
