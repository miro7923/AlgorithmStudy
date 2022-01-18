package AlgorithmStudy.ByungWooKim.Greedy;

/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2839
 *
 * # 문제
 * 상근이는 요즘 설탕공장에서 설탕을 배달하고 있다. 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다. 설탕공장에서 만드는 설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
 * 상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다. 예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만, 5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.
 *상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 1초 / 메모리 제한: 128 MB
 *
 * # 입력
 * 첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)
 *
 *
 * # 출력
 * 상근이가 배달하는 봉지의 최소 개수를 출력한다. 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.
 *
 */

import java.io.*;

public class BOJ_11399 {
    static int N, totalCount, minTotalCount = Integer.MAX_VALUE;
    // 봉지의 개수가 최소가 되는 값을 찾을 것이기 때문에 Int형 중에서 최대값을 이용.

    static void calculate() {
        for(int x=0; x<=N/3; x++){ // 봉지의 수는 최대 N/3 개이므로 N/3 까지만 탐색하자!
            for(int y=0; y<=N/3; y++){
                if(5 * x + 3 * y == N){
                    totalCount = x + y;
                    minTotalCount = (minTotalCount > totalCount) ? totalCount : minTotalCount;
                }
            }
        }
        // 정확하게 N킬로 그램을 못만들면 minTotalCount는 처음에 선언한 MAX값 그대로이므로 -1로 바꿔준다.
        minTotalCount = (minTotalCount == Integer.MAX_VALUE) ? -1 : minTotalCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        calculate();
        System.out.println(minTotalCount);
    }
}
/*
배달해야하는 설탕의 무게가 늘어나면서 최소한의 봉지를 구하는 경우의 수
1 : -1;
2 : -1;
3 : 3, 1개;
4 : -1;
5 : 5, 1;
6 : 3 + 3, 2개;
7 : -1;
8 : 5 + 3 || 2개
9 : 3 + 6 || 1 + 2 = 3개
10 : 5 + 5 || 2개
11 : 5 + 6 || 1 + 2 = 3개
12 : 3 + 9 || 1 + 3 = 4개
13 : 10 + 3 || 2 + 1 = 3개
14 : 5 + 9 || 1 + 3 = 4개
15 : 5 + 10 || 1 + 2 = 3개
16 : 10 + 6 || 2 + 2 = 4개
17 : 5 + 12 || 1 + 4 = 5개
18 : 15 + 3 || 3 + 1 = 4개
19 : 10 + 9 || 2 + 3 = 5개
20 : 15 + 5 || 3 + 1 = 4개
21 : 15 + 6 || 3 + 2 = 5개
22 : 10 + 12 || 2 + 4 = 6개
23 : 20 + 3 || 4 + 1 = 5개

위를 보면 계속 설탕의 무게가 늘어나면서 어느정도 반복되는것 같아서
DP를 통해서도 풀 수 있을 것 같기도 하다.
 */
