import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2447 {

	static char[][] arr;
	
	public static void main(String[] args) throws IOException{
		
		
		/*
		 * 문제 재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형
		 * 모양이다.
		 * 
		 * 크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.
		 ***
		 * 
		 * *
		 ***
		 * N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다.
		 * 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.
		 * 
		 * 입력 첫째 줄에 N이 주어진다. N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3k이며, 이때 1 ≤ k < 8이다.
		 * 
		 * 출력 첫째 줄부터 N번째 줄까지 별을 출력한다.
		 */
		
		
		//풀이 : 기본 3일때 별모양을 만들때 신경써서 만들어서 재귀적으로 호출되게 해보자
		// 3일땐 *이 저모양으로 입력 , 9일땐 3이 저모양으로 입력!
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		
		star(0,0,N,false);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
 
	}
	
	static void star(int x, int y, int N, boolean blank) {
		
		// 중간 공백일때
		if(blank) {
			for (int i = x; i < x + N; i++) {
				for (int j = y; j < y + N; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
		
		// 더 쪼갤 수 없는 블록일 때
		if(N==1) {
			arr[x][y] = '*';
			return;
		}
		
		// N=27일때 한 블록의 사이즈는 9이고
		// N=9 일때 한 블록의 사이즈는 3임
		
		int size = N/3;
		int count = 0;
		for(int i=x; i<x+N; i += size) {
			for(int j=y; j<y+N; j += size) {
				count++;
				if(count == 5) {
					star(i, j, size, true);
					continue;
				} 
				star(i, j, size, false);
				
			}
		}
	}
}
