/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2941
 * 
 * # 문제
 * 예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.
 * 
 * 예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 
 * 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 * dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 128 MB
 * 
 * # 입력
 * 첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
 * 단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다. 
 * 
 * # 출력
 * 입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 * 
 */

/*
 * # 풀이
 * 특정 크로아티아 문자들 ("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=")의 첫글자가 나오면 다음에 연속되는 문자를 검사해서
 * 지정된 크로아티아 문자이면 그 길이만큼 반복문의 반복자를 증가시키고 아니면 반복자를 1씩 증가시키면서 글자수를 셌다.
 * 
 * 이러한 조건문을 작성할 때 처음에는 반복자의 범위에 대한 예외처리를 해주지 않아서 제출하니까 string index out of bounds가 떴다.
 * 배열을 다룰 때엔 항상 인덱스 범위를 잘 지키는 것에 유의하자.
 * 
 */

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 입출력 시간을 줄이기 위해 버퍼 입출력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = bf.readLine();
		int ans = 0; // 정답을 저장할 변수
		boolean pass = false; // 크로아티아 문자가 나왔는지 확인할 변수
		for (int i = 0; input.length() > i;)
		{
			// 최적화에 조금이라도 도움이 되기 위해 계속 사용될 변수는 반복문의 바깥에서 선언함
			pass = false;
			
			// if문보다는 switch로 해당 조건을 바로 찾아가는 것이 더 빠르기 때문에 역시 최적화를 위해 switch 사용
			switch (input.charAt(i))
			{
				case 'c': // 각 조건에 해당하면 크로아티아 문자이므로 길이만큼 i를 증가시키고 크로아티아 문자가 나왔다고 표시한다.
					if (i + 1 < input.length() && ('=' == input.charAt(i + 1) || '-' == input.charAt(i + 1)))
					{
						i += 2;
						pass = true;
					}
					break;
					
				case 'd':
					if (i + 2 < input.length() && 'z' == input.charAt(i + 1) && '=' == input.charAt(i + 2))
					{
						i += 3;
						pass = true;
					}
					else if (i + 1 < input.length() && '-' == input.charAt(i + 1))
					{
						i += 2;
						pass = true;
					}
					break;
					
				case 'l':
					if (i + 1 < input.length() && 'j' == input.charAt(i + 1))
					{
						i += 2;
						pass = true;
					}
					break;
					
				case 'n':
					if (i + 1 < input.length() && 'j' == input.charAt(i + 1))
					{
						i += 2;
						pass = true;
					}
					break;
					
				case 's':
					if (i + 1 < input.length() && '=' == input.charAt(i + 1))
					{
						i += 2;
						pass = true;
					}
					break;
					
				case 'z':
					if (i + 1 < input.length() && '=' == input.charAt(i + 1))
					{
						i += 2;
						pass = true;
					}
					break;
			}
			
			// false라면 크로아티아 문자가 나오지 않았기 때문에 한 글자만 센다.
			if (!pass) i++;
			
			ans++;
		}
		
		bw.write(Integer.toString(ans));
		
		bw.close();
		
	}
	
}
