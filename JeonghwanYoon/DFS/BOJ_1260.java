import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260 {

	static int N; 
	static int M; 
	static int V; 
	static int[][] map;
	static boolean[] visited;
	
	
	public static void main(String[] args) {
		
	/*
	 * 문제
	 * 
	 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는
	 * 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
	 * 
	 * 입력
	 * 
	 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가
	 * 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로
	 * 주어지는 간선은 양방향이다.
	 * 
	 * 출력
	 * 
	 * 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
	 * 
	 */
		
	Scanner sc = new Scanner(System.in);
	
	N = sc.nextInt(); // 정점개수
	M = sc.nextInt(); // 간선개수
	V = sc.nextInt(); // 시작정점 
	
	map = new int[1001][1001]; // 좌표값 (1~1000까지 이므로)
	visited = new boolean[N+1]; // 초기값은 false
	
	
	for(int i=0; i<M; i++) //간선 연결상태 저장
	{
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		map[x][y] = map[y][x] = 1;
		
	}
	sc.close();
	
	dfs(V);
	visited = new boolean[N+1]; // 인덱스체크 초기화
	System.out.println();
	
	bfs();

	}
	
	//시작점을 변수로 받아 확인, 출력 후 다음 연결점을 찾아 시작점을 변경하여 재호출
	public static void dfs(int i)
	{
		visited[i] = true;
		System.out.print(i + " ");
		
		for(int j=1; j<=N; j++)
		{
			if(map[i][j] == 1 && visited[j] == false) // i번 인덱스와 연결되어있으면서, 방문한적있는 인덱스는 제외시키기(Depth-First이므로)
			{
				dfs(j);
			}
			
		}
	}
	
	public static void bfs() { //V를 써서 시작하면되고 인덱스우선 -> 그다음부터 [V][j]의 j중 낮은것 인덱스 ->  
		// -> LinkedList 공부가 필요 , arraylist는 내부배열에 객체를 저장해서 관리 LinkedList는 인접 참조를 링크해서 체인처럼 관리
		// 즉 arraylist는 배열처럼 중간에 삽입되거나 삭제되면 해당인덱스 뒷부분을 밀어줘야하지만
		// LinkedList는 중간에 삽입되거나 삭제되면 삭제된걸 빼고 그사이를 연결해버리면됨
		// 따라서 arraylist는 순차적으로 추가하거나 삭제할때 빠르고 LinkedList는 중간에 삽입거나 삭제할때 빠름
		
		Queue<Integer> queue = new LinkedList<Integer>(); // bfs는 quque타입이므로 Queue타입 LinkedList리스트 생성
		queue.offer(V);
		visited[V] = true;
		System.out.print(V + " ");
		
		while(!queue.isEmpty()) // queue가 빌때까지 반복!
		{
			int temp = queue.poll(); // poll은 queue에 넣은 순서대로 빼는것 
		
			for(int j=1; j<=N; j++)
			{
				if(map[temp][j]== 1 && !visited[j])
				{
					queue.offer(j);
					visited[j] = true; // 중복인덱스 제거!
					System.out.print(j + " "); // -> V인덱스의 j값 모두 offer하고 나면 다시 
				}
			}
		}
	}
}
