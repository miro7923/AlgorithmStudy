/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/12833
 *
 * # 문제
 *
 * 세 수 A, B, C를 입력 받은 다음, ( ( ( ( A XOR B ) XOR B ) XOR B ) … ) XOR B 형태로 연산을 C회 했을 때의 결과값을 출력하는 프로그램을 작성하시오.
 *
 * X가 주어졌을 때, 위의 과정을 거친다면, 몇 개의 막대를 풀로 붙여서 Xcm를 만들 수 있는지 구하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 0.2 초 (추가 시간 없음) / 메모리 제한: 	512 MB
 *
 * # 입력
 * 첫째 줄에 A, B, C가 주어진다. (0 < A, B, C ≤ 10^9)
 *
 *
 * # 출력
 * 첫째 줄에 계산된 결과를 출력한다.
 *
 *
 * # 풀이
 * A가 13 B가 3 일때 A XOR B의 연산은 12가 된다. 12 XOR 3의 연산은 다시 13이 된다.
 * A와 B의 숫자에 상관없이
 * 홀수번의 연산 C회를 하는 경우에는 A XOR B의 연산결과이며
 * 짝수번의 연산 C회를 하는 경우에는 (A XOR B) XOR B 이다.
 * 연산횟수 C가 늘어날수록 결국 이러한 이러한 연산이 반복된다.
 * 따라서 C가 짝수이면 (A XOR B) XOR B 연산을
 * 홀수이면 A XOR B 연산만 하면 된다.
 *
 *
 */

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_12833 {

    static int A, B, C;

    //A,B,C 입력값 받는 메서드.
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {
        input();
        
        int answer = A ^ B;
        if (C % 2 == 0)
            answer = answer ^ B;

        System.out.println(answer);
    }
}
