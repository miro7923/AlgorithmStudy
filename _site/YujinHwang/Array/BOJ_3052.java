/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/3052
 * 
 * # 문제
 * 두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지 이다. 예를 들어, 7, 14, 27, 38을 3으로 나눈 나머지는 1, 2, 0, 2이다. 
 * 수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다. 그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 128 MB
 * 
 * # 입력
 * 첫째 줄부터 열번째 줄 까지 숫자가 한 줄에 하나씩 주어진다. 이 숫자는 1,000보다 작거나 같고, 음이 아닌 정수이다.
 * 
 * # 출력
 * 첫째 줄에, 42로 나누었을 때, 서로 다른 나머지가 몇 개 있는지 출력한다.
 * 
 */

/*
 * # 풀이
 * 이 문제를 풀기 위해서는 주어지는 숫자들을 42로 나눴을 때 생기는 나머지가 어떤 숫자들인지 알아야 하고 그것들을 기록해 둘 필요가 있다.
 * 하지만 단순히 기록해 두는 것만으로는 문제를 완벽하게 해결할 수 없고 좀 더 다른 방법을 생각해 봐야 한다.
 * 42로 나눴을 때 얻을 수 있는 나머지는 0~41 사이의 숫자들이다. 
 * 그렇다면 42의 길이를 가진 배열을 만들어서 어떤 숫자를 42로 나눈 나머지를 인덱스 번호로 가진 칸에 그 숫자가 몇 번 나왔는지 저장한다면 
 * 모든 연산이 끝나고 난 뒤 총 몇 개의 나머지가 생겼으며 각각 몇 번 나왔었는지 알 수 있을 것이다. 
 * 배열 인덱스에 저장된 숫자가 0이라면 그 나머지는 한 번도 나오지 않은 것이니 고려할 필요가 없고 0보다 큰 수가 저장된 인덱스가 몇 개인지만 확인하면 이 문제의 정답을 구할 수 있다.
 *  
 */

import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = 10; // 코드의 가독성을 높이고 수정의 용이성을 위해 고정된 값은 상수 선언
	static final int MOD = 42; // 만약 문제가 50으로 나눈 나머지를 구하라고 바뀐다면 여기에 선언된 값만 바꿔주면 되고 코드 전체에 적은 숫자를 바꿔줄 필요가 없어 편하다. 

	public static void main(String[] args) throws IOException {
		
		// 입출력 시간을 줄이기 위해 버퍼 입출력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 1. 입력 받으면서 나머지 연산을 같이 한다. 
		int arr[] = new int[MOD];
		for (int i = 0; MAX > i; i++)
		{
			int n = Integer.parseInt(bf.readLine());
			arr[n % MOD]++; // 해당되는 인덱스의 원소값을 1 증가시킴
		}
		
		// 2. 배열에서 0이 아닌 인덱스의 개수를 센다.
		int ans = 0;
		for (int i = 0; MOD > i; i++)
		{
			if (0 != arr[i]) ans++;
		}
		
		bw.write(Integer.toString(ans));
		
		bw.close();
		
	}
	
}
