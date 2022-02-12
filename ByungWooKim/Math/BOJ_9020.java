/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/9020
 *
 * # 문제
 * 1보다 큰 자연수 중에서  1과 자기 자신을 제외한 약수가 없는 자연수를 소수라고 한다. 예를 들어, 5는 1과 5를 제외한 약수가 없기 때문에 소수이다. 하지만, 6은 6 = 2 × 3 이기 때문에 소수가 아니다.
 * 골드바흐의 추측은 유명한 정수론의 미해결 문제로, 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다는 것이다. 이러한 수를 골드바흐 수라고 한다.
 * 또, 짝수를 두 소수의 합으로 나타내는 표현을 그 수의 골드바흐 파티션이라고 한다.
 * 예를 들면, 4 = 2 + 2, 6 = 3 + 3, 8 = 3 + 5, 10 = 5 + 5, 12 = 5 + 7, 14 = 3 + 11, 14 = 7 + 7이다.
 * 10000보다 작거나 같은 모든 짝수 n에 대한 골드바흐 파티션은 존재한다.
 * 2보다 큰 짝수 n이 주어졌을 때, n의 골드바흐 파티션을 출력하는 프로그램을 작성하시오.
 * 만약 가능한 n의 골드바흐 파티션이 여러 가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력한다.
 *
 * # 제한
 * 시간제한: 2 초 / 메모리 제한:  	256 MB
 *
 * # 입력
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고 짝수 n이 주어진다.
 *
 * # 출력
 * 각 테스트 케이스에 대해서 주어진 n의 골드바흐 파티션을 출력한다. 출력하는 소수는 작은 것부터 먼저 출력하며, 공백으로 구분한다.
 *
 * # 풀이
 * 소수를 걸러내는 에라토스테네스의 체를 먼저 한 뒤에
 * i=2부터 입력받은 n까지 i가 소수일 떄와 그리고 n-i가 소수일때의 차이를 구했었다.
 * 그리고 이 차이가 더 작은 값이 나올 수록 이 차이를 바꿔주고 정답이 될 answer1,answer2도 바꿔주었다.
 * 그런데 속도가 480ms에 메모리가 39400KB로 생각보다 많이 나왔다.
 *
 * # 좀 더 효율적인 알고리즘
 * 시간이 160ms에 15352KB메모리를 사용한 사람의 코드를 보니
 * 나는 처음부터 끝까지 돌아서 차이가 적었던 조합을 정답으로 했던 반면
 * n의 중간부터 시작해서 첫번째 파티션과 두번째 파티션을 더한 값이 n이 되면 반복문을 끝내고
 * 아니면 첫번쨰 파티션에는 1을 빼주고 두번째 파티션에는 1을 빼주는 알고리즘을 썼었다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9020 {

    static int T;
    static int n;
    static StringBuilder sb = new StringBuilder();
    static boolean[] isNotPrimeNums;    // 소수면 false값이 소수가 아니면 true값이 들어있도록 할 것!
    static int answer1, answer2;   // 정답을 기록할 두 수 answer1이 작은수가 answer2가 큰 수가 되도록 할 것.
    static int diff;   // 두 소수들의 차이를 기록

    static void calculate() {
        primeNumFilter();
        answer1 = 0;
        answer2 = 0;
        diff = n;
        for (int i = 2; i < n; i++) {
            if (!isNotPrimeNums[i] && !isNotPrimeNums[n - i]) { // n과 소수를 뺸 값이 소수일 떄만 동작하도록!
                if (diff > Math.abs(n - i - i)) {   // 두 소수들의 차이가 더 크면 차이와, 정답이 될 수를 바꿔준다.
                    diff = n - i - i;
                    answer1 = Math.min(i, n - i);  // 더 작은 수가 앞에 나와야 한다.
                    answer2 = Math.max(i, n - i);  // 더 큰 수가 뒤에 나와야 한다.
                }
            }
        }

        sb.append(answer1).append(" ").append(answer2);
    }

    static void primeNumFilter() {
        isNotPrimeNums[0] = true;
        isNotPrimeNums[1] = true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isNotPrimeNums[i])
                continue;

            for (int j = i * 2; j <= n; j += i) {
                isNotPrimeNums[j] = true;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            isNotPrimeNums = new boolean[n + 1];
            calculate();
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
