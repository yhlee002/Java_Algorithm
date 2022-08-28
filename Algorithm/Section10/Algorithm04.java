package Algorithm.Section10;

import java.util.*;

// 가장 높은 탑 쌓기(LIS 응용)
public class Algorithm04 {
    static class Brick implements Comparable<Brick> {
        int baseArea;
        int height;
        int weight;

        public Brick(int baseArea, int height, int weight) {
            this.baseArea = baseArea;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick o) {
            return o.baseArea - this.baseArea; // 첫 번째 인덱스가 가장 큰 넓이와 무게를 가짐
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Brick> list = new ArrayList<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int base = sc.nextInt();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            list.add(new Brick(base, height, weight));
        }
        Collections.sort(list);

        for (int i = 0; i < n; i++) result[i] = list.get(i).height;
        // i번째 벽돌이 맨 위에 쌓이는 것으로 간주
        int max = result[0];
        for(int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j).weight > list.get(i).weight) {
                    result[i] = Math.max(result[i], result[j] + list.get(i).height);
                }
            }
            max = Math.max(max, result[i]);
        }
        System.out.println(max);
    }
}
