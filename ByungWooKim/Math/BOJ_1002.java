/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1002
 *
 * 문제
 * 조규현과 백승환은 터렛에 근무하는 직원이다. 하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다.
 * 이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다. 조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.
 * 조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고, 조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때, 류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 2 초 / 메모리 제한: 128 MB
 *
 * # 입력
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 이루어져 있다.
 * 한 줄에 x1, y1, r1, x2, y2, r2가 주어진다. x1, y1, x2, y2는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이고, r1, r2는 10,000보다 작거나 같은 자연수이다.
 *
 * # 출력
 * 각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다. 만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.
 *
 * # 풀이
 * https://mathbang.net/101 참고함.
 * 두 원사이의 거리를 d로 원의 반지름의 길이를 각각 r1,r2라고 했을 때
 * 두 원의 위치관계는 다음과 같다.
 * 두 점에서 만나는경우
 * r2 - r1 < d < r1 + r2
 * 한 점에서 만나는 경우 (이 경우를 계산하려고 하면 오차로 인해 문제가 발생 => 이 경우를 else로 하고 나머지 경우만 처리)
 * r1 + r2 = d
 * 무한개의 점에서 만나는경우
 * 석원이와 규현이의 위치가 같고 재명이까지의 거리도 같을 때
 * 0개의 점에서 만나는 경우
 * 석원이 위치에서 규현이 위치뺀 값(절대값)이 거리 r1,r2를 더한 값보다 클 때
 * r1 + r2 < d (외부에 있을 때)
 * d < r2 - r1 (내부에 있을 때)
 * d = 0, r1 != r2 (동심원)
 *
 *
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1002 {
    static int T;
    static int x1, y1, x2, y2, r1, r2;
    static StringTokenizer st;
    static BufferedReader br;

    static int calculate() {
        double distance = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)); // 규현이와 승환이의 거리(원 중심끼리의 거리)

        // 접점이 0인 경우
        if (r1 + r2 < distance) return 0;
        if (distance < Math.abs(r2 - r1)) return 0;
        if (x1 == x2 && y1 == y2 && r1 != r2) return 0;

        // 접점이 2인 경우
        if (Math.abs(r2 - r1) < distance && distance < r1 + r2) return 2;

        // 접점이 무한대인 경우. 둘의 좌표가 같고 거리가 같으면 접점이 무한대가 될 수 있다.
        if (x1 == x2 && y1 == y2 && r1 == r2) return -1;

        return 1;   //위의 경우들을 제외하면 접점이 1개인 경우밖에 없다.
    }

    static void inputLocation() throws IOException {
        st = new StringTokenizer(br.readLine());

        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        r1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            inputLocation();
            System.out.println(calculate());
        }
    }
}

