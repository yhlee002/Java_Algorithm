package Algorithm.Section01;

import java.util.Scanner;

public class Algorithm08 {
    private String solution(String str) {
        str = str.replaceAll("[^/a-zA-Z/g]", "");

        int mid = str.length() / 2;
        String strA = "";
        String strB = "";
        if (str.length() % 2 == 0) {
            strA = str.substring(0, mid);
        } else {
            strA = str.substring(0, mid + 1);
        }

        for (int i = str.length() - 1; i >= mid; i--) {
            strB += str.charAt(i);
        }

        if (strA.toLowerCase().equals(strB.toLowerCase())) return "YES";
        else return "NO";
    }
    public static void main(String[] args) {
        Algorithm08 al = new Algorithm08();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(al.solution(str));
    }
}
