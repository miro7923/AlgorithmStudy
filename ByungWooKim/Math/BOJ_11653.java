/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/11653
 *
 * # 문제
 * 정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 1 초 / 메모리 제한:  	256 MB
 *
 * # 입력
 * 첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.
 *
 * # 출력
 * N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다. N이 1인 경우 아무것도 출력하지 않는다.
 *
 * # 풀이
 * 정수 N을 2부터 나눠보는데 이때 나눠떨어지면 N의 값을 N / 2로 바꿔주고 2를 출력한다. 이 과정을 2로 나눠떨어지지 않을 때까지 한다.
 * 2로 나눠떨어지 않으면 3으로 또 위의 과정을 한다. 이 과정을 N까지 하면 된다.
 *
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11653 {

    static int N;
    
    // 출력결과가 여러개일 경우 StringBuilder에 담아서 한번에 출력하는 것이 성능상 좋다.
    static StringBuilder sb = new StringBuilder();  

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    static void calculate() {
        for (int i = 2; i <= N; i++) {
            // 만약 i로 나눠떨어지면 N의 값을 N / 2로 바꿔주고 i값을 출력한다.
            while (N % i == 0) {    
                N /= i;
                sb.append(i).append('\n');
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        calculate();
        System.out.println(sb);
    }
}
