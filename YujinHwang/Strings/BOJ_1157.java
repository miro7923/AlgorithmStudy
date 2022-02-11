/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1157
 * 
 * # 문제
 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.  
 * 
 * # 제한
 * 시간 제한 : 2초, 메모리 제한 : 128 MB
 * 
 * # 입력
 * 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다. 
 * 
 * # 출력
 * 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 * 
 */

/*
 * # 풀이
 * 알파벳 대문자 개수만큼(26) 길이를 가진 배열을 만들어 알파벳 순서대로 각 알파벳이 쓰인 횟수를 기록한다.
 * 알파벳 대문자와 소문자의 아스키코드값이 다르기 때문에 대문자가 입력된 경우와 소문자가 입력된 경우를 나눠서 인덱스값을 계산한 후 횟수를 기록한다.
 * 그 다음 횟수를 기록한 배열을 순회하며 최대값과 가장 많이 쓰인 알파벳을 찾은 다음
 * 횟수를 기록한 배열을 한 번 더 순회하며 최대값과 같은 횟수로 쓰인 또다른 알파벳이 있는지 확인한다.
 * 
 */

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 입출력 시간을 줄이기 위해 버퍼 입출력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = bf.readLine();
		int alphabet[] = new int[26];
		for (int i = 0; input.length() > i; i++)
		{
			int idx = 0;
			// 대문자와 소문자의 아스키코드값이 다르기 때문에 각각 나눠서 인덱스를 계산한다.
			if ('A' <= input.charAt(i) && 'Z' >= input.charAt(i))
				idx = input.charAt(i) - 'A';
			else 
				idx = input.charAt(i) - 'a';
			
			alphabet[idx]++; // 해당 순서 알파벳이 쓰인 횟수 증가
		}
		
		int cnt = 0;
		char ans = 0;
		for (int i = 0; alphabet.length > i; i++)
		{
			// 최대값과 가장 많이 쓰인 알파벳을 찾는다.
			if (cnt < alphabet[i])
			{
				cnt = alphabet[i];
				ans = (char) (i + 'A');
			}
		}
		
		for (int i = 0; alphabet.length > i; i++)
		{
			// 최대값과 같은 횟수만큼 쓰였는데 현재 가장 많이 쓰인 알파벳과 다르다면 가장 많이 쓰인 알파벳이 여러개임
			if (cnt == alphabet[i] && ans != (char)(i + 'A'))
				ans = '?';
		}
		
		bw.write(ans);
		
		bw.close();
		
	}
	
}
