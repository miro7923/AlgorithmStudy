import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1193 {

	public static void main(String[] args) throws IOException {
		
		/*
		 * 
		 * 문제 
		 * 무한히 큰 배열에 다음과 같이 분수들이 적혀있다.
		 * 
		 * 1/1 1/2 1/3 1/4 1/5 … 2/1 2/2 2/3 2/4 … … 3/1 3/2 3/3 … … … 4/1 4/2 … … … …
		 * 5/1 … … … … … … … … … … … 이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은
		 * 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
		 * 
		 * X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
		 * 
		 * 입력 
		 * 첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.
		 * 
		 * 출력 
		 * 첫째 줄에 분수를 출력한다.
		 * 
		 */
		
		//풀이 : 대각선을 기준으로 짝수번째는 분모가 크고 홀수번째는 분자가 크다.
		// 입력값 n , 대각선안의 원소의 수 count , 이전까지 원소의 개수의 합 prev_count 3개의 변수를 이용하여 출력값을 만들어 풀이
		// 1,2~3,4~6,7~10 -> 1,1+2,1+2+3...
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int count = 1;
		int prev_count = 0;
		
		while(n>prev_count) { // 일단 몇번째 대각선인지 파악함 4일경우 3번째 대각선 이므로 
			prev_count += count++;
		}
		
		// n = 3일때 count 3 prev 3임 count는 2가 돼야하고 pre는 1이여야함
		count--;
		prev_count -= count;
		
		if(count % 2 == 1) { // 홀수 일때 분자가 큼
			System.out.println((count+1-(n-prev_count)) + "/" + (n-prev_count));
		}
		
		else if(count % 2 == 0) { // 짝수 일때 분모가 큼
			System.out.println((n-prev_count) + "/" + (count+1-(n-prev_count)));
		}
		
		

	}

}
