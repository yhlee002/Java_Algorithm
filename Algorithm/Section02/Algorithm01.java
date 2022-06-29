package Algorithm.Section02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력(첫 번째 수는 무조건 출력한다)
public class Algorithm01 {
    private String solution(int n, List<Integer> nums) {
        String answer = "";
        answer += nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) answer += " " + nums.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Algorithm01 al = new Algorithm01();
        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        int cnt = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < cnt; i++) list.add(sc.nextInt());

        System.out.println(al.solution(cnt, list));
    }
}
