/*
* # 문제 주소
* www.acmicpc.net/problem/12833
*
* # 문제
* 세 수 A, B, C를 입력 받은 다음, ( ( ( ( A XOR B ) XOR B ) XOR B ) … ) XOR B 형태로 연산을 C회 했을 때의 결과값을 출력하는 프로그램을 작성하시오.
*
* # 제한
* 시간 제한 : 0.2초 / 메모리 제한 : 512 MB
*
* # 입력
* 첫째 줄에 A, B, C가 주어진다. (0 < A, B, C ≤ 109)
*
* # 출력
* 첫째 줄에 계산된 결과를 출력한다.
*
*/

/*
* # 풀이
* a, b를 4, 7이라고 가정할 경우 한 번 수행했을 때 결과는 3이다. 그리고 다시 3, 7로 수행하면 4가 나온다. 결과적으로 c가 홀수면 a xor b 연산 결과가, c가 짝수면 a가 그대로 결과로 도출된다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int a = Integer.parseInt(st.nextToken());
    	int b = Integer.parseInt(st.nextToken());
    	int c = Integer.parseInt(st.nextToken());
    	
    	int n = a^b;     //a xor b는 2진수 형태로 변환하지만, 여기서는 필요 없기 때문에 a^b 연산만 수행
    	System.out.println(c%2==0 ? a : n);
    }
}
