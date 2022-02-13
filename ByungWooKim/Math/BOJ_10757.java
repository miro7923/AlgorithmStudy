/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/10757
 *
 * # 문제
 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 1 초 / 메모리 제한:  256 MB
 *
 * # 입력
 * 첫째 줄에 A와 B가 주어진다. (0 < A,B < 10^10000)
 *
 * # 출력
 * 첫째 줄에 A+B를 출력한다.
 *
 * # 풀이
 * BigDecimal나 BigInteger 클래스를 사용하면 간편하게 큰수끼리의 합을 구할 수 있다.
 *
 *
 * BigInteger 클래스나 BigDecimal 클래스의 더하기 기능을 내가 직접 구현해보려고 문자열 조작해보았으나,,
 * 코드로 짜는 시간도 너무 오래걸리고 코드 길이도 너무 길어지고 은근 구현하기 어려워서 포기함..
 * 그냥 BigInteger 클래스를 사용해 풀이함..
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class BOJ_10757 {
    static BigDecimal A,B;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new BigDecimal(st.nextToken());
        B = new BigDecimal(st.nextToken());
    }
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(A.add(B));
    }
}
/*
내가 직접 BigInteger클래스의 add 메서드를 구현해보려고 했던 로직들.. 시간되면 다시 짜보자..
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static StringBuilder A = new StringBuilder();
    static StringBuilder B = new StringBuilder();
    static StringBuilder answer = new StringBuilder();
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A.append(st.nextToken());
        B.append(st.nextToken());
    }
    static int a, b, sum;
    static boolean isOverTen;
    static void plus(int index, int lastIndex) {
        if (isOverTen) {
            sum = a + b + 1;
        } else sum = a + b;
        if (A.length() == B.length() && index == lastIndex) {
            if (sum >= 10) {
                answer.append(sum % 10).append(sum / 10);
            } else {
                answer.append(sum % 10);
            }
            return;
        }
        if (A.length() > B.length() && index == A.length()){
            if(isOverTen){
                answer.append(a+1);
            }
            answer.append(a);
        }
        if(A.length() < B.length() && index == B.length()){
            if(isOverTen){
                answer.append(b+1);
            }
            answer.append(b);
        }
        if (sum >= 10) {
            isOverTen = true;
            answer.append(sum - 10);
        } else {
            isOverTen = false;
            answer.append(sum);
        }
    }
    static void calculate() {
        //StringBuilder의 끝에서부터 각각 더해준다. 좀 더 편리하게 사용하기 위해 뒤집어준다.
        A.reverse();
        B.reverse();
        int lowLength = Math.min(A.length(), B.length());
        int longLength = Math.max(A.length(), B.length());
        for (int index = 0; index < lowLength; index++) {
            a = A.charAt(index) - '0';
            b = B.charAt(index) - '0';
            plus(index, lowLength - 1);
        }
        if (A.length() > B.length()) {
            for (int i = lowLength; i < A.length(); i++) {
                plus(i, A.length()-1);
            }
        } else if (A.length() < B.length()) {
            for (int i = lowLength; i < B.length(); i++) {
                plus(i, B.length()-1);
            }
        }
        answer.reverse();
    }
    public static void main(String[] args) throws IOException {
        input();
        calculate();
        System.out.println(answer.toString());
    }
}
 */
