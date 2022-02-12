import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1929 {

	public static void main(String[] args) throws IOException{
		
		/*
			문제
			M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
	
			입력
			첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
	
			출력
			한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
		*/
		
		// 풀이 : MN의 최대범위가 100만이므로 이중 for문 사용시 최대 1조번 연산을 해야함
		// 문제에서 소수가 하나이상 있는 입력만 주어지는 조건이므로
		// 에라토네스의체 개념을 적용하여 풀이 
		// 소수가 아닌 수 N이 p * q 라 할경우 , p 또는 q 둘중 하나는 반드시 N의 제곱근보다 같거나 작다
		// ex) N = 16일 경우 p * q = {1 * 16} , {2 * 8}, {4 * 4}, {8 * 2}, {16 * 1}
		// 즉 소수가 아닌 경우 2부터 N의 제곱근까지 수중 N에 나눠지는 수가 있다면 1과 N이 아닌 다른 약수가
		// N의 약수이므로 소수가 아님
	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String temp = br.readLine();
		String[] input = temp.split(" ");
		
		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		boolean[] prime = new boolean[N+1]; 
		
		
		// true : 합성수 false : 소수 
		
		prime[0] = prime[1] = true; // 0 과 1은 제외
		
		for(int i=2; i<Math.sqrt(prime.length); i++) { // 제곱근
			
			if(prime[i]) continue; // 4 6 등 이미 처리된 값은 for문에서 예외처리
			
				for(int j = i*i; j<prime.length; j += i) { // 2부터 2를 제외한 2의배수는 모두 소수 이후 3 , 5 모두 소수처리
					prime[j] = true; 
				}
		}
		
		for(int i=M; i<=N; i++ )
		if(!prime[i]) System.out.println(i);
	}
}
