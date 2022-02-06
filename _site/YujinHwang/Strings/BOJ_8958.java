/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/8958
 * 
 * # 문제
 * "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 
 * 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.

 * "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.

 * OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.


 * 
 * # 제한
 * 시간제한: 1초 / 메모리 제한: 128 MB
 * 
 * # 입력
 * 첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 0보다 크고 80보다 작은 문자열이 주어진다. 문자열은 O와 X만으로 이루어져 있다.
 * 
 * # 출력
 * 각 테스트 케이스마다 점수를 출력한다.
 * 
 */

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		
		int score = 0; // 연속된 'O'의 개수에 따라 누적 증가시켜서 더해줄 점수
		
		int answer = 0; // 최종 점수
		
		for (int i = 0; T > i; i++)
		{
			String input = s.next(); // 한 라인씩 입력받기
			
			for (int j = 0; input.length() > j; j++)
			{
				// 'O'가 계속해서 나오면 1점씩 증가시켜서 최종 점수에 더해줌
				if ('O' == input.charAt(j)) 
					answer += ++score;
				else // 'X'가 나오면 누적증가 중단하고 다시 0으로 초기화
					score = 0;
			}
			
			System.out.println(answer);
			
			// 다음 테스트케이스 진행을 위해서 점수 변수들 초기화
			answer = 0;
			score = 0;
		}

	}

}
