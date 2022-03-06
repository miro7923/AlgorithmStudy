/*
문제 링크
https://www.acmicpc.net/problem/9663

제한
시간 : 10 초    메모리 : 128 MB

문제
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N < 15)

출력
첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
 */

/*
풀이
어디서 들어본 거 같은데 모르겠어서 구글링했다.
참고 블로그 : https://st-lab.tistory.com/118

체스판 위에 퀸을 놓은 뒤 그 위치의 다음 위치부터 검사해서 어떤 위치가 퀸이 있는 위치에서 상하좌우 대각선 방향에 있는 곳이라면 그냥 넘어가고 아니라면 퀸을 놓기 위한 함수를 재귀호출하는 것이다.
탐색 위치가 체스판의 끝에 도달하면 재귀 호출을 종료한다. (자세한 건 주석에..)

결과
시간 : 5320 ms    메모리 : 14532 KB
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    static BufferedWriter bw;

    static int N, ans; // 체스판 크기와 정답
    static int[] board; // 체스판 배열인데 배열의 각 인덱스를 열이라 생각하고 원소의 값을 행이라 생각할 것이라 1차원 배열로도 가능하다.

    // 해당 위치에 퀸을 놓을 수 있는지 검사하는 함수
    public static boolean isPossible(int col)
    {
        for (int i = 0; i < col; i++)
        {
            // 해당 열의 행과 열이 일치하면 놓을 수 없다(이 행에는 퀸이 이미 있음)
            if (board[col] == board[i])
                return false;
            // 이미 퀸이 있는 위치의 대각선 방향으로도 놓을 수 없다.(행과 열의 차가 같으면 대각선 방향임)
            else if (Math.abs(col - i) == Math.abs(board[col] - board[i]))
                return false;
        }

        // 위 두 케이스에 걸리지 않으면 퀸을 놓을 수 있다.
        return true;
    }

    public static void nQueen(int depth)
    {
        if (N == depth)
        {
            // 이번에 탐색할 열이 체스판의 크기와 같으면 모든 퀸을 놓은 것이니까 경우의 수 증가 & 리턴
            ans++;
            return;
        }

        for (int i = 0; i < N; i++)
        {
            // 현재 열에 퀸을 놓는다.
            board[depth] = i;

            // 이번 열이 놓을 수 있는 위치라면 재귀호출
            if (isPossible(depth))
                nQueen(depth + 1);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        board = new int[N];

        nQueen(0);
        bw.write(Integer.toString(ans));

        bw.close();
    }
}