/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/11729
 *
 * # 문제
 * 세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 각 원판은 반경이 큰 순서대로 쌓여있다. 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.
 *
 * 1. 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
 * 2. 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
 *
 * 이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.
 *
 * # 제한
 * 시간제한: 1 초 / 메모리 제한:  	256 MB
 *
 * # 입력
 * 첫째 줄에 첫 번째 장대에 쌓인 원판의 개수 N (1 ≤ N ≤ 20)이 주어진다.
 *
 * # 출력
 * 첫째 줄에 옮긴 횟수 K를 출력한다.
 * 두 번째 줄부터 수행 과정을 출력한다. 두 번째 줄부터 K개의 줄에 걸쳐 두 정수 A B를 빈칸을 사이에 두고 출력하는데, 이는 A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다.
 *
 * # 풀이
 * 참고 : https://brenden.tistory.com/31
 * 하노이탑 이동 원리
 * 1. 작은 원반 n-1개를 첫번째 장대에서 두번째 장대로 이동시킨다
 * 2. 첫번째 장대에 남은 큰 원반 1개를 첫번째 장대에서 세번째로 이동시킨다.
 * 3. 그리고 두번째 장대에 남은 n-1개의 원반을 세번째 장대로 이동시킨다.
 *
 *
 * 재귀문제를 기초적인 팩토리얼이나 dfs로는 풀어봤지만 재귀함수에 매개변수를 여러개를 넣는 유형은 처음봤다.
 * 그리고 보면서도 이걸 어떻게 생각해내지?? 라는 고민을 되게 많이 했다.
 * 이러한 고민을 해결은 못했지만 나름 내린 결로능로는 이러한 패턴을 어느 정도 외워놓아야 할 것 같다.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int count;
    static int N;
    static StringBuilder sb = new StringBuilder();

    static void rec_func(int n, int first, int second, int third) {
        count++;
        // 원반이 1개일 때
        if (n == 1) {
            sb.append(first + " " + third + "\n");
        } else {
            // n-1개의 원판을 첫번째 장대에서 두번째 장대로 이동
            rec_func(n - 1, first, third, second);
            // 이동하는 과정을 기록. 원판 1개를 첫번째 장대에서 세번째 장대로 이동
            sb.append(first + " " + third + "\n");
            // n-1개의 원판을 두번째 장대에서 세번째 장대로 이동
            rec_func(n - 1, second, first, third);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rec_func(N, 1, 2, 3);
        System.out.println(count);
        System.out.println(sb.toString());
        sb.setLength(0);
    }
}
