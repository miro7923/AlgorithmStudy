/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/10757
 * 
 * # 문제
 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 256 MB
 * 
 * # 입력
 * 첫째 줄에 A와 B가 주어진다. (0 < A,B < 1010000)  
 * 
 * # 출력
 * 첫째 줄에 A+B를 출력한다.  
 * 
 */

/*
 * # 풀이
 * 브론즈5였는데 브론즈가 아닌데...ㅠ
 * c/c++로만 푸는 같은 문제도 있는데 그건 난이도가 실버3인거 보니까 어려운 문제가 맞는거 같다.
 * 쉽게 책정된 이유는 파이썬은 그냥 계산해줘서 그렇다고 하는데... 정말 쉽지 않은 문제였다 ㅠㅠ
 * 풀이와 코드의 흐름 자체는 비교적 빨리 생각해 냈지만 자잘한 예외 케이스에 걸려서 많이 틀렸다.
 * 
 * 입력으로 들어오는 A, B는 long형을 써도 표현범위를 초과하기 때문에 정수를 저장하는 자료형으로 연산을 할 수 없고 다른 방법으로 해결해야 한다.
 * c/c++이었으면 unsigned long long형으로 해결할 수도 있다는 글을 봤는데 자바에는 없는 것 같다. 
 * 자바는 부호가 있는 정수만 저장할 수 있나?
 * 
 * 그래서 입력으로 들어오는 숫자를 문자열로 받은 뒤 두 문자열의 맨 뒤에서부터 앞으로 이동하면서 두 수를 int형으로 바꿔 더한 뒤
 * 계산한 수를 다시 char로 바꿔 스택에 저장하고 만약 10이 넘어가면 다음 자리수를 계산할 때 계산 결과에 1을 더해주도록 했다.
 * 
 * 그리고 두 문자열의 길이가 다를 수 있기 때문에 두 문자열 중 더 짧은 문자열의 길이만큼만 위 연산을 하고
 * 만약 다음 자리수에 1을 더해줘야 한다면 남은 숫자들 중 마지막 자리수에 1을 더해주고 스택에 넣고
 * 더 긴 문자열의 앞에 계산되지 않고 남은 숫자들을 정답 문자열 변수에 넣어준 다음
 * 아까 더한 숫자들을 저장해 놓은 스택에서 하나씩 꺼내서 합쳐주었다. 
 * 
 * 자세한 것은 코드 옆 주석에...
 * 
 * # 결과
 * 시간 : 164 ms, 메모리 : 15160 KB
 * 
 */

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 입력 시간을 줄이기 위해 버퍼 입력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// 문자열로 연산해서 출력해야 함
		String A = st.nextToken();
		String B = st.nextToken();
		
		// 둘 중 더 짧은 길이 구하기
		int aIdx = A.length() - 1;
		int bIdx = B.length() - 1; // A와 B의 마지막 인덱스
		
		int a, b, sum; // 한 문자씩 정수로 변환한 값을 저장할 변수, 두 수의 합
		boolean add = false; // 다음 자리수에 1을 더해줘야 할지 말지 확인하는 변수
		Stack<Character> s = new Stack<Character>(); // 계산한 문자 넣었다가 꺼낼 것임
		
		// 뒤에서부터 한 글자씩 떼어서 int로 바꿔서 더한 다음 스택에 char로 바꿔서 넣는다.
		while (0 <= aIdx && 0 <= bIdx)
		{
			a = A.charAt(aIdx--) - '0';
			b = B.charAt(bIdx--) - '0';
			sum = a + b;
			
			if (add) // 1을 더해줘야 하면 계산 결과에 1을 더한다.
				sum++;
			
			// 계산 결과가 10보다 크거나 같으면 
			if (10 <= sum)
			{
				// 계산 결과의 나머지만 남기고 1을 더해야 한다고 표시한다.
				sum %= 10;
				add = true;
			}
			else // 아니면 더할 필요 없다고 표시
				add = false;
			
			char c = (char) (sum + '0');
			s.push(c);
		}
		
		// 중복 코드 좀 줄여보려고 임시 변수 사용
		// 둘 중 더 긴 문자열을 저장한다.
		String tmpStr;
		int leftIdx, tmpInt;
		if (aIdx > bIdx)
		{
			tmpStr = A;
			leftIdx = aIdx;
		}
		else 
		{
			tmpStr = B;
			leftIdx = bIdx;
		}
		
		// 더 긴 문자열의 남은 숫자들에 대해서 위의 연산을 한다.
		while (add && 0 <= leftIdx)
		{
			tmpInt = tmpStr.charAt(leftIdx--) - '0';
			tmpInt++;
			if (10 <= tmpInt)
			{
				tmpInt %= 10;
				add = true;
			}
			else 
				add = false;
			
			s.push((char)(tmpInt + '0'));
		}
		
		// 위 연산이 끝나고 나와서 마지막으로 1을 또 더해줘야 하면 추가해줌
		if (add)
			s.push((char)(1 + '0'));
		
		StringBuilder ans = new StringBuilder();

		// 위 과정을 끝내고 와서 더 긴 문자열에 문자열이 남아있다면 계산할 필요가 없으니까 그냥 떼서 정답에 넣는다.
		if (0 <= leftIdx)
			ans.append(tmpStr, 0, leftIdx + 1);
		
		// 스택에서 숫자를 하나씩 꺼내서 문자열로 합침
		while (!s.empty())
		{
			ans.append(s.peek());
			s.pop();
		}
		
		System.out.println(ans);
		
	}
	
}
