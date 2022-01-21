import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_2667 {

	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int cnt = 0; // 총단지수 
	static int addresscnt;
	static int[] address = new int[626]; // 단지내 집의 수, 25x25이므로 최대 626개로 설정
	static int nowX;
	static int nowY;
	
	public static void main(String[] args) throws IOException {

		/*
		 * 
		 * 문제 
		 * 
		 * <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고
		 * 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는
		 * 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를
		 * 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
		 * 
		 * 
		 * 
		 * 입력 
		 * 
		 * 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의
		 * 자료(0혹은 1)가 입력된다.
		 * 
		 * 출력 
		 * 
		 * 첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); // 정사각형 배열설정 n = 5~25
		map = new int[n+1][n+1];
		address = new int[626];
		
		for(int i=0; i<n; i++) // 자료입력
		{
			String s = br.readLine();
			for(int j=0; j<n; j++)
			{
				map[i][j] = s.charAt(j) - '0'; 
			}
		}
		
		
		visited = new boolean[n+1][n+1];
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(map[i][j] > 0 && !visited[i][j])
				{
					dfs(i,j);
					address[cnt] = addresscnt;
					addresscnt = 0; //단지내 집의 수 초기화
					cnt++; // 단지수 계산
				}
			}
		}
		
		Arrays.sort(address); //오름차순정렬
		
		System.out.println(cnt);
		for(int i=address.length-cnt; i<address.length; i++)
		{
			System.out.println(address[i]);
		}
		
	}

	static void dfs(int i, int j)
	{
		visited[i][j] = true;
		Stack<int[]> s = new Stack<int[]>();
		s.add(new int[] {i,j});
		
		while(!s.isEmpty())
		{
			int now[] = s.pop();
			 nowX = now[0];
			 nowY = now[1];
			
			for(int k=0; k<4; k++)
			{
				int nextX = nowX + dx[k];
				int nextY = nowY + dy[k];
				
				if(nextX < 0 || nextY <0 || nextX > n || nextY > n)
					continue;
				if(visited[nextX][nextY] || map[nextX][nextY] == 0)
					continue;
				
				s.add(new int[] {nextX,nextY});
				visited[nextX][nextY] = true;
				addresscnt++;
			}
		}
		addresscnt = addresscnt + 1; 
	}
}
