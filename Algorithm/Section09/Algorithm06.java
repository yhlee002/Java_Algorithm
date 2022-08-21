package Algorithm.Section09;

import java.util.Scanner;

// 친구인가? (Disjoint-Set; Union & Find)
public class Algorithm06 {
    /*
        cf. 만약 list의 인덱스 1, 2, 3의 값이 다음과 같다면,
            1은 2와 같은 집합이고 2는 3과 같은 집합이므로 결국 1, 2, 3 모두 같은 집합이다.
          1   2   3   4   5   6   7   8
        ---------------------------------
        | 2 | 3 | 3 |   |   |   |   |   |
        ---------------------------------
     */
    static int[] list;
    void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) list[fa] = fb;
    }

    int find(int x) {
        if (x == list[x]) return x; // '학생 넘버'와 '같은 집합인 학생 넘버'가 일치하는 경우
        else return find(list[x]);
    }

    public static void main(String[] args) {
        Algorithm06 main = new Algorithm06();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        list = new int[n + 1];
        for (int i = 1; i <= n; i++) list[i] = i;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            main.union(a, b);
        }

        int a = sc.nextInt();
        int b = sc.nextInt();
        int fa = main.find(a);
        int fb = main.find(b);
        if (fa != fb) System.out.println("NO");
        else System.out.println("YES");
    }
}
