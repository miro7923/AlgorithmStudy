package ByungwooKim.DFS;

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
 * 시간제한: 2초 / 메모리 제한: 128 MB
 *
 * # 입력
 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
 * 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
 * 입력으로 주어지는 간선은 양방향이다.
 *
 *
 * # 출력
 * 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
 *
 */

import java.io.*;
import java.util.*;

public class BOJ_1260 {

    static int N, M, V; //정점 개수 N, 간선 개수 M, 정점 번호 V
    static StringTokenizer st;
    static BufferedReader br;
    static ArrayList<ArrayList<Integer>> adj;
    static int[] visited; //방문했는지 체크하는 배열. dfs와 bfs를 하나의 배열로 체크할 것이기 때문에 dfs로 방문을 했다면 1로, bfs로 방문했다면 2로 체크.
    static StringBuilder sb = new StringBuilder(); //결과값들을 담아서 출력할 StringBuilder


    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();

        // ArrayList의 인덱스는 0부터 시작하지만 정점의 번호는 1부터 시작하기 때문에 편의를 위해 (정점의 개수 + 1)개 만큼 ArrayList를 만든다.
        for (int i = 0; i <= N; i++) {
            visited = new int[N + 1];
            adj.add(new ArrayList<>());
        }

        // adj 안의 ArrayList에 방문해야할 정점의 번호들을 넣어준다. 즉, 정점들을 간선으로 연결해준다.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }

        // 문제에서 방문할 정점이 여러개인 경우 번호가 작은 것부터 먼저 방문해야 한다고 조건이 주어졌기 때문에 정렬을 해줘야 한다.
        // 만약 정렬을 하지 않으면 1이 2와 5가 연결되어 있는데 입력을 1 5 / 1 2 이런 순서로 입력값이 들어오면 1은 2를 먼저 방문하는게 아니라 5를 먼저 방문하게 된다.
        // 따라서 정렬을 해주어야 한다.
        for (int i = 1; i < adj.size(); i++) {
            Collections.sort(adj.get(i));
        }

    }

    static void dfs(int start) {
        visited[start] = 1;
        sb.append(start + " ");

        for (int v : adj.get(start)) {
            if (visited[v] == 1)
                continue;
            dfs(v);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        visited[start] = 2;

        while (!queue.isEmpty()){
            start = queue.poll();
            sb.append(start + " ");
            for(int v : adj.get(start)){
                if(visited[v] == 2)
                    continue;
                queue.add(v);
                visited[v] = 2;
            }

        }

    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        input();
        dfs(V);
        sb.append("\n");
        bfs(V);
        System.out.println(sb.toString());
    }

    // 다른 사람들의 코드를 참고해보니 자료구조를 ArrayList<ArrayList<Integer>>로 하기보단 ArrayList<Integer>[]로 하는게 더 좋았을 거 같다.

    // bfs와 dfs 함수들에서 for문을 사용하는데 있어서 처음에 index 값들을 이용해야 될 거 같아서 향상된 for문을 쓰지 않았다.
    // 그래서 코드의 가독성이 매우 떨어졌었다.
    // 예를들어 내가 원하는 값들을 adj.get(start).get(i) 이런 식으로 값들을 꺼냈어야 되었고 코드가 불필요하게 길어지고 가독성이 떨어졌다.
    // 그런데 다른 사람들의 코드를 보고 다시 생각해보니 index값들을 굳이 쓸 필요가 없었고 향상된 for문으로 교체하니 훨씬 코드가 깔끔해졌다.
}
