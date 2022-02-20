/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/3009
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 128 MB
 * 
 * # 문제
 * 세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.
 * 
 * # 입력
 * 세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.
 * 
 * # 출력
 * 직사각형의 네 번째 점의 좌표를 출력한다.  
 * 
 */

/*
 * # 풀이
 * x와 y의 값이 서로 다른 점끼리 더한 값이 같아야 하기 때문에 
 * 입력 받으면서 이전 x와 현재 x의 값이 같지 않으면 두 수를 더해주고 아니라면 수를 보관해 뒀다가 이전 x와 현재 x가 같지 않은 두 수의 합에서 빼 주었다.
 * (x, y 각각 적용)
 * 
 * # 결과
 * 시간 : 148 ms, 메모리 : 16056 KB
 * 
 */

import java.io.*;
import java.util.*;

public class Main {
	
	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {
		
		// 입력 시간을 줄이기 위해 버퍼 입력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int sumX = x, sumY = y, tmpX = 0, tmpY = 0;
		int nextX, nextY;
		boolean doneX = false, doneY = false;
		
		for (int i = 0; 2 > i; i++)
		{
			st = new StringTokenizer(bf.readLine());
			nextX = Integer.parseInt(st.nextToken());
			nextY = Integer.parseInt(st.nextToken());
			if (!doneX && x != nextX)
			{
				// 서로 다른 두 수가 아직 더해지지 않았으면 더해준다.
				sumX += nextX;
				doneX = true;
			}
			else  // 같은 수면 저장만 해 놓는다.
				tmpX = nextX;
			
			if (!doneY && y != nextY)
			{
				sumY += nextY;
				doneY = true;
			}
			else 
				tmpY = nextY;
			
			x = nextX; // 현재 확인중인 점 갱신
			y = nextY;
		}
		
		// 위에서 구한 합계에서 2번 나온 수를 빼주면 된다.
		int X = sumX - tmpX;
		int Y = sumY - tmpY;
		System.out.println(X + " " + Y);
		
	}
	
}
