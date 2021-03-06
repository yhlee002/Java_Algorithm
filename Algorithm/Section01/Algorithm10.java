package Algorithm.Section01;

import java.util.Scanner;

/*
    한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력
 */
public class Algorithm10 {
    private String solution(String str, char c){
        String answer = "";
        for (int k = 0; k < str.length(); k++){
            int min = 0;
            char s = str.charAt(k);

            if (s == c){
                min = 0;
            } else {
                int cnt = 0;
                for (int i = k + 1; i < str.length(); i++) {
                    ++cnt;
                    if (str.charAt(i) == c){
                        min = cnt;
                        break;
                    }
                }
                cnt = 0;
                for (int i = k - 1; i >= 0; i--){
                    ++cnt;
                    if (str.charAt(i) == c) {
                        if (min == 0 || min > cnt) {
                            min = cnt;
                        }
                    }
                }
            }
            answer += min + " ";
        }
        answer = answer.substring(0, answer.length());

        return answer;
    }
    public static void main(String args[]){
        Algorithm10 main = new Algorithm10();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);

        System.out.println(main.solution(str, c));
    }
}
