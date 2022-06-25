import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// N개의 단어가 주어지면 각 단어를 뒤집어 출력
public class Algorithm04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String str = sc.nextLine();
            list.add(str);
        }

        for (String str : list) {
            char[] chars = str.toCharArray();
            char[] reverseChars = new char[chars.length];
            int j = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                reverseChars[j++] = chars[i];
            }
            String reverseStr = new String(reverseChars);
            System.out.println(reverseStr);
        }
    }
}
