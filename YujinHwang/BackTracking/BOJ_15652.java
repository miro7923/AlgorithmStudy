/*
문제 링크
https://www.acmicpc.net/problem/15652

제한
시간 : 1 초    메모리 : 512 MB

문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.
고른 수열은 비내림차순이어야 한다.
길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.

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

이번 문제는 중복 순열을 구하는데 오름차순인 순열만 구해야 하기 때문에 마지막으로 뽑은 수보다 큰 수만 뽑도록 했다.

결과
시간 : 228 ms    메모리 : 19616 KB
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    static int N, M; // N개의 수에서 M개의 수를 고름
    static int arr[]; // 1 ~ N 까지의 수를 저장할 배열
    static int output[]; // N개의 수 중 선택한 M개의 수를 저장할 배열

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

        for (int i = 0; i < N; i++)
        {
            int last = (0 > depth - 1) ? 0 : depth - 1;
            if (output[last] <= arr[i])
            {
                output[depth] = arr[i]; // i번째 수를 아직 선택하지 않았다면 선택하고
                permutation(depth + 1); // 이번 수를 선택한 상태에서 다른 숫자들을 선택한 경우를 재귀호출로 탐색함
                // 재귀 호출하면서 반복문을 수행하는 과정에서 차례대로 중복 순열을 구하게 된다.
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
        for (int i = 1; i <= N; i++)
            arr[i - 1] = i; // 1~N 까지의 수 배열에 저장

        permutation(0);

        bw.close();
    }
}