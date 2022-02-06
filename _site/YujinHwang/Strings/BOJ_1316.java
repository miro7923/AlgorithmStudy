/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1316
 * 
 * # 문제
 * 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 
 * 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, 
 * aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
 * 
 * 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
 * 
 * # 제한
 * 시간 제한 : 2초, 메모리 제한 : 128 MB
 * 
 * # 입력
 * 첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다. 
 * 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다. 
 * 
 * # 출력
 * 첫째 줄에 그룹 단어의 개수를 출력한다.
 * 
 */

/*
 * # 풀이
 * 문제 이해가 잘 되지 않아서 질문게시판의 문제 해설을 참고했다.
 * 
 * 1. 현재 문자가 이미 나온 적이 있고
 * 2. 바로 이전 문자가 아니면
 * -> 그 단어는 그룹 단어가 아니다.
 * 
 * 이 흐름에 따라 알파벳이 등장했는지 확인할 boolean 배열을 만들어 알파벳이 이전에 나왔는지 확인한 후
 * 나온 적이 없고 바로 앞 문자와 같으면 그룹단어로 카운트하였고
 * 나온 적이 있는데 바로 앞 문자와 같지 않으면 더 이상 확인을 중단하고 다음 문자를 확인하는 방식으로 코드를 짰다.
 * 
 */

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 입출력 시간을 줄이기 위해 버퍼 입출력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean alphabet[]; // 알파벳이 등장했는지 체크할 배열
		
		int N = Integer.parseInt(bf.readLine());
		
		int ans = 0;
		boolean groupWord = true; // 해당 단어가 그룹단어인지 확인할 변수
		for (int i = 0; N > i; i++)
		{
			int idx = 0;
			groupWord = true;
			alphabet = new boolean[26]; // 매 단어마다 알파벳 등장 확인을 새로 해야하기 때문에 새로운 단어를 입력받기 전에 초기화해준다.
			String input = bf.readLine();
			for (int j = 0; input.length() > j; j++)
			{
				idx = input.charAt(j) - 'a'; // char에서 아스키코드 상에서의 시작문자를 빼면 int로 타입캐스팅 할 수 있다.
				
				// 두번째 문자부터 비교를 시작할 수 있도록 조건을 걸어준 다음
				// 이미 나온 문자인데 앞 문자와 다르면 그룹단어가 아닌 것으로 간주하고 반복문을 탈출한다.
				if (0 < j && alphabet[idx] && input.charAt(j) != input.charAt(j - 1))
				{
					groupWord = false;
					break;
				}
				
				// 알파벳 등장 표시
				if (!alphabet[idx]) alphabet[idx] = true;
			}
			
			// 그룹단어일 때만 정답 카운트를 증가시킨다.
			if (groupWord) ans++;
		}
		
		bw.write(Integer.toString(ans));
		
		bw.close();
		
	}
	
}
