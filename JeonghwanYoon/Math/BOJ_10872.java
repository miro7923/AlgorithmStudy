import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10872 {

	public static void main(String[] args) throws IOException{
		
		/*
		 * 문제 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
		 * 
		 * 입력 첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.
		 * 
		 * 출력 첫째 줄에 N!을 출력한다.
		 * 
		 */
		
		// 풀이 : 12!의 경우 4억 8천쯤 되므로 단순연산으로 풀어도 괜찮을것 같다
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int num = N;
		
		for (int i=1; i<N; i++) {
			num *= i;
		}
		
		if (N == 0) {
			System.out.println(1);
		}
		else 
		System.out.println(num);
		
	}

}
