import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12833 {
	static int A;
	static int B;
	static int C;
	static int cnt = 0;
	static int temp;

	public static void main(String[] args) throws IOException {
		
//		문제
//		세 수 A, B, C를 입력 받은 다음, ( ( ( ( A XOR B ) XOR B ) XOR B ) … ) XOR B 형태로 연산을 C회 했을 때의 결과값을 출력하는 프로그램을 작성하시오.
//
//		입력
//		첫째 줄에 A, B, C가 주어진다. (0 < A, B, C ≤ 109)
//
//		출력
//		첫째 줄에 계산된 결과를 출력한다.
		
		// 풀이 : XOR 연산 사용된 횟수를 카운트해서 출력하면 되는 간단한 문제로 예상됨 (정답률도 높음)
		
		// A,B,C의 범위가 10억까지 이므로 int형 사용, 시간단축을 위해 BufferedReader 사용
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		XORXORXOR();

	}
	
	static void XORXORXOR() { 
		
		A = A^B;
		cnt++;
		
		while(true)
		{
			if(cnt == C)
			{
				System.out.println(A);
				break;
			}
			else {
				A = A^B;
				cnt++;
			}
		}
	}
}
