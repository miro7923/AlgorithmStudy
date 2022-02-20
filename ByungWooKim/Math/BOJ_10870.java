/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/10870
 *
 * # 문제
 * 피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
 * 이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
 * n=17일때 까지 피보나치 수를 써보면 다음과 같다.
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
 * n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 1 초 / 메모리 제한:  	256 MB
 *
 * # 입력
 * 첫째 줄에 n이 주어진다. n은 20보다 작거나 같은 자연수 또는 0이다.
 *
 * # 출력
 * 첫째 줄에 n번째 피보나치 수를 출력한다.
 *
 * # 풀이
 * 피보나치 수는 F(n) = F(n-1) + F(n-2) 이므로
 * 첫번째 값과 두번째 값만 알면 그 다음부터는 계속 반복하므로 재귀함수로 표현하면 쉽게 구할 수 있다.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(n));
    }
}
