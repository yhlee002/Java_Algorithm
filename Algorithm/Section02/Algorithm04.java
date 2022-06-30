package Algorithm.Section02;

import java.util.*;

// 피보나치 수열
public class Algorithm04 {
    private List<Integer> solution(int num) {
        List<Integer> list = new ArrayList<>();
        int preVal = 1;
        int val = 1;
        list.add(preVal);
        list.add(val);
        while (list.size() < num) {
            int temp = val;
            val += preVal;
            preVal = temp;

            list.add(val);
        }

        return list;
    }
    public static void main(String args[]){
        Algorithm04 al = new Algorithm04();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int n : al.solution(num)) {
            System.out.print(n + " ");
        }

    }
}
