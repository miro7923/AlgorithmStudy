/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2775
 * 
 * # 문제
 * 평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어 각 층의 사람들을 불러 모아 반상회를 주최하려고 한다.
 * 
 * 이 아파트에 거주를 하려면 조건이 있는데, 
 * “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.
 * 
 * 아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때, 
 * 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라. 
 * 단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 128 MB
 * 
 * # 입력
 * 첫 번째 줄에 Test case의 수 T가 주어진다. 그리고 각각의 케이스마다 입력으로 첫 번째 줄에 정수 k, 두 번째 줄에 정수 n이 주어진다  
 * 
 * # 출력
 * 각각의 Test case에 대해서 해당 집에 거주민 수를 출력하라.  
 * 
 */

/*
 * # 풀이
 * 문제 이해를 잘못 한건지 틀리게 구현한 거 같아서 긴가민가 하면서 냈는데 맞았다...
 * 문제를 다시 읽어보니까 k-1층까지의 누적합이 아니고 k-1층에서의 누적합만 구하면 되는 것이었네...
 * 
 * 기본적인 접근은 DP로 했다.
 * k층에 사는 사람들의 합계는 구할 필요가 없이 k-1층에 사는 사람들 중 n번째 집에 사는 사람들까지의 누적합계만 구하면 되기 때문에
 * [k][n]에 사는 사람들의 수는 [k-1][1] + [k-1][2] + [k-1][3] + ... [k-1][n]이 된다.
 * 그런데 층수가 올라가면서 이전 층의 데이터가 필요하기 때문에 이 데이터들을 저장할 장소가 필요하니까 2차원 배열을 만들어서 반복문으로 위의 식을 구현한 후
 * 2차원 배열의 [k][n] 인덱스의 원소값을 출력했다.
 * 
 * # 결과
 * 시간 : 132 ms, 메모리 : 14208 KB
 * 
 */

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		final int MAX = 15; // k, n의 최대 입력 크기. 0층~14층까지 있어서 14번 인덱스에 접근할 수 있도록 14+1
		
		// 입력 시간을 줄이기 위해 버퍼 입력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine()); // 테스트케이스
		int k, n;
		
		int apt[][] = new int[MAX][MAX]; // [k층][n호]에 사는 사람의 수
		for (int i = 1; MAX > i; i++) // 0층은 기저조건으로 깔아준 후
			apt[0][i] = i;
		
		// 1층부터 바로 아래층의 데이터를 이용해서 현재층을 채운다.
		// [k][n]번 집에는 [k-1][n]번 집에 사는 사람의 수와 [k][n-1]번 집에 사는 사람들의 수를 합친 것과 같다.
		for (int i = 1; MAX > i; i++)
			for (int j = 1; MAX > j; j++)
				apt[i][j] = apt[i-1][j] + apt[i][j-1];
		
		for (int testCase = 0; T > testCase; testCase++)
		{
			k = Integer.parseInt(bf.readLine()); 
			n = Integer.parseInt(bf.readLine());
			
			// 입력의 최대값이 작아서 미리 계산을 해 놓은 뒤 테스트 케이스에서는 배열의 원소값을 바로 출력
			System.out.println(apt[k][n]);
		}
		
	}
	
}
