/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2675
 * 
 * # 문제
 * 문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오. 
 * 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.
 * QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.  
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 128 MB
 * 
 * # 입력
 * 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다. 
 * S의 길이는 적어도 1이며, 20글자를 넘지 않는다. 
 * 
 * # 출력
 * 각 테스트 케이스에 대해 P를 출력한다.
 * 
 */

/*
 * # 풀이
 * 반복 횟수와 문자열을 차례로 입력받은 다음 문자열의 길이만큼 반복하는 반복문 안에서 반복 횟수만큼 반복하는 반복문을 이용해 
 * 최종 결과값을 저장할 변수에 차례로 더해준 다음 출력한다.
 * 
 */

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 입출력 시간을 줄이기 위해 버퍼 입출력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(bf.readLine());
		for (int testCase = 0; T > testCase; testCase++)
		{
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int R = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			
			String ans = "";
			for (int i = 0; S.length() > i; i++)
			{
				for (int j = 0; R > j; j++)
					ans += S.charAt(i);
			}

			bw.write(ans + "\n");
		}
		
		bw.close();
		
	}
	
}
