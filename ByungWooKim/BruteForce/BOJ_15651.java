/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/15651
 *
 * # 문제
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 *
 * 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 *
 * # 제한
 * 시간제한: 1 초 / 메모리 제한:  	512 MB
 *
 * # 입력
 * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)
 *
 * # 출력
 * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 *
 * # 풀이
 * 알고리즘 강의에서 풀었던 문제라 그때 풀이했던 로직과 동일하다.
 *
 * 출력할 한줄의 숫자들을 담을 배열 selected를 이용한다.
 * N과 M (1), (2)와 다르게 중복을 허용하기 떄문에 모든 경우의 수들을 selected배열에 넣는다.
 *
 * 재귀함수recur()를 이용한다.
 *
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] selected;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 배열의 index는 0부터 시작하지만 문제에서 1부터 N까지 고를 것이기 때문에 배열의 크기는 1을 더한다.
        selected = new int[M + 1];
    }

    static StringBuilder sb = new StringBuilder();

    static void recur(int n) {
        if (n == M + 1) {   // selected배열을 완성
            for (int i = 1; i <= M; i++) sb.append(selected[i]).append(" ");
            sb.append('\n');
        } else {
            for (int i = 1; i <= N; i++) {  // N ^ M 번 반복문을 돌게된다.(재귀호출포함)
                selected[n] = i;
                recur(n + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        recur(1);   // 1부터 N까지의 자연수기 때문에 1부터 시작
        System.out.println(sb);
    }
}
