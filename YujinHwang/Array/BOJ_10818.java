/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/10818
 * 
 * # 문제
 * N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 256 MB
 * 
 * # 입력
 * 첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 
 * 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
 * 
 * # 출력
 * 첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
 * 
 */

import java.io.*;
import java.util.*;

public class Main {
	
	static final int INF = 987654321; // 무한대 숫자 임의 설정
	static final int MIN = -987654321;

	public static void main(String[] args) throws IOException {
		
		// 입출력 시간을 줄이기 위해 버퍼 입출력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(bf.readLine());
		
		int arr[] = new int[N]; // 입력으로 주어지는 N개의 숫자들을 저장할 배열
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// N개의 숫자 하나씩 배열에 저장
		for (int i = 0; N > i; i++)
			arr[i] = Integer.parseInt(st.nextToken()); 
		
		// 최소값은 무한대 값부터 시작해서 입력으로 주어지는 숫자들과 비교해 가면서 더 작은 값을 찾고,
		// 최대값은 음수 무한대 값부터 시작해서 입력으로 주어지는 숫자들과 비교해서 더 큰 값을 찾는다.
		int minVal = INF, maxVal = MIN; 
		for (int i = 0; N > i; i++)
		{
			if (minVal > arr[i]) minVal = arr[i];
			if (maxVal < arr[i]) maxVal = arr[i];
		}
		
		bw.write(minVal + " " + maxVal);
		
		bw.close();
		
	}
	
}
