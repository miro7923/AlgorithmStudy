/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/11720
 * 
 * # 문제
 * N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
 * 
 * # 제한
 * 시간제한: 1초 / 메모리 제한: 256 MB
 * 
 * # 입력
 * 첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
 * 
 * # 출력
 * 입력으로 주어진 숫자 N개의 합을 출력한다.
 * 
 */

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		
		String input = s.next();
		
		int answer = 0;
		
		for (int i = 0; N > i; i++)
			answer += input.charAt(i) - '0'; // char에서 int로 변경 후 하나씩 더해줌
		
		System.out.println(answer);

	}

}