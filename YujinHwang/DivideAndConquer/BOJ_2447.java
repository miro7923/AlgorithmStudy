/*
문제 링크
https://www.acmicpc.net/problem/2447

제한
시간 : 1 초    메모리 : 256 MB

문제
재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.

크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.

***
* *
***

N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다.
예를 들어 크기 27의 패턴은 예제 출력 1과 같다.

입력
첫째 줄에 N이 주어진다. N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3k이며, 이때 1 ≤ k < 8이다.

출력
첫째 줄부터 N번째 줄까지 별을 출력한다.
 */

/*
풀이
규칙도 못 찾겠어서 풀이 찾아봄
참고 풀이 : https://st-lab.tistory.com/95

N은 3의 거듭제곱수이며 3의 거듭제곱수인 N 크기의 사각형을 그릴 때 항상 가운데는 공백으로 비우게 된다.
***
* *
***
가장 작은 3 크기의 사각형을 위와 같이 그릴 수 있는데 저걸 N 크기에 따라 반복하면서 그리되 N 크기의 사각형 가운데에는 채우지 않는 것이다.
채우지 않는 가운데 사각형은 항상 5번째에 나오게 된다. 

그래서 N*N 크기의 배열을 만들어서 재귀 호출을 통해 배열의 칸 범위를 쪼개어 나가는데 만약 이번칸이 공백이어야 한다면 해당 칸에 공백을 저장하고 그렇지 않다면 *을 저장하면 된다.
재귀호출을 통해 배열을 채운 후 마지막으로 출력 

결과
시간 : 236 ms    메모리 : 24636 KB
 */

import java.io.*;

public class Main {

    static BufferedWriter bw;
    static char stars[][];

    public static void fillStar(int x, int y, int size, boolean isBlank) throws IOException
    {
        // 이번칸이 공백일 때
        if (isBlank)
        {
            for (int i = x; i < x + size; i++)
                for (int j = y; j < y + size; j++)
                    stars[i][j] = ' ';

            return;
        }

        // 사이즈가 1이라 더이상 쪼갤 수 없을 때
        if (1 == size)
        {
            stars[x][y] = '*';
            return;
        }

        int n = size / 3; // 각 칸은 N을 3으로 나눈 단위로 채워지기 때문에 건너뛸 간격을 계산해준다.
        int cnt = 0;
        for (int i = x; i < x + size; i += n)
        {
            for (int j = y; j < y + size; j += n)
            {
                cnt++;
                
                // 배열을 순회하면서 5번째가 되는 칸엔 공백을 넣는다.
                if (5 == cnt)
                    fillStar(i, j, n, true);
                else // 나머지는 *로 채움 
                    fillStar(i, j, n, false);
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        stars = new char[N][N];
        fillStar(0, 0, N, false);

        for (int i = 0; i < N; i++)
        {
            // 한 줄씩 출력
            bw.write(stars[i]);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
