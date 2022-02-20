/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2231
 *
 * # 문제
 * 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.
 * 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다.
 * 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다.
 * 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
 * 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 2 초 / 메모리 제한:  	192 MB
 *
 * # 입력
 * 첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
 *
 * # 출력
 * 첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.
 *
 * # 풀이
 * 0부터 입력받은 수 N까지 일의 자리수 부터 N의 자리수까지의 합과 그 떄의 수를 더한 값이 N이 되는 경우가 답이 된다.
 * 216의 경우 0부터 216까지의 수 중에서 198일 때 일의 자리수 8 십의 자리수 9 백의 자리수 1 이고 이들의 합은 1 + 9 + 8 = 18
 * 그리고 198 + 18 = 216이고 답은 198이 된다.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int answer;

    static void pro() {
        int num;
        int sum;
        for (int i = 0; i < N; i++) {
            num = i;    // 각 자리 수의 값을 구하기 위해 i를 잠시 임시 값 num에 담아둔다.
            sum = 0;

            while (num > 0) { // 각 자리 수의 합을 구하는 로직
                sum += num % 10; // 이 때 sum의 값은 각 자리수의 합
                num /= 10;
            }

            if (sum + i == N) { // 각 자리 수의 합과 i(답이 될 수)가 입력받은 자연수 N과 동일하면 정답은 i가 된다.
                answer = i;
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pro();
        System.out.println(answer);
    }
}
