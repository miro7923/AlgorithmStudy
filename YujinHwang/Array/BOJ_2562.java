/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2562
 * 
 * # 문제
 * 9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.
 * 예를 들어, 서로 다른 9개의 자연수
 * 3, 29, 38, 12, 57, 74, 40, 85, 61
 * 이 주어지면, 이들 중 최댓값은 85이고, 이 값은 8번째 수이다.
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 128 MB
 * 
 * # 입력
 * 첫째 줄부터 아홉 번째 줄까지 한 줄에 하나의 자연수가 주어진다. 주어지는 자연수는 100 보다 작다.
 * 
 * # 출력
 * 첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 몇 번째 수인지를 출력한다.
 * 
 */

import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = 9;

	public static void main(String[] args) throws IOException {
		
		// 입출력 시간을 줄이기 위해 버퍼 입출력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int arr[] = new int[MAX]; // 입력으로 주어지는 N개의 숫자들을 저장할 배열
		
		// N개의 숫자 하나씩 배열에 저장
		for (int i = 0; MAX > i; i++)
		{
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		int maxVal = 0, idx = 0; // 최대값, 최대값이 저장된 순서
		for (int i = 0; MAX > i; i++)
		{
			if (maxVal < arr[i]) 
			{
				maxVal = arr[i];
				idx = i;
			}
		}
		
		bw.write(maxVal + "\n" + ++idx); // 배열 인덱스는 0부터 시작하니까 위 반복문에서 구한 순서는 실제 입력된 순서보다 1이 작다.
										 // 그래서 구한 인덱스값에 1을 더해준다. 
		
		bw.close();
		
	}
	
}
