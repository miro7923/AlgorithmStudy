/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2908
 * 
 * # 문제
 * 상근이의 동생 상수는 수학을 정말 못한다. 상수는 숫자를 읽는데 문제가 있다. 이렇게 수학을 못하는 상수를 위해서 상근이는 수의 크기를 비교하는 문제를 내주었다. 
 * 상근이는 세 자리 수 두 개를 칠판에 써주었다. 그 다음에 크기가 큰 수를 말해보라고 했다.
 * 상수는 수를 다른 사람과 다르게 거꾸로 읽는다. 예를 들어, 734와 893을 칠판에 적었다면, 상수는 이 수를 437과 398로 읽는다. 
 * 따라서, 상수는 두 수중 큰 수인 437을 큰 수라고 말할 것이다.
 * 두 수가 주어졌을 때, 상수의 대답을 출력하는 프로그램을 작성하시오.  
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 128 MB
 * 
 * # 입력
 * 첫째 줄에 상근이가 칠판에 적은 두 수 A와 B가 주어진다. 두 수는 같지 않은 세 자리 수이며, 0이 포함되어 있지 않다. 
 * 
 * # 출력
 * 첫째 줄에 상수의 대답을 출력한다.
 * 
 */

/*
 * # 풀이
 * 입력으로 주어지는 숫자들을 % 연산을 이용해 뒤집은 다음 뒤집은 수들을 비교한 뒤 큰 값을 출력한다.
 * 
 * 버퍼입출력을 이용해 출력할 때 주의점은 정수형은 string으로 타입캐스팅을 해 주어야 제대로 출력된다.
 * 
 */

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 입출력 시간을 줄이기 위해 버퍼 입출력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken()); // 입력으로 주어지는 수들
		
		int reverseA = 0, reverseB = 0; // 뒤집은 수를 저장할 변수들
		for (int i = 0; 3 > i; i++)
		{
			reverseA += (A % 10); // 원본에서 10으로 나눈 나머지를 다른 변수에 더한 다음
			reverseA *= 10; // 10으로 나눈 나머지에 10을 곱해주면 자리수를 증가시킬 수 있다.
			A /= 10; // 원본을 10으로 나눈 몫만 남기면 마지막 자리는 버릴 수 있다. 이걸 원본이 0이 될 때까지 반복하면 수를 뒤집을 수 있다.
			
			reverseB += (B % 10);
			reverseB *= 10;
			B /= 10;
		}
		
		// 위의 반복문을 통해 뒤집기 연산이 끝나고 나면 뒤집은 수들은 원래 수보다 한 자리수가 많은 상태이다.
		// 때문에 10으로 한 번 나눠준다.
		reverseA /= 10;
		reverseB /= 10;
		
		// 둘 중 더 큰 수를 찾는다.
		int ans = (reverseA > reverseB) ? reverseA : reverseB;
		bw.write(Integer.toString(ans)); // BufferedWriter를 이용해 정수를 출력할 때엔 문자열로 바꿔준다.
		
		bw.close();
		
	}
	
}
