/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/5430
 * 
 * # 문제
 * 선영이는 주말에 할 일이 없어서 새로운 언어 AC를 만들었다. AC는 정수 배열에 연산을 하기 위해 만든 언어이다. 
 * 이 언어에는 두 가지 함수 R(뒤집기)과 D(버리기)가 있다.
 * 
 * 함수 R은 배열에 있는 수의 순서를 뒤집는 함수이고, D는 첫 번째 수를 버리는 함수이다. 배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다.
 * 
 * 함수는 조합해서 한 번에 사용할 수 있다. 예를 들어, "AB"는 A를 수행한 다음에 바로 이어서 B를 수행하는 함수이다. 
 * 예를 들어, "RDD"는 배열을 뒤집은 다음 처음 두 수를 버리는 함수이다.
 * 
 * 배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램을 작성하시오. 
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 256 MB
 * 
 * # 입력
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다. T는 최대 100이다.
 * 
 * 각 테스트 케이스의 첫째 줄에는 수행할 함수 p가 주어진다. p의 길이는 1보다 크거나 같고, 100,000보다 작거나 같다.
 * 
 * 다음 줄에는 배열에 들어있는 수의 개수 n이 주어진다. (0 ≤ n ≤ 100,000)
 * 
 * 다음 줄에는 [x1,...,xn]과 같은 형태로 배열에 들어있는 정수가 주어진다. (1 ≤ xi ≤ 100)
 * 
 * 전체 테스트 케이스에 주어지는 p의 길이의 합과 n의 합은 70만을 넘지 않는다.  
 * 
 * # 출력
 * 각 테스트 케이스에 대해서, 입력으로 주어진 정수 배열에 함수를 수행한 결과를 출력한다. 만약, 에러가 발생한 경우에는 error를 출력한다. 
 * 
 */

/*
 * # 풀이
 * 처음엔 스택과 큐를 이용해서
 * 큐에 원래 순서대로 숫자를 집어넣고 뒤집어야 하면 스택에 push했다가 다시 큐로 pop 하는 방식을 썼는데 수의 최대 개수가 10만개라 예상대로 시간초과가 발생했다.
 * 
 * 그래서 질문게시판을 찾아보다 덱을 사용하는 것을 보고 컨테이너를 덱으로 바꿨다.
 * 
 * 그리고 R 연산이 짝수번이면 뒤집었다 다시 뒤집는 것이기 때문에 결국 뒤집지 않은 것이랑 같다.
 * 그래서 연속된 R의 개수를 세어서 홀수번이면 덱의 맨 뒤에서 D 연산을 수행하고
 * 연속된 R이 짝수번이면 맨 앞에서 D 연산을 수행하도록 하였다.
 * 
 * 그 후 뒤집힌 상태라면 덱의 맨 뒤에서부터 pop연산을 수행하고
 * 뒤집히지 않았다면 덱의 맨 앞에서부터 pop연산을 수행했다.
 * 
 * 하지만 덱에 들어있는 숫자들을 정답 형태로 만들 때 단순 string에 더하는 형태로 만들었더니 가비지 컬렉션이 많이 발생해서...
 * 거기서 최적화가 되지 않아서 또 시간초과를 받았다.
 * 
 * 그래서 StringBuilder로 바꾼 뒤 정답 형태의 문자열로 만드는 부분을 좀 더 최적화 해 주었더니 932ms에 통과할 수 있었다...
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
		String func = "";
		int n = 0;
		Deque<Integer> dq = new ArrayDeque<>(); // 입력으로 주어지는 숫자들을 저장할 덱
		
		for (int tc = 0; T > tc; tc++)
		{
			func = bf.readLine();
			n = Integer.parseInt(bf.readLine());
			
			// 1. 문자열 형태 숫자 배열을 변환해서 int 배열에 넣기
			String nums = bf.readLine();
			for (int i = 1; nums.length() - 1 > i; i++)
			{
				if (',' != nums.charAt(i) && ']' != nums.charAt(i))
				{
					int num = 0;
					for (int j = i; ; j++)
					{
						if (',' == nums.charAt(j) || ']' == nums.charAt(j))
							break;
						
						num += nums.charAt(j) - '0';
						num *= 10;
						i++;
					}
					
					i--;
					num /= 10;
					dq.addLast(num); // 문자열 숫자 -> 정수형 숫자로 변경
				}
			}
			
			// 2. 입력 함수에 따라 연산하기
			// R : 배열 뒤집기
			// D : 첫번째 숫자 버리기
			boolean reverse = false;
			boolean error = false;
			int len = func.length();
			StringBuilder sb = new StringBuilder(); // 정렬된 배열을 정답 형태로 저장할 문자열
			for (int i = 0; len > i; i++)
			{
				// 현재 뒤집기 연산일 때
				if ('R' == func.charAt(i))
				{
					// 뒤에 문자가 더 있고
					if (func.length() - 1 > i)
					{
						// 연속된 문자도 뒤집기 연산이면 
						if ('R' == func.charAt(i + 1))
						{
							// 현재 연산이 R 이니까 뒤집어야 한다고 표시한 후
							reverse = !reverse;
							// 다음 문자의 다음에도 R이 연속되어 있는지 확인해봐야 하니까 아래 구문들의 실행을 건너뛴다.
							continue;
						}
						else // 연속된 문자가 뒤집기 연산이 아니면 뒤집어야 한다고 표시하고 다음 연산을 탐색하러 간다.
							reverse = !reverse;
					}
					else // 마지막 문자인데 R이면 역시 뒤집어야 하니까 뒤집기 표시
						reverse = !reverse;
				}
				else // D 연산일 때
				{
					// 뒤집어야 하면 뒤에서 pop 연산 수행
					if (reverse && !dq.isEmpty())
						dq.removeLast();
					else if (!reverse && !dq.isEmpty()) // 안 뒤집으면 앞에서 pop연산 수행
						dq.removeFirst();
					else 
					{
						// 덱이 비었으면 에러 출력
						error = true;
						break; // 탐색 중단하고 반복문 탈출
					}
				}
			}
			
			if (!error)
			{
				// 뒤집기 상태에 따라 뒤에서 혹은 앞에서부터 pop 연산을 수행하며 정답 문자열에 합쳐준 후
				sb.append('[');
				if (reverse)
				{
					while (!dq.isEmpty())
					{
						sb.append(dq.removeLast());
						sb.append(',');
					}
				}
				else 
				{
					while (!dq.isEmpty())
					{
						sb.append(dq.removeFirst());
						sb.append(',');
					}
				}

				// 위 반복문의 구조상 마지막 문자는 ',' 이 된다.
				// 하지만 숫자 배열의 길이 자체가 0이고 D 연산을 수행하지 않은 경우에는 []을 출력해야 하기 때문에
				// 맨 마지막 문자를 확인한 후 ']'으로 교체하거나 덧붙여준다.
				int last = sb.length() - 1;
				if (',' == sb.charAt(last))
					sb.setCharAt(last, ']');
				else 
					sb.append(']');
				
				bw.write(sb + "\n");
			}
			else
				bw.write("error\n");
			
			bw.flush();
		}
		
		bw.close();
		
	}
	
}
