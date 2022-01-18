package AlgorithmStudy.ByungwooKim.DFS;

/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2667
 *
 * # 문제
 *
 * <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
 * 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
 * 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다.
 * <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 1초 / 메모리 제한: 192 MB
 *
 * # 입력
 * 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5 ≤ N ≤ 25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
 *
 *
 * # 출력
 * 첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
 *
 */

import java.io.*;
import java.util.*;

public class BOJ_2667 {

    static int N;
    static int count, NEED_VISIT = 1, VISITED = 2; // count는 각 단지마다 붙여야 하는 번호의 개수. answers배열에 담을 것임
    static BufferedReader br;

    static int[][] map;
    static ArrayList<Integer> answers; // 답을 담을 배열(정렬, 동적 할당 위해 ArrayList로)

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N + 2][N + 2];
        String temp;
        for (int i = 1; i <= N; i++) {
            temp = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = temp.charAt(j - 1) - 48;
            }
        }
    }

    static int dfs(int x, int y) {
        // 방분해야할 곳 즉 1이면 방문한곳으로 처리하고 동서남북으로 계속 탐색해주면서 1씩 증가시키고 caculate함수에서의 count로 반환
        if (map[x][y] == NEED_VISIT) {
            map[x][y] = VISITED;
            return 1 + dfs(x + 1, y) + dfs(x - 1, y) + dfs(x, y + 1) + dfs(x, y - 1);
        }
        return 0;
    }

    static void calculate() {
        answers = new ArrayList<>();
        // for문 없는 dfs()는 단지 하나만 체크하고 끝남. 전체 단지의 수와 각 단지에 붙여야 할 번호의 개수를 알아야 하므로 map 전체 탐색
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] != NEED_VISIT) continue;
                count = dfs(i, j);
                answers.add(count);
            }
        }

        //답들을 오름차순 정렬하라고 했기 때문에 정렬해주기. 처음 풀 때 정렬안해서 틀림.. 문제 꼼꼼히 확인하자
        Collections.sort(answers);
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        input();
        calculate();
        System.out.println(answers.size()); // 총 단지 수는 답을 담은 배열들의 크기
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(answers.get(i));
        }
    }
}
