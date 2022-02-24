import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2231 {

	public static void main(String[] args) throws IOException {
		
		
		/*
		 * 
		 * 문제 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. 어떤 자연수 M의 분해합이 N인
		 * 경우, M을 N의 생성자라 한다. 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가
		 * 된다. 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
		 * 
		 * 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.
		 * 
		 * 입력 첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
		 * 
		 * 출력 첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.
		 * 
		 */
		
		//풀이 : 입력값보다 작은 값의 분해값을 구하여 생성자가 있으면 즉시 출력 후 함수종료(최소값 구하는문제) 없으면 0 출력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int disassemble = 0; 
		int temp = 0;
		
		for(int i=1; i<N; i++) {
			temp = i;
			
			disassemble += i; // 처음 값 입력
			
			while(true) {
				
				if(temp / 10 == 0) { // 1의자리일 경우
					
					disassemble += temp%10; // 1의 자리 값 분해값에 더하기
					
					if(N == disassemble) { // i가 생성자 일경우
						System.out.println(i);
						return;
					}
					else {
						disassemble = 0; // 분해값 비우기
						break; // 생성자가 아닌경우 반복문 종료
					}
				}
				
				else { // 1의자리 이상일 경우
					disassemble += temp % 10; // 1의 자리값 분해값에 더하기
					temp /= 10; // 1의자리값 제거
				}
			}
		}
		System.out.println(0); // 반복문 모두 돌아도 생성자 없으면 0 출력
	}
}
