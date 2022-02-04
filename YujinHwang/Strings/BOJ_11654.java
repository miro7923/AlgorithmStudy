/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/11654
 * 
 * # 문제
 * 알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.  
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 256 MB
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
 * char는 숫자에 대응되는 아스키코드로 저장되어 있기 때문에 char를 int로 타입캐스팅하면 아스키코드를 출력할 수 있다.
 * 
 */

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int ans = sc.next().charAt(0);
		
		System.out.println(ans);
		
	}
	
}
