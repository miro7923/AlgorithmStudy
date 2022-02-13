/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1929
 * 
 * # 제한
 * 시간 제한 : 2초, 메모리 제한 : 256 MB
 * 
 * # 문제
 * M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
 * 
 * # 입력
 * 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.  
 * 
 * # 출력
 * 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.  
 * 
 */

/*
 * # 풀이
 * M이상 N이하의 수들을 소수를 판별하는 연산을 해서 소수면 출력했다.
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
 * 시간 : 1128 ms, 메모리 : 29424 KB
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
		
		// 입력 시간을 줄이기 위해 버퍼 입력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		for (int i = M; N >= i; i++)
		{
			if (isPrimeNum(i))
				System.out.println(i);
		}
		
	}
	
}
