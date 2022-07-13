package Algorithm.Section06;

import java.util.Scanner;

/*
    뮤직비디오(결정알고리즘)
    지니레코드에서는 불세출의 가수 조영필의 라이브 동영상을 DVD로 만들어 판매하려 한다.
    DVD에는 총 N개의 곡이 들어가는데, DVD에 녹화할 때에는 라이브에서의 순서가 그대로 유지되어야 함

    순서가 바뀌는 것을 우리의 가수 조영필씨가 매우 싫어함. 즉, 1번 노래와 5번 노래를 같은 DVD에 녹화하기 위해서는
    1번과 5번 사이의 모든 노래도 같은 DVD에 녹화해야 함. 또한 한 노래를 쪼개서 두 개의 DVD에 녹화하면 안됨
    지니레코드 입장에서는 이 DVD가 팔릴 것인지 확신할 수 없기 때문에 이 사업에 낭비되는 DVD를 가급적 줄이려고 한다.
    고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기로 함. 이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 함
    그리고 M개의 DVD는 모두 같은 크기여야 제조원가가 적게 들기 때문에 꼭 같은 크기로 해야 함

    첫째 줄에 자연수 N(1≤N≤1,000), M(1≤M≤N) 입력
    다음 줄에는 조영필이 라이브에서 부른 순서대로 부른 곡의 길이가 분 단위로(자연수) 입력

    부른 곡의 길이는 10,000분을 넘지 않는다고 가정
    첫 번째 줄부터 DVD의 최소 용량 크기를 출력
 */
public class Algorithm09 {
    private int solution(int n, int m, int[] list) {
       int answer = 0;

       return answer;
    }

    public static void main(String[] args) {
        Algorithm09 al = new Algorithm09();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 곡 수
        int m = sc.nextInt(); // 사용할 DVD 수
        int[] list = new int[n]; // 라이브에서 부른 N개의 곡의 길이

        System.out.println(al.solution(n, m, list));
    }
}
