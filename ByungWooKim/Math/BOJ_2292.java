/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2292
 *
 * # 문제
 * 위의 그림과 같이 육각형으로 이루어진 벌집이 있다. 그림에서 보는 바와 같이 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다.
 * 숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오.
 * 예를 들면, 13까지는 3개, 58까지는 5개를 지난다.
 *
 * # 제한
 * 시간제한: 2 초 / 메모리 제한: 	128 MB
 *
 * # 입력
 * 첫째 줄에 N(1 ≤ N ≤ 1,000,000,000)이 주어진다.
 *
 *
 * # 출력
 * 입력으로 주어진 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나는지 출력한다.
 *
 *
 * # 풀이
 * 벌집의 형태를 보면 각 층(?)마다 방의 개수는 규칙이 있다.
 * 1층 -> 1          방의 개수 : 1개          지나가야하는 방 최수 개수 : 1개
 * 2층 -> 2 ~ 7      방의 개수 : 7개          지나가야하는 방 최수 개수 : 2개
 * 3층 -> 8 ~ 19     방의 개수 : 19개         지나가야하는 방 최수 개수 : 3개
 * ...
 * ...
 * n층 ->            방의 개수 : 1 + 6(n-1)개 지나가야하는 방의 수 : n개
 * 위의 규칙에 착안해 코드를 구성했다.
 *
 *
 */

import java.io.*;

public class BOJ_2292 {

    static int N;
    static int count = 1;   // 지나가야하는 방의 최소의 수를 계산하는 count. 어디든 최소 1칸은 지나야 하기 때문에 1로 초기화.

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    static int countRoom() {
        if (N == 1) return count;   // N이 1일 경우 1을 리턴.

        N += 4;         // 입력받은 숫자들을 계산하기 편리하게 4씩 더해주고 계산에 들어간다.
        int standard = 6;
        while (true) {
            standard += 6 * count;  // 기준값은 6과 지나가야하는 방의 수 count를 곱한 값을 계속 더한다.
            count++;
            if(N < standard)    // 기준값이 입력받은 값보다 작으면 멈춘다.
                break;
        }
        // while문의 로직이 돌아가는 과정
        // N이 13이면 4를 더한 17이 되고
        // 기준값은 6 -> 18 이런식으로 증가하다가 18이 되면 17인 N보다 크기 때문에 while문을 종료한다.
        // count의 값은 2(6과 18 두번 나옴) + 1인 즉 3이 된다.

        return count;
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(countRoom());
    }
}
