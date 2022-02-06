import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1316 {

	public static void main(String[] args) throws IOException{
		
		/*
		 * 문제 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 예를 들면, ccazzzzbb는 c,
		 * a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가
		 * 떨어져서 나타나기 때문에 그룹 단어가 아니다.
		 * 
		 * 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
		 * 
		 * 입력 첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는
		 * 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
		 * 
		 * 출력 첫째 줄에 그룹 단어의 개수를 출력한다.
		 */
		
		// 풀이 : 입력받은 단어의 다음단어가 자신과 같으면 통과 다를경우 앞인덱스와 확인해서 같은단어 있으면 반복종료 없으면 통과
		// 알파벳 소문자로만 들어오므로 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] st = new String[N];
		int cnt = 0;
		
		for(int i=0; i<N; i++) { // 문자 입력
			st[i] = br.readLine();
		}
		
		for(int i=0; i<N; i++) { // 각단어 체크
			
			if(st[i].length() == 1) { // 1개일경우 무조건 그룹단어이므로
				cnt++;
				continue;
			}
			
			loop:
			for(int j=1; j<st[i].length(); j++) {
				
				if(st[i].charAt(j) == st[i].charAt(j-1)) { // 현재 알파벳이 이전 알파벳과 같으면 통과
				}
					
				else {
					for(int k=0; k<j-1; k++) {
						if(st[i].charAt(j) == st[i].charAt(k)) { // 중복알파벳이 있는경우 그룹 단어가 아니므로 반복종료
							break loop;
						}
					}
				}
				
				if(j == st[i].length()-1) // 마지막까지 문제없으면 그룹 단어이므로 cnt 증가
					cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
