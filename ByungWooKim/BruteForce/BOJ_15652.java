/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/15652
 *
 * # 문제
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 *
 * 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 * 고른 수열은 비내림차순이어야 한다.
 * 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
 *
 *
 * # 제한
 * 시간제한: 1 초 / 메모리 제한:  	512 MB
 *
 * # 입력
 * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
 *
 * # 출력
 * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 *
 * # 풀이
 * 알고리즘 강의에서 풀었던 문제라 그때 풀이했던 로직과 동일하다.
 * 참고 : https://github.com/rhs0266/FastCampus/blob/main/%EA%B0%95%EC%9D%98%20%EC%9E%90%EB%A3%8C/02-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/01~02-%EC%99%84%EC%A0%84%20%ED%83%90%EC%83%89/%EB%AC%B8%EC%A0%9C%EB%B3%84%20%EC%BD%94%EB%93%9C/15652-N%EA%B3%BC%20M(4)/solution.java
 *
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
            int start = selected[n-1];  // 중복되는 수열을 제거하기 위해
            if (start == 0) start = 1;
            for (int i = start; i <= N; i++) {
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
