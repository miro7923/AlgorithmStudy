/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1003
 *
 * # 문제
 *다음 소스는 N번째 피보나치 수를 구하는 C++ 함수이다.
 * int fibonacci(int n) {
 *   if (n == 0) {
 *         printf("0");
 *         return 0;
 *     } else if (n == 1) {
 *         printf("1");
 *         return 1;
 *     } else {
 *         return fibonacci(n‐1) + fibonacci(n‐2);
 *     }
 * }
 * fibonacci(3)을 호출하면 다음과 같은 일이 일어난다.
 * fibonacci(3)은 fibonacci(2)와 fibonacci(1) (첫 번째 호출)을 호출한다.
 * fibonacci(2)는 fibonacci(1) (두 번째 호출)과 fibonacci(0)을 호출한다.
 * 두 번째 호출한 fibonacci(1)은 1을 출력하고 1을 리턴한다.
 * fibonacci(0)은 0을 출력하고, 0을 리턴한다.
 * fibonacci(2)는 fibonacci(1)과 fibonacci(0)의 결과를 얻고, 1을 리턴한다.
 * 첫 번째 호출한 fibonacci(1)은 1을 출력하고, 1을 리턴한다.
 * fibonacci(3)은 fibonacci(2)와 fibonacci(1)의 결과를 얻고, 2를 리턴한다.
 * 1은 2번 출력되고, 0은 1번 출력된다. N이 주어졌을 때, fibonacci(N)을 호출했을 때,
 * 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 0.25 초 (추가 시간 없음) / 메모리 제한: 128 MB
 *
 * # 입력
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
 * 각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.
 *
 *
 * # 출력
 * 각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N; // 테스트 케이스 개수
    static BufferedReader br;
    static int[] inputValues; // 입력받는 값들
    static int[][] answers; // 0이 출력되는 횟수는 [n][0]에 1이 출력되는 횟수는[n][1]에 넣는다.


    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputValues = new int[N];
    }

    static void calculate() throws IOException {
        for (int i = 0; i < N; i++) {
            inputValues[i] = Integer.parseInt(br.readLine());
            answers = new int[inputValues[i]+1][2];

            answers[0][0] = 1;      answers[0][1] = 0;
            if(inputValues[i]==1){
                answers[1][0] = 0;     answers[1][1] = 1;
            } else if (inputValues[i] >= 2){

                fibonacci(inputValues[i]);
            }
            System.out.println(answers[inputValues[i]][0] + " " + answers[inputValues[i]][1]);
        }
    }

    static void fibonacci(int n) {
        answers[1][0] = 0;
        answers[1][1] = 1;

        //입력받는 값이 2부터 0이 출력되는 횟수는 1 => 1 => 2 => 3 => 5 식으로 피보나치수열이
        //입력받는 값이 2부터 1이 출력되는 횟수는 1 => 2 => 3 => 5 => 8 이다.
        //1이 출력되는 횟수가 0이 출력되는 횟수보다 1번 빠른(?)피보나치 수열인 셈.

        if (n >= 2) {
            for (int i = 2; i < answers.length; i++) {
                answers[i][0] = answers[i - 1][0] + answers[i - 2][0];
                answers[i][1] = answers[i - 1][1] + answers[i - 2][1];
            }
        }

    }

    public static void main(String[] args) throws IOException {
        input();
        calculate();
    }
}

/*
입력 케이스 하나마다 출력해줘야 했는데 처음에 입력 케이스 모두를 입력받고 한번에 출력하려고 하니 계속 런타임 오류 에러가 발생했다...
문제를 잘 읽어보자!!
 */
