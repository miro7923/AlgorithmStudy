/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1018
 *
 * # 문제
 * 지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다.
 * 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.
 * 체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다.
 * 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.
 * 보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다.
 * 당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.
 *
 *
 * # 제한
 * 시간제한: 1 초 / 메모리 제한:  	128 MB
 *
 * # 입력
 * 첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다.
 * 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.
 *
 * # 출력
 * 첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.
 *
 * # 풀이
 * 우선 8 * 8 크기의 올바른 체스판을 배열로 만들어 둔다.
 * 이 때 두 개의 배열로 만들어야 하는데 첫번째 배열은 맨 왼쪽 위 칸이 흰색인 경우이고 두번째 배열은 맨 왼쪽 위 칸이 검은색인 경우이다.
 *
 * M * N 보드에서 8 * 8 크기의 보드로 자를 수 있는 경우를 모두 구하고 그 경우마다
 * 만들어 놓은 올바른 체스판과 비교하면서 색칠해야하는 정사각형의 개수를 구한다.
 * 모든 경우에서 색칠해야하는 정사각형의 개수가 가장 적을 때 정답이 된다.
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] board;  // 입력받을 보드판 배열
    static char[][] sliceBoard1;    // W로 시작하는 올바른 체스판 배열
    static char[][] sliceBoard2;    // B로 시작하는 올바른 체스판 배열
    static int count = Integer.MAX_VALUE;   // 색칠해야하는 정사각형 개수의 최소를 구해야 하기 때문에 정수의 가장 큰 값을 임시로 넣어둔다.

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 배열을 좀 더 편리하게 다루기 위해 인덱스가 0인 공간은 모두 비워두고, 1개씩 더 큰 크기의 배열을 만든다.
        board = new char[M + 1][N + 1];
        sliceBoard1 = new char[9][9];
        sliceBoard2 = new char[9][9];
        makeRightBoard();   // 올바른 체스판 배열을 만들기 (sliceBoard1과 sliceBoard2를 만든다)

        for (int i = 1; i < N + 1; i++) {   // board 배열에 입력받은 값들 넣기.
            String row = br.readLine();
            for (int j = 1; j < row.length() + 1; j++) {
                board[j][i] = row.charAt(j - 1);
            }
        }
    }

    static void makeRightBoard() {
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        sliceBoard1[i][j] = 'W';
                        sliceBoard2[i][j] = 'B';
                    } else {
                        sliceBoard1[i][j] = 'B';
                        sliceBoard2[i][j] = 'W';
                    }
                } else {
                    if (j % 2 == 0) {
                        sliceBoard1[i][j] = 'B';
                        sliceBoard2[i][j] = 'W';
                    } else {
                        sliceBoard1[i][j] = 'W';
                        sliceBoard2[i][j] = 'B';
                    }
                }
            }
        }
    }

    static void countColor() {  // 칠해야 하는 정사각형의 최소 개수를 구한다.
        int temp1 = 0;
        int temp2 = 0;
        for (int i = 1; i <= board.length - 8; i++) {
            for (int j = 1; j <= board[0].length - 8; j++) {
                // sliceBoard1와 비교해서 얻은 색칠해야할 정사각형의 개수 temp1
                temp1 = getTemp(temp1, i, j, sliceBoard1);
                // sliceBoard2와 비교해서 얻은 색칠해야할 정사각형의 개수 temp2
                temp2 = getTemp(temp2, i, j, sliceBoard2);

                // 칠해야할 정사각형의 최소개수 구하기. temp1과 temp2 중 최소
                count = Math.min(count, Math.min(temp1, temp2));
                temp1 = 0;
                temp2 = 0;
            }
        }
    }

    private static int getTemp(int temp, int i, int j, char[][] sliceBoard1) {
        int sliceRow = 1;
        int sliceCol = 1;
        for (int k = i; k < i + 8; k++) {
            for (int l = j; l < j + 8; l++) {
                if (board[k][l] != sliceBoard1[sliceRow][sliceCol]) temp++;
                sliceCol++;
            }
            sliceRow++;
            sliceCol = 1;
        }
        return temp;
    }

    public static void main(String[] args) throws IOException {
        input();
        countColor();
        System.out.println(count);
    }
}
