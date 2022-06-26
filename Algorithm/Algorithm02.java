package Algorithm;

import java.util.Scanner;

// 대소문자 변경
public class Algorithm02 {
    public static void main(String[] args) {
        // A : 65, a : 97
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((byte) chars[i] >= 97) chars[i] -= 32;
            else chars[i] += 32;
        }

        System.out.println(new String(chars));
    }
}
