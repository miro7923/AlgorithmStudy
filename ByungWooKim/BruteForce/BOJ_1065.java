/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1065
 *
 * # 문제
 *
 * 어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다.
 * 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
 * N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 2 초 / 메모리 제한: 	128 MB
 *
 * # 입력
 * 첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.
 *
 *
 * # 출력
 * 첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
 *
 *
 * # 풀이
 * 1부터 N까지 모든 수들 중에 한수를 찾아 만약 한수이면 count를 1씩 증가시켜준다.
 * 1부터 99까지는 모두 한수이므로 입력값 N을 10으로 나눴을때 10미만이면 모두 한수이다.
 * 100부터 999까지 한수를 구하는 방법은 (첫째 자리수 - 둘째 자리수) == (둘째 자리수 - 셋쨰 자리수) 일 떄 한수가 성립된다.
 * 따라서 이 조건을 만족시키면 count를 1씩 증가시킨다.
 * 1부터 N까지 이러한 로직을 수행시킨 후에 count를 출력하면 N까지의 한수의 개수를 구할 수 있다.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1065 {

    static int N;
    static int count = 0;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }


    static void countNum() {    // 한수의 개수를 세는 메서드
        for (int i = 1; i <= N; i++) {
            if (i / 10 < 10) {  // 100미만인 수들은 모두 한수이다!
                count++;
                continue;
            }

            // 첫쨰 자리수와 둘쨰 자리수의 차이가 둘째 자리수와 셋쨰 자리수의 차이가 같은지 확인하는 조건. 공차인지(isCommonDifference) 체크
            boolean isCommonDiff = i / 100 - (i % 100 / 10) == (i % 100 / 10) - i % 10;

            if (isCommonDiff) {
                count++;
                continue;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        input();
        countNum();
        System.out.println(count);
    }
}
