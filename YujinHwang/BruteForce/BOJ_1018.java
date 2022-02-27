/*
문제 링크
https://www.acmicpc.net/problem/1018

제한
시간 : 2 초    메모리 : 128 MB

문제
지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다. 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다.
지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.

체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다.
따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.

보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다.
당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.

출력
첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.
 */

/*
풀이
처음엔 좀 어렵게 생각해서 체스판을 앞에서부터도 확인하고 뒤에서부터도 확인하고 첫번째줄부터, 맨 아랫줄부터 거꾸로 올라가면서 확인하기 등 불필요한 탐색을 하는 코드를 작성했다.
그러다 답이 안 나와서 구글링 참고함

https://st-lab.tistory.com/101

8*8 체스판을 순회하면서 현재 위치부터 +8칸까지가 체스판 색깔을 만족하는지 검사하는 함수 search()를 작성한 후
메인함수에서 입력 크기만큼 8*8씩 이동하면서 search()를 수행하도록 반복문을 작성한다.

결과
시간 : 132 ms    메모리 : 14312 KB
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    static BufferedWriter bw;
//    static StringBuilder sb;
    static int N, M, ans;
    static final int BOARD_SIZE = 8, INF = 64; // 8*8 체스판에서 나올 수 있는 최대값은 64니까 이걸 초기 최소값으로 설정해 놓는다.
    static boolean board[][];

    public static void search(int x, int y)
    {
        int height = x + BOARD_SIZE;
        int width = y + BOARD_SIZE; // 현재 위치부터 +8칸까지 검사하도록 가로세로 길이 설정
        boolean color = board[x][y]; // 현재 칸에 칠해져 있어야 하는 색. 처음에는 첫번째 칸으로 지정
        int cnt = 0;
        for (int i = x; i < height; i++)
        {
            for (int j = y; j < width; j++)
            {
                // 칠해져 있어야 하는 색이 다르면 개수를 센다.
                if (color != board[i][j])
                    cnt++;

                // 다음칸은 다른 색이 칠해져 있어야 하니까 바꿔줌
                color = !color;
            }

            // 다음 줄의 첫번째 칸도 다른 색이 칠해져 있어야 하니까 바꿔줌
            color = !color;
        }

        // 첫번째 칸의 색을 기준으로 했을 때 칠해야 하는 칸의 개수와
        // 첫번째 칸과 다른 색을 기준으로 했을 때 칠해야 하는 칸의 개수를 최대값(64)에서 뺀 값 중 더 작은 값을 저장한다.
        cnt = Math.min(cnt, INF - cnt);

        // 정답에 최소값 저장 
        ans = Math.min(ans, cnt);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new boolean[N][M];
        for (int i = 0; i < N; i++)
        {
            String str = br.readLine();
            for (int j = 0; j < M; j++)
            {
                if ('W' == str.charAt(j))
                    board[i][j] = true;
                else
                    board[i][j] = false;
            }
        }

        ans = INF;

        // 입력 크기가 8*8일 때 1번은 탐색해야 하니까 search()를 시작할 반복문의 종료 조건은 (N - 7), (M - 7)보다 작을 때까지가 되어야 한다.
        int height = N - (BOARD_SIZE - 1);
        int width = M - (BOARD_SIZE - 1);
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
                search(i, j);
        }

        bw.write(Integer.toString(ans));

        bw.flush();
        bw.close();
    }
}
