/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/5622
 * 
 * # 문제
 * 상근이의 할머니는 아래 그림과 같이 오래된 다이얼 전화기를 사용한다.
 * 전화를 걸고 싶은 번호가 있다면, 숫자를 하나를 누른 다음에 금속 핀이 있는 곳 까지 시계방향으로 돌려야 한다. 
 * 숫자를 하나 누르면 다이얼이 처음 위치로 돌아가고, 다음 숫자를 누르려면 다이얼을 처음 위치에서 다시 돌려야 한다.
 * 
 * 숫자 1을 걸려면 총 2초가 필요하다. 1보다 큰 수를 거는데 걸리는 시간은 이보다 더 걸리며, 한 칸 옆에 있는 숫자를 걸기 위해선 1초씩 더 걸린다.
 * 상근이의 할머니는 전화 번호를 각 숫자에 해당하는 문자로 외운다. 즉, 어떤 단어를 걸 때, 각 알파벳에 해당하는 숫자를 걸면 된다. 
 * 예를 들어, UNUCIC는 868242와 같다.
 * 
 * 할머니가 외운 단어가 주어졌을 때, 이 전화를 걸기 위해서 필요한 최소 시간을 구하는 프로그램을 작성하시오.  
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 128 MB
 * 
 * # 입력
 * 첫째 줄에 알파벳 대문자로 이루어진 단어가 주어진다. 단어의 길이는 2보다 크거나 같고, 15보다 작거나 같다. 
 * 
 * # 출력
 * 첫째 줄에 다이얼을 걸기 위해서 필요한 최소 시간을 출력한다.
 * 
 */

/*
 * # 풀이
 * 다소 하드코딩으로 풀었는데...
 * 1~9까지 돌리는데 걸리는 최소 시간을 배열에 저장한 다음에 각 문자의 범위별로 인덱스값을 정해주어 시간을 저장한 배열에서 시간을 가져와서 더해주었다.
 * 
 */

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 입출력 시간을 줄이기 위해 버퍼 입출력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int time[] = {2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		String str = bf.readLine();
		int ans = 0;
		for (int i = 0; str.length() > i; i++)
		{
			int idx = 0;
			if ('A' <= str.charAt(i) && 'C' >= str.charAt(i))
				idx = 1;
			else if ('D' <= str.charAt(i) && 'F' >= str.charAt(i))
				idx = 2;
			else if ('G' <= str.charAt(i) && 'I' >= str.charAt(i))
				idx = 3;
			else if ('J' <= str.charAt(i) && 'L' >= str.charAt(i))
				idx = 4;
			else if ('M' <= str.charAt(i) && 'O' >= str.charAt(i))
				idx = 5;
			else if ('P' <= str.charAt(i) && 'S' >= str.charAt(i))
				idx = 6;
			else if ('T' <= str.charAt(i) && 'V' >= str.charAt(i))
				idx = 7;
			else if ('W' <= str.charAt(i) && 'Z' >= str.charAt(i))
				idx = 8;
			
			ans += time[idx];
		}
		
		bw.write(Integer.toString(ans));
		
		bw.close();
		
	}
	
}
