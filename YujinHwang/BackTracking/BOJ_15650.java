/*
문제 링크
https://www.acmicpc.net/problem/15650

제한
시간 : 1 초    메모리 : 512 MB

문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
고른 수열은 오름차순이어야 한다.

입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */

/*
풀이
순열을 구하는 문제같아서 순열을 구하는 알고리즘으로 풀었다.
참고 블로그 : https://bcp0109.tistory.com/14

이번 문제는 모든 순열을 출력하는 것이 아니고 오름차순으로 정렬된 순열만 출력해야 하기 때문에
다음 순열을 확인하러 갈 때 직전에 뽑은 수보다 큰 숫자만 뽑도록 했다.

결과
시간 : 152 ms    메모리 : 15908 KB
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    static int N, M; // N개의 수에서 M개의 수를 고름
    static int arr[]; // 1 ~ N 까지의 수를 저장할 배열
    static int output[]; // N개의 수 중 선택한 M개의 수를 저장할 배열
    static boolean visited[]; // i번째 수를 선택했는지 확인할 배열

    static BufferedWriter bw;

    // n개 중에서 r개를 고르는 경우를 탐색할 함수인데 문제에서 n = N, r = M으로 주어져서 매개변수로는 현재 선택한 숫자의 개수를 나타낼 depth만 씀
    public static void permutation(int depth) throws IOException
    {
        // 현재 선택한 숫자의 갯수가 M개라면 고른 숫자들을 출력하고 재귀 호출 종료
        if (depth == M)
        {
            for (int i = 0; i < M; i++)
                bw.write(output[i] + " ");
            bw.write("\n");

            return;
        }

        // 1 ~ N 까지의 숫자 중 M개를 선택하는데 중복이 허용되지 않으니까 방문표시 배열을 이용해 아직 선택하지 않은 숫자들 중 M개를 고른다.
        for (int i = 0; i < N; i++)
        {
            // 지금까지 뽑은 수 중 마지막 숫자와 비교해야 하는데
            // 뽑은 수가 없을 땐 마지막 숫자의 인덱스가 0임
            // 이 때 마지막 수랑 비교한다고 -1 해버리면 인덱스가 -1이 되어서 인덱스 바운드 에러가 나니까 0보단 작아지지 않도록 한다.
            int last = (0 > depth - 1) ? 0 : depth - 1;

            // 선택한 수 중 마지막 숫자와 비교해서 더 큰 숫자만 뽑도록 함
            if (!visited[i] && output[last] < arr[i])
            {
                visited[i] = true;
                output[depth] = arr[i]; // i번째 수를 아직 선택하지 않았다면 선택하고
                permutation(depth + 1); // 이번 수를 선택한 상태에서 다른 숫자들을 선택한 경우를 재귀호출로 탐색함
                visited[i] = false; // 탐색이 끝나고 나오면 다른 조합을 탐색해야 하니까 방문 해제 표시
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        output = new int[M];
        visited = new boolean[N];
        for (int i = 1; i <= N; i++)
            arr[i - 1] = i; // 1~N 까지의 수 배열에 저장

        permutation(0);

        bw.close();
    }
}