/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2667
 * 
 * # 문제
 * <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 
 * 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 
 * 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 
 * 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 
 * 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 128 MB
 * 
 * # 입력
 * 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
 * 
 * # 출력
 * 첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
 * 
 */

import java.util.*;

public class Main {
	
	static int N; // 정사각형 지도의 크기
	static int input[][]; // 입력으로 주어지는 지도
	static boolean visit[][]; // 방문체크할 배열
	static int dir[][]; // 탐색할 방향
	static ArrayList<Integer> ans; // 단지 크기들을 저장할 배열

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		N = s.nextInt();
		
		input = new int[N][N];
		visit = new boolean[N][N];
		
		for (int i = 0; N > i; i++)
		{
			String str = s.next();
			for (int j = 0; str.length() > j; j++)
			{
				if ('1' == str.charAt(j))
					input[i][j] = 1;
				else 
					input[i][j] = 0; 
			}
		}
		
		dir = new int[4][2];
		dir[0][0] = 0; dir[0][1] = 1; // 오른쪽
		dir[1][0] = 0; dir[1][1] = -1; // 왼쪽
		dir[2][0] = 1; dir[2][1] = 0; // 아래
		dir[3][0] = -1; dir[3][1] = 0; // 위
		
		ans = new ArrayList<>();
		
		// 지도의 처음부터 끝까지 탐색하면서 서로 떨어진 단지들을 찾아야 하기 때문에 2중 for문으로 처음부터 끝까지 탐색 
		for (int i = 0; N > i; i++)
		{
			for (int j = 0; N > j; j++)
			{
				// 해당위치를 방문하지 않았고 단지(1)일 때만 BFS 실행
				if (!visit[i][j] && 1 == input[i][j])
					BFS(new Pair(i, j));
			}
		}
		
		// 오름차순 정렬
		ans.sort(Comparator.naturalOrder());
		
		System.out.println(ans.size()); // 총 단지수 출력
		for (int elem : ans)
			System.out.println(elem); // 작은 순서대로 출력

	}
	
	public static void BFS(Pair start)
	{
		Queue<Pair> q = new LinkedList<>();
		q.add(start);
		visit[start.getFirst()][start.getSecond()] = true; // 시작 정점은 방문 표시하고 시작
		
		int size = 0;
		
		while (!q.isEmpty())
		{
			Pair cur = q.poll();
			size++; // 여기 들어왔다는 건 방문 가능하다는 것이니까 배열 인덱스값이 1(단지)이라는 뜻임. 넓이 증가 
			
			for (int i = 0; dir.length > i; i++)
			{
				// 반복문으로 방향 배열을 순회하면서 다음 위치를 구함 
				Pair next = new Pair(cur.getFirst() + dir[i][0], cur.getSecond() + dir[i][1]);
				
				// 다음 위치가 배열 범위 밖이면 continue
				if (0 > next.getFirst() || N <= next.getFirst() || 0 > next.getSecond() || N <= next.getSecond())
					continue;
				
				// 다음 위치를 방문하지 않았고 1이라면 이동할 수 있음
				if (!visit[next.getFirst()][next.getSecond()] && 1 == input[next.getFirst()][next.getSecond()])
				{
					// 다음에 방문할 리스트에 추가하고 방문표시
					q.add(next);
					visit[next.getFirst()][next.getSecond()] = true;
				}
			}
		}
		
		// BFS 탐색이 끝나면 구한 단지의 넒이를 정답 큐에 저장
		ans.add(size);
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
