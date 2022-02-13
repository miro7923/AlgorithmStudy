/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2581
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 128 MB
 * 
 * # 문제
 * 자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.
 * 예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 
 * 이들 소수의 합은 620이고, 최솟값은 61이 된다.
 * 
 * # 입력
 * 입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다.
 * M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.  
 * 
 * # 출력
 * M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다. 
 * 단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.  
 * 
 */

/*
 * # 풀이
 * 소수 구하기는 프로그래밍을 처음 배울 때 풀어봤던 문제이기도 하고 예전에 몇 번 풀어봐서 풀이를 떠올리는 것은 어렵지 않았다.
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
 * M 이상 ~ N 이하 범위의 수들을 반복문을 돌리면서 i번째 수가 소수라면 합계에 더해주고 그 중 가장 작은 값도 함께 저장했다. 
 * 입력의 최대값이 10,000이기 때문에 소수를 판별하는 알고리즘은 최대한 빠른 것을 사용했다.
 * 
 * # 결과
 * 시간 : 128 ms, 메모리 : 14208 KB
 * 
 */

import java.io.*;
import java.util.*;

public class Main {
	
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
		
		final int INF = 987654321; // 최소값을 찾기위해 초기값으로 넣어주는 임의의 큰 수
		
		// 입력 시간을 줄이기 위해 버퍼 입력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(bf.readLine());
		int N = Integer.parseInt(bf.readLine());
		
		int sum = 0;
		int minPrimeNum = INF;
		for (int i = M; N >= i; i++)
		{
			if (isPrimeNum(i))
			{
				// 소수라면 합계에 더해주고 그 중 최소값을 찾는다.
				sum += i;
				minPrimeNum = (minPrimeNum > i) ? i : minPrimeNum;
			}
		}
		
		// 합계가 0이면 소수가 없었다는 뜻
		if (0 == sum)
			System.out.println(-1);
		else 
		{
			System.out.println(sum);
			System.out.println(minPrimeNum);
		}
		
	}
	
}
