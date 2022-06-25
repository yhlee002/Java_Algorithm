import java.util.Scanner;

// 문장에서 가장 긴 단어 출력(각 단어는 띄어쓰기를 통해 구분)
public class Algorithm03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();

        String[] inputArr = input1.split(" ");

        String longest = "";
        for (String str : inputArr) {
            if(str.length() > longest.length()) longest = str; // 같은 길이일 때는 변경되지 않음
        }

        System.out.println(longest);
    }
}
