/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2108
 *
 * # 문제
 * 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
 *
 * # 제한
 * 시간제한: 2 초 / 메모리 제한:  	128 MB
 *
 * # 입력
 * 첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
 *
 * # 출력
 * 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
 *
 * # 풀이
 * 입력받을 값을 String으로 받아서 char[]배열에 담는다. 그리고 Arrays.sort()메서드를 이용해 char[]배열을 정렬한다.
 * 내림차순으로 정렬해야하므로 char[]배열을 거꾸로 순회하면서 StringBuilder에 담아서 출력한다.
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char[] num;
    static String N;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        num = new char[N.length()];
    }

    static void makeString(){
        for (int i = 0; i < N.length(); i++) {
            num[i] = N.charAt(i);
        }

        Arrays.sort(num);

        for (int i = num.length - 1; i >= 0; i--){
            sb.append(num[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        makeString();
        System.out.println(sb);
    }
}
