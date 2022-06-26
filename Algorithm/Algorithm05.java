package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
// 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력
public class Algorithm05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            int bt = (byte) c;
            if (65 <= bt && bt < 129) {
                list.add(str.substring(i, i + 1));
            }
        }

        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int bt = (byte) c;
            if (65 <= bt && bt < 129) {
                System.out.print(list.get(j++));
            } else {
                System.out.print(str.substring(i, i + 1));
            }
        }
    }
}
