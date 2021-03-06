/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1002
 * 
 * # 제한
 * 시간 제한 : 2초, 메모리 제한 : 128 MB
 * 
 * # 문제
 * 조규현과 백승환은 터렛에 근무하는 직원이다. 하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다. 다음은 조규현과 백승환의 사진이다.
 * 이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다. 
 * 조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.
 * 조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고, 조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때, 
 * 류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.
 * 
 * # 입력
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 이루어져 있다.
 * 한 줄에 x1, y1, r1, x2, y2, r2가 주어진다. x1, y1, x2, y2는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이고, 
 * r1, r2는 10,000보다 작거나 같은 자연수이다.
 * 
 * # 출력
 * 각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다. 만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.  
 * 
 */

/*
 * # 풀이
 * 처음엔 무슨 문제인가 싶어서 질문게시판을 보니까 두 원 사이의 접점을 구하는 문제였다.
 * 두 원의 관계는 내접하는 경우, 외접하는 경우, 만나지 않는 경우, 겹쳐지는 경우가 있는데
 * 내접과 외접하는 경우에는 접점이 1개이다. (원 그려보면 됨)
 * 만나지 않는 경우에는 접점이 0이다. 이 땐 서로 멀리 떨어져 있거나 큰 원 안에 작은 원이 있는데 두 원 사이의 접점이 없는 경우이다.
 * 겹쳐지는 경우에는 완전히 똑같이 겹쳐지느냐 조금 겹쳐지느냐에 따라 달라지는데
 * 원점의 위치가 똑같고 반지름도 똑같으면 완전히 겹쳐진다. 이럴 때엔 원의 테두리 어디에든 존재할 수 있으니 무한대이다.
 * 조금 겹쳐지는 경우엔 접점이 항상 2개이다. (이것도 원 그려보면 됨)
 * 
 * 원이 서로 내접하는지 아닌지 보려면 두 원점 사이의 거리를 구해야 하는데 이것은 피타고라스의 정리로 구했다.
 * 그런데 피타고라스의 정리를 사용하면 거리는 원래 거리의 제곱값이 나오기 때문에 이것의 제곱근을 구하기 위해 sqrt 함수를 사용했는데 여기서 오차가 생겨서 틀렸다.
 * 4의 제곱근을 구하는 경우라면 문제 없지만 5의 제곱근을 구하는 경우에는 정수로 나눠 떨어지지 않으니까... 여기서 오차가 생긴다.
 * 그래서 두 원점 사이의 거리는 제곱한 상태로 사용해야 한다.
 * 
 * 그래서 위의 케이스들을 잘 나눠서 분기처리를 해주면 되는데 처음에는 내접하는 경우와 큰 원 안에 작은 원이 있는데 접점이 없는 경우를 생각하지 못해서 틀렸다.
 * 처음에는 두 원점 사이의 거리와 두 반지름의 합만을 이용해서 연산을 했기 때문에 내접하거나 큰 원 안에 작은 원이 있는제 접점이 없는 경우를 처리할 수 없었다.
 * (다 귀찮아서 원을 안 그려봐서 생긴 일...)
 * 그래서 또 질문게시판을 참고해서 원을 그려보니까 두 반지름의 차도 이용을 해야 완벽하게 답을 구할 수 있다는 것을 알게 되었다.
 * 두 원점 사이의 거리와 두 반지름의 차가 같으면 내접하고 (거리와 합이 같으면 외접)
 * 두 원점 사이의 거리가 두 반지름의 차보다 작으면 큰 원 안의 작은 원이 접점이 없는 경우였다. (합보다 작으면 서로 겹침)
 * => 이거 해결하고 통과했다.
 * 
 * 그래서 최종적인 분기처리는 
 * 1. 두 원의 원점이 같고 반지름도 같으면 -1
 * 2. 원점이 같지만 반지름이 다르면 -1
 * 3. 거리의 제곱이 반지름 합의 제곱과 같거나 반지름 차의 제곱과 같으면 1
 * 4. 거리의 제곱이 반지름 합의 제곱보다 크거나 반지름 차의 제곱보다 작으면 0
 * 5. 나머지 경우는 2
 * 
 * # 결과
 * 시간 : 136 ms, 메모리 : 14292 KB
 * 
 */

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 입력 시간을 줄이기 위해 버퍼 입력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 0; T > tc; tc++)
		{
			// 두 점의 거리의 차의 절대값이 두 원의 반지름을 더한 길이와 같으면 두 원은 닿는다.(두 원이 외접) -> 점 한개
			// 두 원이 내접할 때 -> 점 한개
			// 두 점의 거리의 차의 절대값이 두 원의 반지름을 더한 길이보다 작으면 두 원은 겹친다. -> 점 두개
			// 두 점의 거리의 차의 절대값이 두 원의 반지름을 더한 길이보다 크면 두 원은 겹치지 않는다. -> 점 0
			// 두 점의 거리의 차가 0이면서 반지름이 다르면 같은 점에 있지만 원 전체가 겹치지 않는다. -> 점 0
			// 두 점의 거리의 차가 0이고 반지름도 같으면 같은 점에 있으면서 원 전체가 겹친다. -> 무한대
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			int sumR = (r1 + r2) * (r1 + r2); // 두 원의 반지름의 합의 제곱
			int minusR = (r1 - r2) * (r1 - r2); // 두 원의 반지름의 차의 제곱
			int distX = Math.abs(x2 - x1); // 두 원의 x좌표간 거리의 절대값
			int distY = Math.abs(y2 - y1); // 두 원의 y좌표간 거리의 절대값
			int diff = distX * distX + distY * distY; // 두 원의 중심의 거리를 피타고라스의 정리로 구한 것
			
			int ans = 0;
			// 원점이 같을 때
			if ((x1 == x2) && (y1 == y2))
			{
				if (r1 != r2)
					ans = 0;
				else 
					ans = -1;
			}
			else // 다를 때
			{
				// 외접 혹은 내접
				if (diff == sumR || diff == minusR)
					ans = 1;
				// 서로 멀리 떨어져 있거나 큰 원 안에 작은 원이 접점이 없는 상태
				else if (diff > sumR || diff < minusR)
					ans = 0;
				else // 나머지는 서로 겹침
					ans = 2;
			}
			
			System.out.println(ans);
			
		}
		
	}
	
}
