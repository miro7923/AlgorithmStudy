/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1085
 * 
 * # 제한
 * 시간 제한 : 2초, 메모리 제한 : 128 MB
 * 
 * # 문제
 * 한수는 지금 (x, y)에 있다. 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다. 
 * 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
 * 
 * # 입력
 * 첫째 줄에 x, y, w, h가 주어진다.
 * 1 ≤ w, h ≤ 1,000
 * 1 ≤ x ≤ w-1
 * 1 ≤ y ≤ h-1
 * x, y, w, h는 정수
 * 
 * # 출력
 * 첫째 줄에 문제의 정답을 출력한다.  
 * 
 */

/*
 * # 풀이
 * 예제를 보니까 (x, y)에서 가로와 세로 직선 방향으로 직사각형의 변으로 가면 되는 것이라 
 * x는 x와 w - x 값 중 더 작은 값을, y는 y와 h - y 중 더 작은 값을 찾은 다음에 저 둘 중 더 작은 값을 최종 출력하면 정답인 거 같아서 그대로 썼는데 통과되었다.
 * 
 * # 결과
 * 시간 : 140 ms, 메모리 : 14216 KB
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
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int xMin = (x < (w - x)) ? x : (w - x);
		int yMin = (y < (h - y)) ? y : (h - y);
		int ans = (xMin < yMin) ? xMin : yMin;
		System.out.println(ans);
		
	}
	
}
