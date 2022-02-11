/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1259
 * 
 * # 문제
 * 어떤 단어를 뒤에서부터 읽어도 똑같다면 그 단어를 팰린드롬이라고 한다. 'radar', 'sees'는 팰린드롬이다.
 * 
 * 수도 팰린드롬으로 취급할 수 있다. 수의 숫자들을 뒤에서부터 읽어도 같다면 그 수는 팰린드롬수다. 121, 12421 등은 팰린드롬수다. 
 * 123, 1231은 뒤에서부터 읽으면 다르므로 팰린드롬수가 아니다. 
 * 또한 10도 팰린드롬수가 아닌데, 앞에 무의미한 0이 올 수 있다면 010이 되어 팰린드롬수로 취급할 수도 있지만, 
 * 특별히 이번 문제에서는 무의미한 0이 앞에 올 수 없다고 하자. 
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 128 MB
 * 
 * # 입력
 * 입력은 여러 개의 테스트 케이스로 이루어져 있으며, 각 줄마다 1 이상 99999 이하의 정수가 주어진다. 
 * 입력의 마지막 줄에는 0이 주어지며, 이 줄은 문제에 포함되지 않는다.  
 * 
 * # 출력
 * 각 줄마다 주어진 수가 팰린드롬수면 'yes', 아니면 'no'를 출력한다. 
 * 
 */

/*
 * # 풀이
 * 예제의 팰린드롬수를 보면 수의 개수가 짝수개일 땐 절반으로 나눈 앞뒤가 같아야 하고
 * 홀수개일 땐 가운데 숫자를 제외한 나머지 앞뒤가 같아야 한다.
 * 
 * 그래서 반복문으로 반복자는 문자열 길이의 절반까지만 반복하며 
 * 첫 글자와 맨 뒤 글자를 비교하면서 첫 글자를 가리키는 반복자는 증가시키고 끝 글자를 가리키는 반복자는 감소시켜가면서
 * 두 반복자간의 거리를 좁히면서 검사하면 해당 수가 팰린드롬인지 아닌지 쉽게 확인할 수 있다.
 * 
 */

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 입출력 시간을 줄이기 위해 버퍼 입출력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = "";
		while (true)
		{
			input = bf.readLine();
			
			if (input.equals("0"))
				break;
			
			int mid = input.length() >> 1; // 배열 길이의 절반을 구하는데 나누기 연산은 느려서 비트연산 씀
										   // 비트를 오른쪽으로 쉬프트하면 2로 나누는 것과 같다.
			int last = input.length() - 1; // 문자열 센터를 기준으로 뒤쪽을 가리킬 포인터. 맨 뒤에서부터 앞으로 한 칸씩 이동한다.
			boolean isPalindrome = true; // 팰린드롬인지 아닌지 확인할 변수
			for (int i = 0; mid > i; i++, last--) // i는 문자열 센터를 기준으로 앞쪽을 가리킬 포인터. 맨 앞에서부터 한 칸씩 뒤로 이동
			{
				 // 앞 글자와 뒷 글자가 같지 않으면 팰린드롬이 아니다. 
				 if (input.charAt(i) != input.charAt(last))
				 {
					 isPalindrome = false;
					 break;
				 }
			}
			
			if (isPalindrome) bw.write("yes\n");
			else bw.write("no\n");
		}
		
		bw.close();
		
	}
	
}
