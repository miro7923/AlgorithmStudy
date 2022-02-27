/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/11651
 *
 * # 문제
 * 2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 1 초 / 메모리 제한:  	256 MB
 *
 * # 입력
 * 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다
 *
 * # 출력
 * 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
 *
 * # 풀이
 * 좌표 정렬하기 문제와 거의 동일해서 코드 조금만 바꿔주면 답이 쉽게 나온다..
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static Elem[] points;   // 좌표들을 입력받을 객체 배열
    static int N;
    static StringBuilder sb = new StringBuilder();

    // 정렬을 위한 객체 생성. 객체를 비교하기 위해선 Comparable이나 Comparator 같은 인터페이스의 구현이 필요!!
    static class Elem implements Comparable<Elem>{
        public int x, y;

        @Override
        public int compareTo(Elem other) {
            // 정렬 기준
            if (y != other.y) return y - other.y;
            return x - other.x;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        points = new Elem[N];
        for (int i = 0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i] = new Elem();
            points[i].x = Integer.parseInt(st.nextToken());
            points[i].y = Integer.parseInt(st.nextToken());
        }
    }

    static void sort(){
        Arrays.sort(points);    // points는 Comparable을 구현한 객체기 때문에 객체끼리 비교 가능하고 정렬할 수 있다.
        for (int i=0; i< N; i++){
            sb.append(points[i].x).append(" ").append(points[i].y).append('\n');
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        sort();
        System.out.println(sb);
    }
}
