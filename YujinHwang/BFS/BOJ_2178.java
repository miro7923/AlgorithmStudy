/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2178
 * 
 * # 문제
 * N×M크기의 배열로 표현되는 미로가 있다. 
 * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
 * 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 
 * 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 * 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 192 MB
 * 
 * # 입력
 * 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
 * 
 * # 출력
 * 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
 * 
 */

import java.util.*;

public class Main {
	
	static int N; // 세로
	static int M; // 가로
	static int maze[][]; // 입력으로 주어지는 미로
	static boolean visit[][]; // 방문체크할 배열

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		N = s.nextInt();
		M = s.nextInt();
		
		maze = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; N > i; i++)
		{
			String str = s.next();
			for (int j = 0; str.length() > j; j++)
			{
				if ('1' == str.charAt(j))
					maze[i][j] = 1;
				else 
					maze[i][j] = 0; 
			}
		}
		
		BFS(new Pair(0, 0));
		
		// 이동거리를 미로 칸에 저장하면서 오면 미로의 마지막 칸에 시작점부터 마지막칸까지의 최소 이동거리가 저장됨
		System.out.println(maze[N - 1][M - 1]);

	}
	
	public static void BFS(Pair start)
	{
		int dir[][] = { // 방향값 저장할 배열
				{0, 1}, // 오른쪽 이동
				{0, -1}, // 왼쪽 이동
				{1, 0}, // 아래로 이동
				{-1, 0} // 위로 이동
		};
		
		Queue<Pair> q = new LinkedList<>();
		q.add(start);
		visit[start.getFirst()][start.getSecond()] = true; // 시작 정점은 방문 표시하고 시작
		
		while (!q.isEmpty())
		{
			Pair cur = q.poll();
			int curVal = maze[cur.getFirst()][cur.getSecond()]; // 시작점부터 현위치까지의 거리
			
			for (int i = 0; dir.length > i; i++)
			{
				// 반복문으로 방향 배열을 순회하면서 다음 위치를 구함 
				Pair next = new Pair(cur.getFirst() + dir[i][0], cur.getSecond() + dir[i][1]);
				
				// 다음 위치가 배열 범위 밖이면 continue
				if (0 > next.getFirst() || N <= next.getFirst() || 0 > next.getSecond() || M <= next.getSecond())
					continue;
				
				// 다음 위치를 방문하지 않았고 1이라면 이동할 수 있음
				if (!visit[next.getFirst()][next.getSecond()] && 1 == maze[next.getFirst()][next.getSecond()])
				{
					// 다음에 방문할 리스트에 추가하고 방문표시
					q.add(next);
					visit[next.getFirst()][next.getSecond()] = true;
					// 현위치에서 이동거리가 1추가되니까 현위치의 이동값+1을 다음 위치에 저장함
					maze[next.getFirst()][next.getSecond()] = curVal + 1;
				}
			}
		}
	}

}

class Pair
{
	private int first;
	private int second;
	
	public Pair(int first, int second)
	{
		this.first = first;
		this.second = second;
	}
	
	public int getFirst() {return first;}
	public int getSecond() {return second;}
}
