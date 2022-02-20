/*
문제 링크
https://www.acmicpc.net/problem/2798

제한
시간 : 1 초    메모리 : 128 MB

문제
카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다. 블랙잭은 카지노마다 다양한 규정이 있다.
한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.
김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.
이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.

입력
첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다. 둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는 양의 정수이다.
합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.

출력
첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.
 */

/*
풀이
참고 블로그 : https://minhamina.tistory.com/38
조합을 구하는 문제같아서 조합 알고리즘을 공부한 뒤 풀었다.
조합인 이유는 수를 뽑는 모든 경우의 수를 탐색해 봐야 하는데 뽑는 순서가 결과에 미치는 영향이 없기 때문이다.

주어지는 N개의 숫자 중 3개를 뽑아서 M보다 작거나 같은 수 중 가장 큰 수를 만들면 되는데 이걸 알기 위해서는 조합이 가능한 모든 경우의 수를 탐색해 봐야 한다.
그래서 재귀로 n개 중에 3개를 뽑는 경우, n-1개 중에 2개를 뽑는 경우, n-2개 중에 1개를 뽑는 경우,... 로 탐색하다가
n-r개 중에 0개를 뽑는 경우가 되면 그동안 뽑은 수들의 합 중 M보다 작거나 같으면서 가장 큰 수를 찾으면 된다.

결과
시간 : 132 ms    메모리 : 14140 KB
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    static int arr[]; // 입력으로 주어지는 수들을 저장한 배열
    static boolean visited[]; // 어떤 수를 뽑았는지 표시할 배열 
    static int ans = 0; // 정답 
    static int N, M; // 입력으로 주어지는 N과 M

    // n개 중에서 r개를 뽑는 조합을 탐색하는 함수
    static void combination(int start, int n, int r, int sum)
    {
        if (0 == r)
        {
            if (M >= sum) // r개를 모두 뽑았으면 M보다 작거나 같은 경우에 최대값을 찾는다.
                ans = Math.max(ans, sum);

            return;
        }

        for (int i = start; i < n; i++)
        {
            // 현재 선택한 수에 방문표시를 하고
            visited[i] = true; 
            
            // 다음 순서부터 r-1개를 뽑는 경우를 탐색한다. 지금까지 뽑은 수들의 합을 구해야 하기 때문에 지금 뽑은 수를 더한 값을 넣어 재귀호출한다.
            combination(i + 1, n, r - 1, sum + arr[i]);
            
            // 위 재귀호출이 끝나고 나오면 이 수를 뽑지 않은 경우도 탐색해 봐야 하니까 방문해제 처리한다.
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // N개 중에서 3개 뽑는 조합의 합 탐색
        combination(0, N, 3, 0);
        bw.write(Integer.toString(ans));

        bw.flush();
        bw.close();
    }
}
