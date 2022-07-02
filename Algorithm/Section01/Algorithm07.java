package Algorithm.Section01;

import java.util.Scanner;

public class Algorithm07 {
    private String solution(String str) {
        /*
        int mid = str.length() / 2;
        String strA = "";
        String strB = "";

        if(str.length() % 2 == 0) {
            strA = str.substring(0, mid).toLowerCase();
        } else {
            strA = str.substring(0, mid + 1).toLowerCase();
        }

        strB = "";
        for (int i = str.length() - 1; i >= mid;  i--) {
            strB += str.charAt(i);
        }

        if (strA.equals(strB.toLowerCase())) return "YES";
        else return "NO";
         */

        /* 양 끝단의 인덱스를 이용해 비교
        char[] chars = str.toUpperCase().toCharArray();
        int lt = 0, rt = chars.length - 1;
        while (lt <= rt) {
            if (chars[lt] != chars[rt]) return "NO";
            lt++;
            rt--;
        }
        return "YES";
        */

        /*
        str = str.toUpperCase();
        int len = str.length();
        for (int i = 0; i < len/2; i++) {
            int idx = len - 1 - i;
            if (str.charAt(i) != str.charAt(idx)) return "NO";
        }
        return "YES";
         */

        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(tmp)) return "YES";
        return "YES";
    }
    public static void main(String[] args) {
        Algorithm07 al = new Algorithm07();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(al.solution(str));
    }
}