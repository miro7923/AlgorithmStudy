/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/4153
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 128 MB
 * 
 * # 문제
 * 과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.
 * 
 * # 입력
 * 입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다. 각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다.
 * 
 * # 출력
 * 각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.  
 * 
 */

/*
 * # 풀이
 * 피타고라스의 정리로 풀었는데 예제에는 입력이 오름차순으로만 주어져 있어서 처음엔 (a의 제곱 + b의 제곱 = c의 제곱) 수식을 썼는데 
 * 중간에 입력이 오름차순으로 들어오지 않는 경우가 있는지 틀렸다.
 * 문제에 오름차순으로 입력이 들어온다는 말이 없어서 예상했긴 하지만... 처음부터 그냥 예외처리 해서 쓸 걸 그랬다.
 * 세 수 중 최대값과 나머지 두 수를 찾아서 피타고라스의 정리 수식을 적용해 주었다.
 * 
 * # 결과
 * 시간 : 124 ms, 메모리 : 14012 KB
 * 
 */

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 입력 시간을 줄이기 위해 버퍼 입력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		while (true)
		{
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (0 == a && 0 == b && 0 == c)
				break;
			
			// 입력이 항상 오름차순으로 들어온다는 말이 없기 때문에 정렬을 해 줘야 함
			int max = 0;
			int num1, num2;
			
			// a, b 둘 중 더 큰 값을 찾고 작은 값은 num1으로 저장
			if (a > b)
			{
				max = a;
				num1 = b;
			}
			else 
			{
				max = b;
				num1 = a;
			}
			
			// 위에서 찾은 최대값과 마지막 c를 비교해서 작은 값은 num2로 저장
			if (max < c)
			{
				num2 = max;
				max = c;
			}
			else 
				num2 = c;
			
			// 피타고라스의 정리
			if ((num1 * num1) + (num2 * num2) == max * max)
				System.out.println("right");
			else 
				System.out.println("wrong");
		}
		
	}
	
}
