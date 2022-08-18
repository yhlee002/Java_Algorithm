package Algorithm.Section09;

import java.util.*;

/*
현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다.
현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.
현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.
“A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은(크고, 무겁다) 지원자가
존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”
N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램을 작성하세요.
 */
public class Algorithm01 {
    static class Person implements Comparable<Person> {
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Person o) {
            return o.height - this.height;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            list.add(new Person(h, w));
        }
/*  방법 1
        int answer = list.size();
        for (int i = 0; i < list.size(); i++) {
            Person p1 = list.get(i);

            for (Person p2 : list) {
                if (p1.height < p2.height && p1.weight < p2.weight) {
                    answer--;
                    break;
                }
            }
        }

        System.out.println(answer);
*/

        // 방법 2
        Collections.sort(list);
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for (Person p : list) {
            if (p.weight > max) {
                max = Math.max(max, p.weight);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}