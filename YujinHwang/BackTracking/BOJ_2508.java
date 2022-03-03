/*
문제 링크
https://www.acmicpc.net/problem/2580

제한
시간 : 1 초    메모리 : 256 MB

문제
스도쿠는 18세기 스위스 수학자가 만든 '라틴 사각형'이랑 퍼즐에서 유래한 것으로 현재 많은 인기를 누리고 있다. 이 게임은 아래 그림과 같이 가로, 세로 각각 9개씩 총 81개의 작은 칸으로 이루어진 정사각형 판 위에서 이뤄지는데, 게임 시작 전 일부 칸에는 1부터 9까지의 숫자 중 하나가 쓰여 있다.

나머지 빈 칸을 채우는 방식은 다음과 같다.

각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.

게임 시작 전 스도쿠 판에 쓰여 있는 숫자들의 정보가 주어질 때 모든 빈 칸이 채워진 최종 모습을 출력하는 프로그램을 작성하시오.

입력
아홉 줄에 걸쳐 한 줄에 9개씩 게임 시작 전 스도쿠판 각 줄에 쓰여 있는 숫자가 한 칸씩 띄워서 차례로 주어진다. 스도쿠 판의 빈 칸의 경우에는 0이 주어진다. 스도쿠 판을 규칙대로 채울 수 없는 경우의 입력은 주어지지 않는다.

출력
모든 빈 칸이 채워진 스도쿠 판의 최종 모습을 아홉 줄에 걸쳐 한 줄에 9개씩 한 칸씩 띄워서 출력한다.

스도쿠 판을 채우는 방법이 여럿인 경우는 그 중 하나만을 출력한다.
 */

/*
풀이
처음엔 for문을 여러번 돌려서 n^3에 가깝게 풀었는데 그래서 그런지 시간 초과가 났다...
그래서 시간을 줄여보려고 입력 받으면서 0인 칸만 따로 저장한 뒤 거기만 탐색하는 방식으로도 해 봤지만 역시 1%에서 시간초과가 나서 질문 게시판과 구글링을 참고했다.

스도쿠의 가로세로줄과 3*3 칸을 검사한 뒤 겹치는 숫자가 없도록 넣어야 하기 때문에 이것을 검사하는 함수를 만들어서 0인 위치에 대해서 1~9 까지의 숫자를 넣어서 검사를 실시한 뒤
해당 숫자를 넣을 수 있으면 수를 삽입한 뒤 스도쿠에 숫자를 넣는 함수를 재귀호출한다.
스도쿠 칸을 채우는 방법이 여러 개가 있을 수 있기 때문에 보드판이 다 채워지는대로 보드판을 출력하고 System.exit(0)을 사용해서 프로그램을 종료한다.

결과
시간 : 672 ms    메모리 : 28336 KB
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    static final int SIZE = 9; // 스도쿠 판 사이즈
    static StringBuilder sb;

    static int board[][]; // 스도쿠 판

    // 해당 위치에 해당 숫자(n)를 넣을 수 있는지 검사하는 함수
    static boolean check(int n, int x, int y)
    {
        // 세로 방향으로 검사한다.
        for (int i = 0; i < SIZE; i++)
        {
            // n이 이미 있으면 넣을 수 없으니까 false 리턴하고 탐색 종료
            if (n == board[i][y])
                return false;
        }

        // 가로 방향으로 검사한다.
        for (int i = 0; i < SIZE; i++)
        {
            if (n == board[x][i])
                return false;
        }

        // 3*3 영역을 검사하기 위해 시작과 종료값을 설정한다.
        int startX = 0, startY = 0, endX, endY;
        switch (x)
        {
            case 0: case 1: case 2:
                startX = 0;
                break;

            case 3: case 4: case 5:
                startX = 3;
                break;

            case 6: case 7: case 8:
                startX = 6;
                break;
        }

        switch (y)
        {
            case 0: case 1: case 2:
                startY = 0;
                break;

            case 3: case 4: case 5:
                startY = 3;
                break;

            case 6: case 7: case 8:
                startY = 6;
                break;
        }
        endX = startX + 2;
        endY = startY + 2; // 시작지점에서 2칸 뒤 까지만 검사하면 된다.

        for (int i = startX; i <= endX; i++)
        {
            for (int j = startY; j <= endY; j++)
            {
                if (n == board[i][j])
                    return false;
            }
        }

        // 위의 케이스에 모두 걸리지 않으면 n을 넣을 수 있다.
        return true;
    }

    // 스도쿠의 해당 칸에 숫자를 넣는 재귀 함수
    static void sudoku(int x, int y)
    {
        // 가로줄의 끝까지 왔으면 다음 줄 첫 번째 칸으로 이동한다.
        if (SIZE == y)
        {
            sudoku(x + 1, 0);
            return;
        }

        // 세로줄 끝까지 왔다는 것은 마지막 줄이라는 뜻이다.(위 조건문에서 y가 9가 되었을 때에만 x를 증가시키므로)
        // 스도쿠 판을 출력하고 프로그램을 종료한다.
        if (SIZE == x)
        {
            for (int i = 0; i < SIZE; i++)
            {
                for (int j = 0; j < SIZE; j++)
                    sb.append(board[i][j] + " ");

                sb.append("\n");
            }

            System.out.println(sb);
            System.exit(0);
        }

        // 이번 칸이 채워야 하는 칸이라면 검사 수행 후 숫자를 채우고 재귀호출한다.
        if (0 == board[x][y])
        {
            for (int i = 1; i <= SIZE; i++)
            {
                if (check(i, x, y))
                {
                    board[x][y] = i;
                    sudoku(x, y + 1);
                }
            }

            // 그런데 이 칸에 다른 숫자가 들어가야 할 수도 있으니까 만약 칸을 다 채우지 못해서 여기까지 빠져나오게 된다면 0으로 초기화하고 다시 탐색할 수 있도록 한다.
            board[x][y] = 0;
            return;
        }

        // 이번 칸이 0이 아니면 다음 칸 탐색
        sudoku(x, y + 1);
    }

    public static void main(String[] args) throws IOException
    {
        int t = (int) System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        board = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        sudoku(0, 0);
    }
}