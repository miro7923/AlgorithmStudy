/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1094
 *
 * # 문제
 *
 * 지민이는 길이가 64cm인 막대를 가지고 있다. 어느 날, 그는 길이가 Xcm인 막대가 가지고 싶어졌다. 지민이는 원래 가지고 있던 막대를 더 작은 막대로 자른다음에, 풀로 붙여서 길이가 Xcm인 막대를 만들려고 한다.
 * 막대를 자르는 가장 쉬운 방법은 절반으로 자르는 것이다. 지민이는 아래와 같은 과정을 거쳐서 막대를 자르려고 한다.
 * 1. 지민이가 가지고 있는 막대의 길이를 모두 더한다. 처음에는 64cm 막대 하나만 가지고 있다. 이때, 합이 X보다 크다면, 아래와 같은 과정을 반복한다.
 *      1. 가지고 있는 막대 중 길이가 가장 짧은 것을 절반으로 자른다.
 *      2. 만약, 위에서 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 X보다 크거나 같다면, 위에서 자른 막대의 절반 중 하나를 버린다.
 * 2. 이제, 남아있는 모든 막대를 풀로 붙여서 Xcm를 만든다.
 *
 * X가 주어졌을 때, 위의 과정을 거친다면, 몇 개의 막대를 풀로 붙여서 Xcm를 만들 수 있는지 구하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 2 초 / 메모리 제한: 	128 MB
 *
 * # 입력
 * 첫째 줄에 X가 주어진다. X는 64보다 작거나 같은 자연수이다.
 *
 *
 * # 출력
 * 문제의 과정을 거친다면, 몇 개의 막대를 풀로 붙여서 Xcm를 만들 수 있는지 출력한다.
 *
 *
 * # 풀이
 * 10진법으로 표현된 X를 이진법으로 고친 뒤 1의 개수가 막대의 개수와 같다.
 * 23 => (10111) => 4개
 * 64 => (1000000) => 1개
 * 48 => (110000) => 2개
 * 따라서 입력값으로 받은 X를 Integer.toBinaryString() 함수를 이용해 이진수로 고친뒤 문자열들을 탐색하여 1의 개수를 세면 된다.
 *
 */

import java.io.*;

public class BOJ_1094 {

    static int X;
    static String binaryX;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
        binaryX = Integer.toBinaryString(X);  //10진수로 받은 X를 2진수로 바꿔주는 함수(문자열로 반환됨)
    }

    static int count = 0;

    static void calculate() {
        for (int i = 0; i < binaryX.length(); i++) {  //2진수에서 1의 개수를 세준다.
            if (binaryX.charAt(i) == '1')
                count++;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        calculate();
        System.out.println(count);
    }
}
