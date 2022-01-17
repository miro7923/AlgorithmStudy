package ByungwooKim.BFS;

/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2178
 *
 * # 문제
 *
 * N×M크기의 배열로 표현되는 미로가 있다.
 * 1	0	1	1	1	1
 * 1	0	1	0	1	0
 * 1	0	1	0	1	1
 * 1	1	1	0	1	1
 * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
 * 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
 * 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 * 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 *
 * # 제한
 * 시간제한: 1초 / 메모리 제한: 192 MB
 *
 * # 입력
 * 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
 *
 *
 * # 출력
 * 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
 *
 */

import java.io.*;
import java.util.*;

public class BOJ_2178 {

    static int N, M;
    static StringTokenizer st;
    static BufferedReader br;
    static final int PATH = 1;
    static int minLength;

    static int[][] maze; //방문했는지 체크하는 배열.


    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String temp;

        maze = new int[N + 2][M + 2];
        // 미로탐색할때 첫번째 열이나 마지막열 그리고 첫번쨰 행이나 마지막 행의 경우 ArrayIndexOutOf 에러를 방지하기 위해 각 테두리(?)부분에 하나씩 크기를 더 늘려줌.

        //입력받은 값들 인접행렬 2차원 배열에 넣어주기.
        for (int i = 1; i <= N; i++) {
            temp = br.readLine();
            for (int j = 1; j <= M; j++) {
                maze[i][j] = temp.charAt(j - 1) - 48; //char형식의 숫자들은 int형으로 바꾸기 위해선 -48을 해야함.(유니코드 참조)
            }
        }
    }


    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        //위치값을 기억해주고 큐에 넣어준다.
        int[] position = {x, y};
        queue.add(position);

        while (!queue.isEmpty()) {
            position = queue.poll();
            x = position[0];    y = position[1];
            if (x == N && y == M) break; // 도착위치에 도착하면 break;

            // 동서남북으로 갈 수 있는 방향이면 그 위치를 큐에 넣어주고 그 위치의 값에 현재 위치의 값을 더해준다.
            if(maze[x][y+1] == PATH){ //동쪽으로 탐색.
                position = new int[] {x, y+1};
                queue.add(position);
                maze[x][y+1] += maze[x][y];
            }
            if(maze[x][y-1] == PATH){ //서쪽
                position = new int[] {x, y-1};
                queue.add(position);
                maze[x][y-1] += maze[x][y];
            }
            if(maze[x+1][y] == PATH){ //남쪽
                position = new int[] {x+1, y};
                queue.add(position);
                maze[x+1][y] += maze[x][y];
            }
            if(maze[x-1][y] == PATH){ //북쪽
                position = new int[] {x-1, y};
                queue.add(position);
                maze[x-1][y] += maze[x][y];
            }
        }
        // 위의 while문을 돌면 결국 마지막의 도착 위치에서의 값(maze[N][M])은 도착위치로 갈 수 있는 최소 칸의 개수가 된다.

        minLength = maze[N][M];
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        input();
        bfs(1, 1); // (1,1)에서 시작!
        System.out.println(minLength);
    }

}

