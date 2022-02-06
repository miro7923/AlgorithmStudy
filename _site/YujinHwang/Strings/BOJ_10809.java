/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/10809
 * 
 * # 문제
 * 알파벳 소문자로만 이루어진 단어 S가 주어진다. 
 * 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.  
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 256 MB
 * 
 * # 입력
 * 첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
 * 
 * # 출력
 * 각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치, ... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.
 * 만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다. 단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.
 * 
 */

/*
 * # 풀이
 * 알파벳의 길이와 같은 배열을 만들어 각 알파벳별로 처음 나오는 인덱스를 기록하면 된다는 아이디어로 코드를 짰다.
 * 
 * 알파벳은 대소문자 각각 26개씩 있는데 문제에서는 소문자만 주어진다고 했으므로 소문자가 처음으로 나오는 순서를 기록할 배열을 26 크기로 만든다.
 * 이 때 알파벳이 주어지는 단어에 포함되어 있지 않으면 -1을 출력하라고 했으므로 배열의 원소들을 -1로 초기화한다.
 * 그 다음 입력받은 문자열의 0번 인덱스부터 순회하면서 알파벳 배열의 값이 -1인 경우에만(아직 등장하지 않은 것이므로) 원소값을 현재 인덱스값으로 갱신한다.
 * 
 */

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 입출력 시간을 줄이기 위해 버퍼 입출력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = bf.readLine();
		
		int alphabet[] = new int[26]; // 알파벳 소문자 개수 26개
		Arrays.fill(alphabet, -1); // 처음엔 아직 등장하지 않았다는 의미로 -1로 초기화한다.
		
		for (int i = 0; s.length() > i; i++)
		{
			int idx = s.charAt(i) - 'a'; // 각 문자를 int로 타입캐스팅 후
			if (-1 == alphabet[idx]) // 알파벳 배열의 원소가 -1이면 아직 등장하지 않았다는 뜻이기 때문에 현재 문자열의 인덱스로 갱신한다.
				alphabet[idx] = i;
		}
		
		// 알파벳 배열을 순회하면서 하나씩 출력
		for (int i = 0; alphabet.length > i; i++)
			bw.write(alphabet[i] + " ");
		
		bw.close();
		
	}
	
}
