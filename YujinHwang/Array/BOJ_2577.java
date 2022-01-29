/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2577
 * 
 * # 문제
 * 세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
 * 예를 들어 A = 150, B = 266, C = 427 이라면 A × B × C = 150 × 266 × 427 = 17037300 이 되고, 
 * 계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 128 MB
 * 
 * # 입력
 * 첫째 줄에 A, 둘째 줄에 B, 셋째 줄에 C가 주어진다. A, B, C는 모두 100보다 크거나 같고, 1,000보다 작은 자연수이다.
 * 
 * # 출력
 * 첫째 줄에는 A × B × C의 결과에 0 이 몇 번 쓰였는지 출력한다. 
 * 마찬가지로 둘째 줄부터 열 번째 줄까지 A × B × C의 결과에 1부터 9까지의 숫자가 각각 몇 번 쓰였는지 차례로 한 줄에 하나씩 출력한다.
 * 
 */

import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = 10;

	public static void main(String[] args) throws IOException {
		
		// 입출력 시간을 줄이기 위해 버퍼 입출력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int A = Integer.parseInt(bf.readLine());
		int B = Integer.parseInt(bf.readLine());
		int C = Integer.parseInt(bf.readLine());

		int result = A * B * C; // A * B * C 결과를 저장할 변수
		int arr[] = new int[MAX]; // 0~9 숫자가 쓰인 횟수를 저장할 배열
								  // 0번째 인덱스에는 0이 쓰인 횟수를 저장하고 1번째 인덱스에는 1이 쓰인 횟수를 저장하는 방식으로 
								  // 각 인덱스 번호와 숫자를 매칭시킨다.  
		while (0 < result)
		{
			int remain = result % 10; // A * B * C 결과를 10으로 나눈 나머지를 구한다.
			arr[remain]++; // 배열에서 나머지에 해당되는 인덱스의 원소값을 1 증가시킨다.
			result /= 10; // A * B * C 결과를 10으로 나눈 다음 위의 과정을 반복한다.
		}
		
		for (int i = 0; MAX > i; i++)
			bw.write(arr[i] + "\n"); // 결과를 한 줄에 하나씩 출력
		
		bw.close();
		
	}
	
}
