/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/4948
 *
 * # 문제
 * 베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.
 * 이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.
 * 예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)
 * 자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 1 초 / 메모리 제한:  	256 MB
 *
 * # 입력
 * 입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 케이스는 n을 포함하는 한 줄로 이루어져 있다.
 * 입력의 마지막에는 0이 주어진다.
 *
 * # 출력
 * 각 테스트 케이스에 대해서, n보다 크고, 2n보다 작거나 같은 소수의 개수를 출력한다.
 *
 * # 풀이
 * 1929번의 소수 구하기 문제와 거의 똑같은 문제였다.
 * 마찬가지로 에라토네스의 체를 이용하여 소수들을 제외하고 모두 걸러내고
 * n+1부터 2n까지 소수인수들의 count를 계산해주면 되었다.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4948 {

    static int n;
    static int count;
    static boolean[] isNotPrimeNums;    // 소수가 아니면 true, 소수면 false

    static void calculate() {
        isNotPrimeNums[0] = true;
        isNotPrimeNums[1] = true;
        for (int i = 2; i <= Math.sqrt(2 * n); i++) {   //에라토스테네스의 체 활용 : 구하려는 모든 배열의 제곱근까지 소수인 수들의 배수들을 모두 제거
            // 소수인지 체크. 자기 자신을 제외한 나머지의 수를 나누었을 때 나누어 떨어지면 소수
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isNotPrimeNums[i] = true;
                    break;
                }
            }
            // 소수이면 그 소수의 배수들을 모두 true(소수가 아님)로 바꿔준다.
            if (!isNotPrimeNums[i]) {
                for (int j = i * 2; j <= 2 * n; j += i) {
                    isNotPrimeNums[j] = true;
                }
            }
        }

        for (int i = n + 1; i <= 2 * n; i++) {
            if (!isNotPrimeNums[i]) {
                count++;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            n = Integer.parseInt(br.readLine());

            if (n == 0) break;
            isNotPrimeNums = new boolean[2 * n + 1];
            calculate();
            System.out.println(count);
            count = 0;  // 각 케이스마다 소수의 개수를 0으로 초기화화
        }
    }
}
