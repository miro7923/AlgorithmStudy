import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10757 {

	public static void main(String[] args) throws IOException {
		
		/*
		 * 
		 * 문제 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
		 * 
		 * 입력 첫째 줄에 A와 B가 주어진다. (0 < A,B < 1010000)
		 * 
		 * 출력 첫째 줄에 A+B를 출력한다.
		 * 
		 */

		// 풀이 : 평소에 궁금했던 기본구조 자료형타입의 입력 범위를 넘는 수의 연산은 어떻게 하는지?에 관한 문제로
		// int[] 배열을 이용하여 풀이를 해보자
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String temp = br.readLine();
		String[] input = temp.split(" "); 
		
		String A = input[0];
		String B = input[1];
		
		int[] a;
		int[] b;
		int max_length = 0;
		
		if(A.length() > B.length()) { // A와 B 자리수 크기비교하여 더큰쪽 따르기
			a = new int[A.length() + 1]; // 마지막 자리수 올림 대비 +1칸 
			b = new int[A.length() + 1];  
			max_length = A.length();
		}
		
		else {
			a = new int[B.length() + 1]; 
			b = new int[B.length() + 1];  
			max_length = B.length();
		}
		
		//배열을 뒤집어서 입력
		
		for(int i=0; i<A.length(); i++) { // a배열 입력
			a[i] = A.charAt(A.length()-1-i) -'0';
		}
		
		for(int i=0; i<B.length(); i++) { // b배열 입력
			b[i] = B.charAt(B.length()-1-i) -'0';
		}
		
		for(int i=0; i<max_length; i++) {
			
			int value = a[i] + b[i];
			
			a[i] = value % 10; // 자릿값은 나머지값이고
			a[i+1] += (value / 10); // 10이상일경우 다음자리에 1더함
		}
		
		if(a[max_length] != 0) { // 첫자리 올림 확인
			sb.append(a[max_length]);
		}
		
		for(int i=max_length-1; i>=0; i--) {
			sb.append(a[i]);
		}
		System.out.println(sb);
	}
}
