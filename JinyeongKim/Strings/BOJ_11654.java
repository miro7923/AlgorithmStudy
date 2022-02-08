/*
* # 문제 주소
* https://www.acmicpc.net/problem/11654
*
* # 문제
* 알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.
*
* # 제한
* 시간 제한 : 1초 / 메모리 제한 : 256 MB
*
* # 입력
* 알파벳 소문자, 대문자, 숫자 0-9 중 하나가 첫째 줄에 주어진다.
*
* # 출력
* 입력으로 주어진 글자의 아스키 코드 값을 출력한다.
*
*/

/*
* # 풀이
* 문자열 순서를 뒤집는 StringBuilder의 reverse() 메서드 사용
* 공백으로 입력값을 구분해주는 StringTokenizer 사용
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int A = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());    //입력값을 StringBuilder 타입으로 바꾸고 reverse, 다시 String 타입 -> int 타입으로 변환
    	int B = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
    	
    	System.out.println(A>B ? A : B);
    }
}
