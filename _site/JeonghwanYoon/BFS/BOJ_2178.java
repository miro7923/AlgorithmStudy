import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
	
	static int n;
	static int m;
	static int v;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		
		for(int i=0; i<n; i++)
		{
			String temp = br.readLine();
			for(int j=0; j<m; j++)
			{
				map[i][j] = temp.charAt(j) - '0';
			}
		}
		
		visited = new boolean[n+1][m+1];
		visited[0][0] = true;
		bfs();
		
		System.out.println(map[n-1][m-1]);
	}
	
	public static void bfs()
	{
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0});
		
		while(!q.isEmpty())
		{
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			for(int i=0; i<4; i++)
			{
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) // 미로를 넘어가는것 방지
					continue;
				if(visited[nextX][nextY] || map[nextX][nextY] == 0) //방문한적 있거나 못가는곳(0인값)일 경우 방지
					continue;
				
				q.offer(new int[] {nextX,nextY});
				visited[nextX][nextY] = true;
				map[nextX][nextY] = map[nowX][nowY] + 1;
			}
		}
	}
}
