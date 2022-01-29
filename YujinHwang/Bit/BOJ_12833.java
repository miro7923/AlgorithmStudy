/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/12833
 * 
 * # 문제
 * 세 수 A, B, C를 입력 받은 다음, ( ( ( ( A XOR B ) XOR B ) XOR B ) … ) XOR B 형태로 연산을 C회 했을 때의 결과값을 출력하는 프로그램을 작성하시오.  
 * 
 * # 제한
 * 시간 제한 : 0.2초, 메모리 제한 : 512 MB
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
 * XOR 연산은 비교하는 두 비트의 값이 같지 않으면 1을 리턴하는 연산이다. 
 * 그래서 A XOR B 연산을 한 번 수행하면(1번째) 두 비트 중 같지 않은 것들을 1로 바꾼 결과가 나온다.
 * 그런데 여기서 B와 한 번 더 XOR 연산을 수행하면(2번째) 아까 만들어졌던 모든 비트가 다시 뒤집히기 때문에 다시 A가 된다.
 * 
 * 그렇기 때문에 홀수번 수행하면 A ^ B 값이 나오고 짝수번 수행하면 A 자기자신이 나온다.
 * 그래서 굳이 C번까지 반복문을 돌려볼 필요가 없이(시간 초과남...ㅠ) C가 짝수인지 홀수인지만 구별해서 정답을 출력해주면 된다.
 *  
 */

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 입출력 시간을 줄이기 위해 버퍼 입출력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		if (0 != C % 2)
			A = A ^ B;
		
		bw.write(Integer.toString(A));
		
		bw.close();
		
	}
	
}
