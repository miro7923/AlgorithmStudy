/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2869
 *
 * # 문제
 * 땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
 * 달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
 * 달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 0.15 초 (추가 시간 없음) / 메모리 제한:  128 MB
 *
 * # 입력
 * 첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)
 *
 * # 출력
 * 첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.
 *
 *
 * # 풀이
 * 이걸 완전탐색(달팽이가 올라갔다 내려갔다하는 과정을 모두 기록)하는 건 10억개의 정수가 주어진다는 점에서 시간이 무수히 많이 걸린다.
 * 이걸 나눗셈으로 더 적은 계산과정으로 해결할 방법을 생각해보았다.
 * 나무막대의 정상에 도달하기 위해 그 전날 높이를 구하고
 *
 * 1) 그 전날의 높이에 A와 B를 뺀 값을 나눈 값이 0. 즉 그 전날의 높이가 딱맞게 정상 높이(V) - 올라갈수 있는 높이(A)이면
 * 전날의 높이에 A와 B를 뺀 값을 나누어 주면 그 전날 높이까지 도달하는데 걸린 총 일수가 나온다.
 * 2) 그 전날의 높이에 A와 B를 뺀 값을 나눈 값이 0이 아니면 즉 나누어 떨어지지 않으면
 * 전날의 높이에 A와 B를 뺀 값을 나누어 준 값에 1을 더하면 그 전날 높이보단 크고 정상보다는 작은 높이에 도달하는덱 걸린 총 일수가 나온다.
 *
 * ex) 5 1 6일때
 * 그 전날의 높이를 6 - 5 = 1이라고 가정하는데 실제로는 그 전날의 높이는 5 - 1 = 4이다.
 * 이러한 이유 때문에 전날의 높이에 A와 B를 뺀 값을 나눈값에 1을 더해주어야 했다.
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2869 {

    static int A, B, V;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
    }

    static int beforeEnd, day;

    static void calculate() {
        beforeEnd = V - A;  // 정상에 도달하기 직전 높이
        day = 1;    // 정상에 도달하려면 결국 직전 높이에서 1을 더해줘야하기 때문에 day는 1부터 시작한다.
        if (beforeEnd % (A - B) == 0) {
            day += beforeEnd / (A - B);
        } else {
            day += beforeEnd / (A - B) + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        calculate();
        System.out.println(day);
    }
}
