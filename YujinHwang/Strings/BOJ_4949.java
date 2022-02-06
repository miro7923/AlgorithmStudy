/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/4949
 * 
 * # 문제
 * 세계는 균형이 잘 잡혀있어야 한다. 양과 음, 빛과 어둠 그리고 왼쪽 괄호와 오른쪽 괄호처럼 말이다.
 * 
 * 정민이의 임무는 어떤 문자열이 주어졌을 때, 괄호들의 균형이 잘 맞춰져 있는지 판단하는 프로그램을 짜는 것이다.
 * 
 * 문자열에 포함되는 괄호는 소괄호("()") 와 대괄호("[]")로 2종류이고, 문자열이 균형을 이루는 조건은 아래와 같다.
 * 
 * 모든 왼쪽 소괄호("(")는 오른쪽 소괄호(")")와만 짝을 이뤄야 한다.
 * 모든 왼쪽 대괄호("[")는 오른쪽 대괄호("]")와만 짝을 이뤄야 한다.
 * 모든 오른쪽 괄호들은 자신과 짝을 이룰 수 있는 왼쪽 괄호가 존재한다.
 * 모든 괄호들의 짝은 1:1 매칭만 가능하다. 즉, 괄호 하나가 둘 이상의 괄호와 짝지어지지 않는다.
 * 짝을 이루는 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형이 잡혀야 한다.
 * 
 * 정민이를 도와 문자열이 주어졌을 때 균형잡힌 문자열인지 아닌지를 판단해보자. 
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 128 MB
 * 
 * # 입력
 * 하나 또는 여러줄에 걸쳐서 문자열이 주어진다. 
 * 각 문자열은 영문 알파벳, 공백, 소괄호("( )") 대괄호("[ ]")등으로 이루어져 있으며, 길이는 100글자보다 작거나 같다.
 * 
 * 입력의 종료조건으로 맨 마지막에 점 하나(".")가 들어온다.  
 * 
 * # 출력
 * 각 줄마다 해당 문자열이 균형을 이루고 있으면 "yes"를, 아니면 "no"를 출력한다. 
 * 
 */

/*
 * # 풀이
 * '(', '[' 괄호가 나오면 스택에 넣고 ')', ']' 괄호가 나오면 스택에서 마지막 값을 pop해서 매치되는 괄호면 넘어가고 
 * 매치되지 않으면 오답처리하고 탐색을 중단하고 "no"를 출력하는 방식으로 짰는데...
 * 
 * 문제를 제대로 안 읽어서 소문자 "yes", "no"로 출력해야 할 것을 대문자 "YES", "NO"로 출력해서 20%에서 계속 틀렸다 ㅠ.ㅠ
 * 문제를 제대로 읽자.............. 한시간 버렸다.......
 * 
 */

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 입출력 시간을 줄이기 위해 버퍼 입출력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true)
		{
			String input = bf.readLine();
			
			if (input.equals(".")) break;
			
			boolean isMatched = true; // 괄호가 매치되는지 확인할 변수
			char brakets[] = new char[100]; // 괄호 매칭 확인할 스택
			int braketCnt = 0; // 스택 카운터
			char last = '\0'; // 스택에서 pop한 top을 저장할 변수
			for (int i = 0; input.length() > i; i++)
			{
				switch (input.charAt(i))
				{
					case '[': // 여는 괄호면 스택에 push
						brakets[braketCnt++] = '[';
						break;
						
					case ']': // 닫는 괄호면 스택이 비어있지 않을 때 스택의 top을 pop해서 비교한 뒤 매치되지 않으면 false 처리한다.
						if (0 < braketCnt)
						{
							last = brakets[--braketCnt];
							if ('[' != last) isMatched = false;
						}
						else 
							isMatched = false;
						break;
						
					case '(':
						brakets[braketCnt++] = '(';
						break;
						
					case ')':
						if (0 < braketCnt)
						{
							last = brakets[--braketCnt];
							if ('(' != last) isMatched = false;
						}
						else isMatched = false;
						break;
				}
				
				if (!isMatched) break; // 매치되지 않으면 탐색 종료
			}
			
			// 탐색이 종료됐는데 매치되지 않으면 "no" 출력하고 다음 테스트케이스 진행
			if (!isMatched)
			{
				bw.write("no\n");
				bw.flush();
				continue;
			}
			
			// 매치되는 결과일 때 스택이 비어있으면 모든 괄호가 매치된 것이고
			if (0 == braketCnt) isMatched = true;
			else isMatched = false; // 비어있지 않으면 매치되지 않은 괄호가 남아있는 것이다.
			
			// 스택 검사 결과에 따른 최종 결과값 출력
			if (isMatched) bw.write("yes\n");
			else bw.write("no\n");
			
			bw.flush();
		}
		
		bw.close();
		
	}
	
}
