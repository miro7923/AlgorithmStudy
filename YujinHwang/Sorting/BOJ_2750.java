/*
문제 링크
https://www.acmicpc.net/problem/2750

제한
시간 : 1 초    메모리 : 128 MB

문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 */

/*
풀이
제한시간 1초에 N 최대값이 1,000이라 N^2 정렬 알고리즘으로 풀었다.(삽입정렬 사용)

결과
시간 : 188 ms    메모리 : 16936 KB
 */

import java.io.*;

public class Main
{
    static BufferedWriter bw;
    static int N;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (arr[j] > arr[i])
                {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }

        for (int i = 0; i < N; i++)
            bw.write(arr[i] + "\n");

        bw.flush();
        bw.close();
    }
}
