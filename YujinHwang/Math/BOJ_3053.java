/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/3053
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 128 MB
 * 
 * # 문제
 * 19세기 독일 수학자 헤르만 민코프스키는 비유클리드 기하학 중 택시 기하학을 고안했다.
 * 택시 기하학에서 두 점 T1(x1,y1), T2(x2,y2) 사이의 거리는 다음과 같이 구할 수 있다.
 * D(T1,T2) = |x1-x2| + |y1-y2|
 * 두 점 사이의 거리를 제외한 나머지 정의는 유클리드 기하학에서의 정의와 같다.
 * 따라서 택시 기하학에서 원의 정의는 유클리드 기하학에서 원의 정의와 같다.
 * 원: 평면 상의 어떤 점에서 거리가 일정한 점들의 집합
 * 반지름 R이 주어졌을 때, 유클리드 기하학에서 원의 넓이와, 택시 기하학에서 원의 넓이를 구하는 프로그램을 작성하시오.
 * 
 * # 입력
 * 첫째 줄에 반지름 R이 주어진다. R은 10,000보다 작거나 같은 자연수이다.
 * 
 * # 출력
 * 첫째 줄에는 유클리드 기하학에서 반지름이 R인 원의 넓이를, 둘째 줄에는 택시 기하학에서 반지름이 R인 원의 넓이를 출력한다. 정답과의 오차는 0.0001까지 허용한다.  
 * 
 */

/*
 * # 풀이
 * 유클리드 기하학이랑 택시 기하학이 처음 보는 단어여서 이해하는데 시간이 좀 걸렸는데 
 * 유클리드 기하학은 학교 다닐 때 배웠던 것처럼 반지름 r의 제곱 * 파이(3.14....)였고
 * 택시 기하학은 반지름 r의 제곱 * 2 였다.
 * 저렇게 구현해서 통과했는데 파이는 무한대로 이어지는 값이라서 `Math`에 있는 `PI`를 썼다.
 * 
 * # 결과
 * 시간 : 132 ms, 메모리 : 14556 KB
 * 
 */

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 입력 시간을 줄이기 위해 버퍼 입력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int R = Integer.parseInt(bf.readLine());
		
		double euc = R * R * Math.PI; // 유클리드 기하학에서의 원의 넓이. 반지름 r^2 * PI
		double taxi = R * R * 2.0; // 택시 기하학에서의 원의 넓이. 반지름 r^2 * 2
		System.out.println(String.format("%.6f", euc));
		System.out.println(String.format("%.6f", taxi));
		
	}
	
}
