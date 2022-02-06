/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1065
 * 
 * # 문제
 * 어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. 
 * N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 
 * 
 * # 제한
 * 시간 제한 : 2초, 메모리 제한 : 128 MB
 * 
 * # 입력
 * 첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.
 * 
 * # 출력
 * 첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
 * 
 */

/*
 * # 풀이
 * 어떤 숫자의 마지막 두 자리수간의 차를 먼저 구한 다음에 남은 자리수들간의 차가 앞에서 구한 차와 같다면 한수이고 아니라면 한수가 아니다.
 * 이 아이디어를 그대로 코드로 구현해 보았다.
 * 
 */

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 입출력 시간을 줄이기 위해 버퍼 입출력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(bf.readLine());
		int ans = 0;
		for (int i = 1; N >= i; i++)
		{
			int num = i;
			int prev = num % 10; // 비교를 시작할 마지막자리
			num /= 10; // 다음 자리를 구할 수 있게 10으로 나눈다.
			int curr = num % 10; // 그 다음자리
			int diff = prev - curr; // 두 자리수의 차
			num /= 10; // 다음 자리를 구해서 비교할 수 있도록 10으로 나눈다.
			
			boolean isCorrect = true; // 한수인지 아닌지 표시할 변수
			while (0 < num) // num이 0보다 클 동안에 계속 10으로 나눠가며 자리수간의 차를 비교한다.
			{
				prev = curr; // 현재 자리수를 이전 자리수로 저장
				curr = num % 10; // 현재 자리수를 구한다.
				
				// 위에서 구한 두 자리수의 차가 새로 구한 마지막 자리수와 같지 않으면 한수가 아니다. 
				// 따라서 false 표시하고 검사를 중단한다.
				if (diff != prev - curr)
				{
					isCorrect = false;
					break;
				}
				num /= 10; // 다음 비교를 위해 10으로 나눠주기
			}
			
			// 한수라면 정답 카운트 증가
			if (isCorrect) ans++; 
		}
		
		bw.write(Integer.toString(ans));
		
		bw.close();
		
	}
	
}
