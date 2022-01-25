/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1003
 * 
 * # 문제
 * 다음 소스는 N번째 피보나치 수를 구하는 C++ 함수이다.
 * int fibonacci(int n) {
 * 	if (n == 0) {
 *      printf("0");
 *      return 0;
 *  } else if (n == 1) {
 *      printf("1");
 *      return 1;
 *  } else {
 *      return fibonacci(n‐1) + fibonacci(n‐2);
 *  }
 * }
 * fibonacci(3)을 호출하면 다음과 같은 일이 일어난다.
 * 
 * fibonacci(3)은 fibonacci(2)와 fibonacci(1) (첫 번째 호출)을 호출한다.
 * fibonacci(2)는 fibonacci(1) (두 번째 호출)과 fibonacci(0)을 호출한다.
 * 두 번째 호출한 fibonacci(1)은 1을 출력하고 1을 리턴한다.
 * fibonacci(0)은 0을 출력하고, 0을 리턴한다.
 * fibonacci(2)는 fibonacci(1)과 fibonacci(0)의 결과를 얻고, 1을 리턴한다.
 * 첫 번째 호출한 fibonacci(1)은 1을 출력하고, 1을 리턴한다.
 * fibonacci(3)은 fibonacci(2)와 fibonacci(1)의 결과를 얻고, 2를 리턴한다.
 * 1은 2번 출력되고, 0은 1번 출력된다. N이 주어졌을 때, fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.
 * 
 * # 제한
 * 시간 제한 : 0.25초, 메모리 제한 : 128 MB
 * 
 * # 입력
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
 * 각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.
 * 
 * # 출력
 * 각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.
 * 
 */

import java.io.*;

public class Main {
	
	static final int MAX = 40;
	static int DP[][];

	public static void main(String[] args) throws IOException {
		
		// Scanner 쓰니까 시간초과 나서 버퍼 입출력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// DP[N][0] = fibonacci(N)을 호출했을 때 0이 출력되는 횟수
		// DP[N][1] = fibonacci(N)을 호출했을 때 1이 출력되는 횟수
		DP = new int[MAX + 1][2]; // N번째 인덱스까지 접근할 수 있게 N+1 크기로 선언
		
		DP[0][0] = 1; 
		DP[0][1] = 0; // 기저조건 설정 -> N = 0일 땐 0 1번 호출됨
		DP[1][0] = 0;
		DP[1][1] = 1; // N = 1일 땐 1 1번 호출됨
		
		// N = 0, N = 1 일 때 조건을 설정해 뒀으니까 반복문은 2부터 시작
		// fibonacci(2)를 호출하면 fibonacci(1) + fibonacci(0)이 호출된다. 
		// fibonacci(1)이 호출되면 1을 1번 출력하고
		// fibonacci(0)이 호출되면 0을 1번 출력한다. 
		// => fibonacci(2)를 호출하면 0과 1이 각각 1번씩 출력된다.
		
		// 위에서 
		// DP[N][0] = fibonacci(N)을 호출했을 때 0이 출력되는 횟수
		// DP[N][1] = fibonacci(N)을 호출했을 때 1이 출력되는 횟수 
		// 라고 정의했기 때문에 피보나치 함수와 같은 점화식을 만들 수 있다.
		for (int i = 2; MAX >= i; i++)
		{
			DP[i][0] = DP[i - 1][0] + DP[i - 2][0];
			DP[i][1] = DP[i - 1][1] + DP[i - 2][1];
		}
		
		int T = Integer.parseInt(bf.readLine()); // 테스트 케이스
		
		for (int testCase = 0; T > testCase; testCase++)
		{
			int N = Integer.parseInt(bf.readLine()); // 입력으로 주어지는 N
			bw.write(DP[N][0] + " " + DP[N][1] + "\n");
		}
		
		bw.close();
		
	}

}
