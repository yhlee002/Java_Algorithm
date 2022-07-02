package Algorithm.Section01;

import java.util.Scanner;

// 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
// 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력
public class Algorithm05 {
    private String solution(String str) {
        String answer;
        /*
        String str2 = str.replaceAll("[^/A-Za-z/g]", "");
        int j = str2.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int bt = (byte) c;
            if (65 <= bt && bt <= 90 || bt >= 97 && bt < 122) {
                answer += str2.charAt(j--);
            } else {
                answer += str.substring(i, i + 1);
            }
        }
         */

        char[] chars = str.toCharArray();
        int lt = 0, rt = chars.length - 1;
        while(lt <= rt) { // lt와 rt 모두 문자일 때만 두 인덱스가 같이 변경(아닐 경우 아닌 값의 인덱스만 변경)
            if (!Character.isAlphabetic(chars[lt])) lt++;
            else if (!Character.isAlphabetic(chars[rt])) rt--;
            else {
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(chars);

        return answer;
    }
    public static void main(String[] args) {
        Algorithm05 al = new Algorithm05();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(al.solution(str));
    }
}
