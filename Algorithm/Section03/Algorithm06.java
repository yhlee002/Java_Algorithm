package Algorithm.Section03;

import java.util.*;

/*
    0과 1로 구성된 길이가 N인 수열과 이 수열에서 0을 최대 k번 1로 변경할 수 있을 때,
    최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 출력

    만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
    1 1 0 0 1 1 0 1 1 0 1 1 0 1
    만들 수 있는 1이 연속된 연속부분수열은 '1 1 0 0 [1 1 1 1 1 1 1 1] 0 1'가 됨
 */
public class Algorithm06 {
    private int solution(int n, int k, int[] arr) {
        int answer = 0;

        int lt = 0, cnt = 0, max = 0, chg = 0;
        for (int rt = 0; rt < n; rt++) {
            if(arr[rt] == 1) {
                cnt++;
            } else {
                chg++;
                if (chg <= k) {
                    cnt++;
                } else {
                    if (answer < cnt) {
                        answer = cnt;
                    }

                    while(chg > k) {
                        cnt--;
                        lt++;
                        if (arr[lt] == 0) {
                            chg--;
                            lt++;
                        }
                    }

                    while(arr[lt] == 0) {
                        chg--;
                        cnt--;
                        lt++;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Algorithm06 al = new Algorithm06();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(al.solution(n, k, arr));
    }
}