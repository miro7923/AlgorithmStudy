/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1920
 * 
 * # 문제
 * N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 128 MB
 * 
 * # 입력
 * 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 
 * 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 
 * 모든 정수의 범위는 -2^31 보다 크거나 같고 2^31보다 작다.
 * 
 * # 출력
 * M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
 * 
 */

import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static ArrayList<Integer> A;
	
	static final int SUCCESS = 1;
	static final int FAILED = 0;

	public static void main(String[] args) throws IOException {
		
		// Scanner 쓰니까 시간초과 나서 버퍼 입출력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(bf.readLine());
		
		A = new ArrayList<>(N);
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for (int i = 0; N > i; i++)
		{
			int input = Integer.parseInt(st.nextToken());
			A.add(input);
		}
		
		A.sort(Comparator.naturalOrder()); // 오름차순 정렬
		
		int M = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; M > i; i++)
		{
			int input = Integer.parseInt(st.nextToken());
			int ans = binarySearch(input, 0, N - 1);
			bw.write(ans + "\n");
		}
		
		bw.close();
		
	}
	
	static public int binarySearch(int num, int l, int r)
	{
		int result = FAILED;
		while (l <= r)
		{
			int m = (l + r) / 2;
			if (num == A.get(m)) 
			{
				// 피봇값이랑 같을 때
				result = SUCCESS;
				break;
			}
			else if (num < A.get(m))
			{
				// 피봇값보다 작을 때
				r = m - 1;
			}
			else 
			{
				// 피봇값보다 클 때
				l = m + 1;
			}
		}
		
		return result;
	}

}
