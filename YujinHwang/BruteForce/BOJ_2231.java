/*
문제 링크
https://www.acmicpc.net/problem/2231

제한
시간 : 2 초    메모리 : 192 MB

문제
어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다.
예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다. 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다.
반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.

출력
첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.
 */

/*
풀이
참고 블로그 : https://st-lab.tistory.com/98

N의 생성자 중 가장 작은 수를 구하면 되니까 꼭 모든 수를 탐색할 필요는 없고 1부터 수를 만들어 보면서 N과 같은 수가 나오면 반복을 중단하고 해당 수를 출력하면 된다.
만약 N을 넘어가는데도 생성자가 없다면 0을 출력한다.

결과
시간 : 152 ms    메모리 : 14828 KB
 */

import java.io.*;

public class Main
{
    static int ans = 0; // 정답
    static int N; // 입력으로 주어지는 N

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        // 1부터 N보다 작은 수까지 비교하면서 N의 생성자가 있는지 확인한다.
        for (int i = 1; i < N; i++)
        {
            int sum = i;
            int num = i;
            while (0 < num)
            {
                // i번째 수의 각 자리수를 떼서 더한다.
                sum += num % 10;
                num /= 10;
            }

            if (sum == N)
            {
                // 더한 값이 N과 일치하면 탐색 중단 후 출력
                ans = i;
                break;
            }
        }

        bw.write(Integer.toString(ans));

        bw.flush();
        bw.close();
    }
}
