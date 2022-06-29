package Algorithm.Section01;

import java.util.Scanner;

public class Algorithm07 {
    private String solution(String str) {
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
    }
    public static void main(String[] args) {
        Algorithm07 al = new Algorithm07();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(al.solution(str));
    }
}