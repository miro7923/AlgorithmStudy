/*
문제 링크
https://www.acmicpc.net/problem/11729

제한
시간 : 1 초    메모리 : 256 MB

문제
세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 각 원판은 반경이 큰 순서대로 쌓여있다.
이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.

한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.

이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.

입력
첫째 줄에 첫 번째 장대에 쌓인 원판의 개수 N (1 ≤ N ≤ 20)이 주어진다.

출력
첫째 줄에 옮긴 횟수 K를 출력한다.

두 번째 줄부터 수행 과정을 출력한다.
두 번째 줄부터 K개의 줄에 걸쳐 두 정수 A B를 빈칸을 사이에 두고 출력하는데, 이는 A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다.
 */

/*
풀이
풀이 찾아봄
참고 풀이 : https://st-lab.tistory.com/96
풀이 보니까 애초에 내가 풀 수 없는 문제였음..ㅎ

하노이의 탑 문제는 재귀적으로 풀 수 있는 유명한 문제였는데 n개의 원판을 이동시킨다면 이동횟수는 2^n - 1이 된다.
그래서 저걸 먼제 출력한 다음 재귀적으로 원판들을 탐색하면서 이동한 경로를 출력하면 된다.
A, B, C 장대가 있을 때 이동 경로는 처음에 A에 있는 n개의 원판 중 n-1개의 원판을 B로 옮긴다.
그러면 A에 1개의 원판이 남는다. 이걸 C로 옮긴다.
이제 B에 남은 n-1개의 원판에서 1개를 뺀 n-2개의 원판을 A로 옮긴 다음 마지막으로 남은 원판을 C로 옮긴다.
A에 남은 것 중 1개를 뺀 n-3개를 B로 옮기고 남은 1개를 C로 옮기고... 를 완성될 때까지 반복하면 된다.

결과
시간 : 512 ms    메모리 : 69008 KB
 */

import java.io.*;

public class Main
{
    static BufferedWriter bw;
    static StringBuilder sb;

    static void hanoi(int n, int start, int via, int to)
    {
        // 옮겨야 할 원판이 1개 남으면 시작점에서 목표지점으로 옮기면 된다.
        if (1 == n)
        {
            sb.append(start + " " + to + "\n");
            return;
        }

        // n=1일 때가 끝나고 리턴되어 나오면 옮겨야 할 원판이 1개보다 많다.
        // 남은 원판들을 중간지점으로 옮긴다.
        hanoi(n - 1, start, to, via);

        // n-1개 원판들을 중간지점으로 옮기고 나면 1개 남은 원판을 목표지점으로 옮기면 된다.
        sb.append(start + " " + to + "\n");

        // 위에서 옮기고 남은 중간지점에 있는 n-1개 원판들을 목표지점으로 옮긴다.
        hanoi(n - 1, via, start, to);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 이동횟수는 2^n - 1
        bw.write(Integer.toString((int) (Math.pow(2, N) - 1)) + "\n");
        hanoi(N, 1, 2, 3);
        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
    }
}
