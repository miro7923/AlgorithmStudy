import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11653 {

	public static void main(String[] args) throws IOException {
		
		
		/*
		 * 문제 정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
		 * 
		 * 입력 첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.
		 * 
		 * 출력 N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다. N이 1인 경우 아무것도 출력하지 않는다.
		 */
		
		//풀이 : 2부터 나눈 나머지값이 0이면 그값을 2로 나눠서 넣고 (/=) 반복하여 0이아니면 +1 , 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int i = 2;
		
		if(T == 1) {
 			return; // T가 1이면 메서드 종료
		}
		
		while(T != 1) { // 2부터 소인수분해
			
			if(T % i == 0) { // 나눠떨어지면 나누기
				System.out.println(i);
				T /= i; 
			}
			else {
				i++;
			}
		}
	}
}
