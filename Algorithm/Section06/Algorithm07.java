package Algorithm.Section06;

import java.util.*;

/*
    좌표 정렬
    N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬
    정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬

    첫 줄에 좌표의 개수인 N(3<=N<=100,000)이 입력
    다음 줄부터 N개의 좌표가 x, y 순으로 입력(x, y값은 양수)
    N개의 좌표를 정렬하여 출력
 */

class Point implements Comparable<Point> {
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point p) {
        if (this.x == p.x) return this.y - p.y;
        return this.x - p.x; // this.x < p.x 일 때, 오름차순으로 정렬하고 싶다면 음수가 나오게 되어야 함
    }
}

public class Algorithm07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(new Point(x, y));
        }

        Collections.sort(list);
        for(Point p : list) {
            System.out.println(p.x + " " + p.y);
        }
    }
}
