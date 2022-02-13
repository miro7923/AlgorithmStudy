import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4948 {

	
	public static void main(String[] args) throws IOException{
		
		
		/*
		 * 문제 베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.
		 * 
		 * 이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.
		 * 
		 * 예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나
		 * 같은 소수는 3개가 있다. (17,19, 23)
		 * 
		 * 자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오.
		 * 
		 * 입력 입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 케이스는 n을 포함하는 한 줄로 이루어져 있다.
		 * 
		 * 입력의 마지막에는 0이 주어진다.
		 * 
		 * 출력 각 테스트 케이스에 대해서, n보다 크고, 2n보다 작거나 같은 소수의 개수를 출력한다.
		 */
		
		// 풀이 : 입력범위가 123456이므로 에라토스테네스의 체를 이용하여 풀어보자
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] prime = new boolean[123456 * 2 +1]; // 소수 계산 배열
		// true : 소수 , false : 합성수 
		prime[0] = prime[1] = true; 
		int cnt = 0; // 소수 카운트
		
		for(int i=2; i<Math.sqrt(123456 * 2 +1); i++) {
			if(prime[i]) continue; // 소수이면 넘김
			for(int j=i*i; j<123456 * 2 +1; j+=i )
				prime[j] = true;
		}
		
		while(true){ // 0나올때 종료
			
			int n = Integer.parseInt(br.readLine());
				
			if(n == 0)
				break;
			else { // n 보다 크고 2n보다 작거나 같은 소수의 개수
				for(int i=n+1; i<=2*n; i++) {
					if(!prime[i]) cnt++;
				}
			}
			sb.append(cnt + "\n");
			cnt = 0; // cnt 초기화
		}
		
		System.out.println(sb);
		
	}
}
