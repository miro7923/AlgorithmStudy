/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1260
 * 
 * # 문제
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 
 * 정점 번호는 1번부터 N번까지이다.
 * 
 * # 제한
 * 시간 제한 : 2초, 메모리 제한 : 128 MB
 * 
 * # 입력
 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
 * 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
 * 
 * # 출력
 * 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
 * 
 */

import java.util.*;

public class Main {
	
	static int N; // 정점의 개수를 입력받을 변수
	static boolean graph[][]; // DFS는 재귀호출 해야하니까 밖에서 접근할 수 있게 전역 선언
	static boolean visit[]; // 방문체크할 배열

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		N = s.nextInt();
		int M = s.nextInt();
		int V = s.nextInt();
		
		graph = new boolean[N + 1][N + 1]; // 정점 번호가 1부터 시작해서 N까지이기 때문에 N개만 할당하면 배열 인덱스가 0~N-1까지임
		visit = new boolean[N + 1]; // 인덱스 에러가 나지 않고 N번째 인덱스까지 탐색할 수 있도록 배열 크기도 1개 늘림
		
		// 그래프 세팅
		// 양방향 그래프니까 from-to / to-from 모두 연결시켜 줌
		for (int i = 0; M > i; i++)
		{
			int from = s.nextInt();
			int to = s.nextInt();
			graph[from][to] = true;
			graph[to][from] = true;
		}
		
		// 시작점 방문표시 하고 시작
		visit[V] = true;
		DFS(V);
		
		System.out.println();
		
		// BFS에서 새롭게 탐색할 수 있도록 방문 배열 초기화
		visit = new boolean[N + 1];
		BFS(V);

	}
	
	public static void DFS(int start)
	{
		// DFS는 재귀 호출이 이루어져야 함
		// 방문 표시는 재귀 호출 전에 하고 오기 때문에 DFS함수가 다시 재귀호출되면 현재 정점을 그대로 출력하면 됨
		System.out.print(start + " ");
		
		for (int i = 1; N >= i; i++)
		{
			// 다음 정점이 연결되어 있고 방문하지 않은 곳이라면 방문표시하고 재귀 호출
			if (graph[start][i] && !visit[i])
			{
				visit[i] = true;
				DFS(i);
			}
		}
	}
	
	public static void BFS(int start)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visit[start] = true; // 시작 정점은 방문 표시하고 시작
		
		while (!q.isEmpty())
		{
			int cur = q.poll();
			
			// 방문했으니까 출력
			System.out.print(cur + " ");
			
			for (int i = 1; N >= i; i++)
			{
				// 방문하지 않은 정점은 큐에 추가하면서 큐에 추가한 정점은 방문 표시해서 같은 정점이 중복으로 큐에 삽입되지 않도록 함
				// (불필요한 연산을 하지 않도록)
				if (graph[cur][i] && !visit[i])
				{
					q.add(i);
					visit[i] = true; 
				}
			}
		}
	}

}
