/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/9020
 * 
 * # 제한
 * 시간 제한 : 2초, 메모리 제한 : 256 MB
 * 
 * # 문제
 * 1보다 큰 자연수 중에서 1과 자기 자신을 제외한 약수가 없는 자연수를 소수라고 한다. 
 * 예를 들어, 5는 1과 5를 제외한 약수가 없기 때문에 소수이다. 하지만, 6은 6 = 2 × 3 이기 때문에 소수가 아니다.
 * 골드바흐의 추측은 유명한 정수론의 미해결 문제로, 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다는 것이다. 이러한 수를 골드바흐 수라고 한다. 
 * 또, 짝수를 두 소수의 합으로 나타내는 표현을 그 수의 골드바흐 파티션이라고 한다. 
 * 예를 들면, 4 = 2 + 2, 6 = 3 + 3, 8 = 3 + 5, 10 = 5 + 5, 12 = 5 + 7, 14 = 3 + 11, 14 = 7 + 7이다. 
 * 10000보다 작거나 같은 모든 짝수 n에 대한 골드바흐 파티션은 존재한다.
 * 2보다 큰 짝수 n이 주어졌을 때, n의 골드바흐 파티션을 출력하는 프로그램을 작성하시오. 
 * 만약 가능한 n의 골드바흐 파티션이 여러 가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력한다.
 * 
 * # 입력
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고 짝수 n이 주어진다.
 * 4 ≤ n ≤ 10,000
 * 
 * # 출력
 * 각 테스트 케이스에 대해서 주어진 n의 골드바흐 파티션을 출력한다. 출력하는 소수는 작은 것부터 먼저 출력하며, 공백으로 구분한다.  
 * 
 */

/*
 * # 풀이
 * 골드바흐 파티션의 두 수가 소수인지 판별한 다음 소수면 출력하는 것이 기본 아이디어이다.
 * 그런데 문제에서 골드바흐 파티션이 여러 개인 경우에는 두 수의 차가 가장 적은 것을 출력하라고 했기 때문에 
 * 이전에 나왔던 골드바흐 파티션과 현재 골드바흐 파티션의 차를 비교해야 한다. 
 * 그렇기 때문에 두 수의 차를 저장할 필요가 있고 이전 골드바흐 파티션도 저장할 필요가 있다. => diff, prevFirstNum, prevSecondNum
 * 이전에 구했던 차(diff)와 비교해서 현재 골드바흐 파티션의 차가 더 적으면 diff를 갱신하고 prevFirstNum, prevSecondNum을 현재 골드바흐 파티션을 저장한다.
 * 그러면 prevFirstNum, prevSecondNum에는 항상 정답이 되는 수가 들어있다.
 * 마지막에 prevFirstNum, prevSecondNum들을 출력하면 정답이다. 
 * 
 * 그런데 좀 고민했던 것이 골드바흐 파티션을 조사하기 위해 반복하는 범위였는데 예제를 보니까 나올 수 있는 가장 큰 수가 n을 2로 나눈 수여서
 * 현재 골드바흐 파티션의 첫번째 숫자가 n/2가 되는 지점까지만 반복했다.
 * 
 * 소수를 구하는 알고리즘은 아래 설명글을 참조. O(log n)에 구하는 알고리즘을 사용했다.
 * 하지만 정직하게 2부터 i까지의 수의 나머지를 구하면서 소수를 판별하면 시간이 오래 걸리기 때문에 i의 제곱근 만큼만 반복하는 알고리즘을 썼다.
 * i의 제곱근만큼만 반복해도 소수인지 판별이 되는 이유는 제곱근을 넘어가는 수 부터는 앞전에 구했던 곱해서 i가 되는 수들이 순서만 바뀌어서 똑같이 나오기 때문이다.
 * 예를 들어 i=16라면
 * 1*16
 * 2*8
 * 4*4
 * 8*2
 * 16*1
 * 위와 같이 16의 제곱근인 4를 기점으로 앞전에 나왔던 수들이 순서만 바뀌어서 나온다. 
 * 그래서 제곱근을 초과하는 수에 대해 소수를 판별하는 연산을 하는 것은 생략해도 결과에 영향이 없다.
 * 
 * https://notepad96.tistory.com/entry/C-%EC%86%8C%EC%88%98-%ED%8C%90%EB%B3%84%ED%95%98%EA%B8%B0
 * 예전에 참고했던 글인데 언어 상관없이 개념적으로 참고하기 좋은 글이다.
 * 
 * # 결과
 * 시간 : 904 ms, 메모리 : 18440 KB
 * 
 */

import java.io.*;

public class Main {
	
	static final int INF = 987654321; // 최소값을 구하기 위해 초기값으로 설정하는 임의의 큰 수
	
	// 입력된 수가 소수인지 판별하는 함수
	public static boolean isPrimeNum(int num)
	{
		// 2보다 작으면 1인데 1은 소수가 아니니까 false 리턴
		if (2 > num)
			return false;
		
		// num의 제곱근을 구한다.
		int a = (int) Math.sqrt(num);
		for (int i = 2; a >= i; i++)
		{
			// 2부터 제곱근만큼만 반복하면서 나눠 떨어지는 수가 있으면 소수가 아니다.
			if (0 == num % i)
				return false;
		}
		
		// 위 반복문을 통과하면 소수
		return true;
	}

	public static void main(String[] args) throws IOException {
		
		// 입력 시간을 줄이기 위해 버퍼 입력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		int n; // 주어지는 n
		int curFirst, curSecond, prevFirst = 0, prevSecond = 0, diff, limit; // 골드바흐 파티션의 첫번째 수, 두번째 수, 두 수의 차
		for (int tc = 0; T > tc; tc++)
		{
			n = Integer.parseInt(bf.readLine());
			curFirst = 2; // 소수는 2부터 시작
			diff = INF;
			limit = (int) (n * 0.5); // 나누기 연산보다 곱하기 연산이 훨씬 빠르다. 같은 결과를 낼 수 있다면 곱하기 연산을 사용하는 것이 효율적
			for (; limit >= curFirst; curFirst++) // 현재 첫번째 수가 n의 절반보다 작거나 같을 때까지만 반복한다.
			{
				curSecond = n - curFirst;
				
				// 둘 다 소수라면
				if (isPrimeNum(curFirst) && isPrimeNum(curSecond))
				{
					// 두 수의 차를 구해서 이전에 구했던 차와 비교한다.
					int tmp = curSecond - curFirst;
					
					// 이전에 구했던 차보다 작으면 골드바흐 파티션 갱신
					if (diff > tmp)
					{
						diff = tmp;
						prevFirst = curFirst;
						prevSecond = curSecond; // 여기엔 항상 정답만 들어있게 된다.
					}
				}
			}
			
			System.out.println(prevFirst + " " + prevSecond);
		}
		
	}
	
}
