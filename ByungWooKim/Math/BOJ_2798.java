/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2798
 *
 * # 문제
 * 카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다. 블랙잭은 카지노마다 다양한 규정이 있다.
 * 한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.
 * 김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.
 * 이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
 * N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.
 *
 * # 제한
 * 시간제한: 1 초 / 메모리 제한:  	128 MB
 *
 * # 입력
 * 첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다. 둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는 양의 정수이다.
 * 합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.
 *
 * # 출력
 * 첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.
 *
 * # 풀이
 * 첫번째 두번째 세번째 카드를 중복되지 않게 뽑는 경우의 수 중에서
 * 3장의 카드의 합이 M을 넘지 않을 때 차이를 기억해두고 각 경우의 수 중에서 차이가 제일 적을 때의 3장의 카드의 합이 정답이 된다.
 * 5 21
 * 5 6 7 8 9 일 경우
 * 3장의 카드를 중복되지 않게 뽑는 경우의 수는
 * {5,6,7}, {5,6,8}, {5,6,9}, {5,7,8}, {5,7,9}, {5,8,9}
 * {6,7,8}, {6,7,9}, {6,8,9}
 * {7,8,9}
 * 이렇게 있는데 3장의 카드의 합이 21과 가장 차이가 적은 경우는 {6,7,8} 이고 이 3장의 수의 합21이 정답이 된다.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] card;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        card = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
    }
    static int sum; // 3장의 합을 저장할 변수
    static void pro() {
        int diff = M;   // M에 가까운 숫자를 뽑아야 하므로
        for (int i = 0; i < N; i++) {   // 첫번째 카드 뽑았을 때
            if (M < card[i]) continue;

            for (int j = 0; j < N; j++) {   // 두번째 카드 뽑았을 때
                if (i == j) continue;
                if (M < card[i] + card[j]) continue;

                for (int k = 0; k < N; k++) {   // 세번째 카드 뽑았을 때
                    if (j == k || i == k) continue;
                    if (M < card[i] + card[j] + card[k]) continue;

                    if (M - (card[i] + card[j] + card[k]) <= diff) {
                        sum = card[i] + card[j] + card[k];
                        diff = M - sum;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
        System.out.println(sum);
    }
}
