package Algorithm;

import java.util.Scanner;

// 해당 문자열이 포함된 수 찾기
public class Algorithm01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.nextLine();
        String input2 = in.nextLine();

        int len = input2.length();
        int cnt = 0;
        for (int i = 0; i <= input1.length() - len; i++) {
            String s1 = input1.toLowerCase();
            String s2 = input2.toLowerCase();
            if (s1.substring(i, i + len).equals(s2)) cnt++;
        }

        System.out.println(cnt);
    }
}
