/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1011
 *
 * # 문제
 * 우현이는 어린 시절, 지구 외의 다른 행성에서도 인류들이 살아갈 수 있는 미래가 오리라 믿었다.
 * 그리고 그가 지구라는 세상에 발을 내려 놓은 지 23년이 지난 지금, 세계 최연소 ASNA 우주 비행사가 되어 새로운 세계에 발을 내려 놓는 영광의 순간을 기다리고 있다.
 * 그가 탑승하게 될 우주선은 Alpha Centauri라는 새로운 인류의 보금자리를 개척하기 위한 대규모 생활 유지 시스템을 탑재하고 있기 때문에,
 * 그 크기와 질량이 엄청난 이유로 최신기술력을 총 동원하여 개발한 공간이동 장치를 탑재하였다.
 * 하지만 이 공간이동 장치는 이동 거리를 급격하게 늘릴 경우 기계에 심각한 결함이 발생하는 단점이 있어서, 이전 작동시기에 k광년을 이동하였을 때는 k-1 , k 혹은 k+1 광년만을 다시 이동할 수 있다.
 *
 * 예를 들어, 이 장치를 처음 작동시킬 경우 -1 , 0 , 1 광년을 이론상 이동할 수 있으나 사실상 음수 혹은 0 거리만큼의 이동은 의미가 없으므로 1 광년을 이동할 수 있으며,
 * 그 다음에는 0 , 1 , 2 광년을 이동할 수 있는 것이다. ( 여기서 다시 2광년을 이동한다면 다음 시기엔 1, 2, 3 광년을 이동할 수 있다. )
 *
 * 김우현은 공간이동 장치 작동시의 에너지 소모가 크다는 점을 잘 알고 있기 때문에 x지점에서 y지점을 향해 최소한의 작동 횟수로 이동하려 한다.
 * 하지만 y지점에 도착해서도 공간 이동장치의 안전성을 위하여 y지점에 도착하기 바로 직전의 이동거리는 반드시 1광년으로 하려 한다.
 * 김우현을 위해 x지점부터 정확히 y지점으로 이동하는데 필요한 공간 이동 장치 작동 횟수의 최솟값을 구하는 프로그램을 작성하라.
 *
 * # 제한
 * 시간제한: 2 초 / 메모리 제한:  	512 MB
 *
 * # 입력
 * 입력의 첫 줄에는 테스트케이스의 개수 T가 주어진다.
 * 각각의 테스트 케이스에 대해 현재 위치 x 와 목표 위치 y 가 정수로 주어지며, x는 항상 y보다 작은 값을 갖는다. (0 ≤ x < y < 231)
 *
 * # 출력
 * 각 테스트 케이스에 대해 x지점으로부터 y지점까지 정확히 도달하는데 필요한 최소한의 공간이동 장치 작동 횟수를 출력한다.
 *
 * # 스스로 했던 풀이(시간초과)
 *
 * 현위치를 x라고 하고 y를 목적지라고 했을 때
 * 1. 현위치에서 i=1부터 1씩 계속 증가하면서 i만큼 위치를 옮겨준다.
 * 2. 만약 1부터 i까지의 합이 [목적지 - 현위치] 보다 커지면 i를 더이상 증가시키면 안되고 다시 i를 1 빼준다. (처음 이동거리는 1광년 목적지 직전 이동거리는 1광년이기 때문에)
 * 3. 위의 과정을 반복하면서 i만큼 옮겨줄때마다 횟수를 센다.
 * ex) x가 1 y가 15이면
 * 1 2 4 7 까지는 +1 +2 +3 으로 현위치를 이동시켜주다가 현위치 7에서 i가 4가 되면 1부터 i까지의 합이 4 + 3 + 2 + 1 = 10이고 7에서 10을 더하면 목적지 15를 넘어가기 때문에
 * i를 다시 3으로 만들어 준다. 그리고 다시 1부터 3까지의 합 6은 남은 거리 8(15-7) 보다 작기 때문에 현위치에 +3을 해서 현위치는 10이 된다.
 * 아직 남은거리가 5(15-10)로 0이 아니기 때문에 계속 위의 풀이를 계속하는데
 * i가 3일때 남은거리 5보다 i까지의 합 6이 더 크기 때문에 i를 2로 만든다.
 * i가 2일때 남은거리 5보다 i까지의 합 3이 더 작기 때문에 현 위치에 +2를 해서 현위치는 12가 된다.
 * 나머지 연산은 위의 로직대로 하면 현위치에 +2, +1을 하게 되고 목적지까지의 남은거리가 0이 된다.
 * 여기까지의 풀이에서 현 위치를 이동시킬 때마다 count를 1씩 증가시켜주면 정답이 된다.
 *
 * 목적지 까지의 최대거리는 2^31이었고 내가 풀었던 완전탐색(?)방법으로는 시간초과가 나왔다.
 *
 * # 질문게시판 참고 풀이 - 시간 100ms, 메모리 11676KB
 * 질문게시판에서 1 + 2 + ... + n-1 + n + n-1 ..... 2 + 1 = n ^ 2 라는 힌트를 얻어서 시간을 엄청나게 줄일 수 있었다.
 * 위의 식을 토대로 내 풀이를 바꿔 보면
 * 1. move = 1부터 1씩 계속 증가시킨다. (이동거리를 1씩 증가)
 * 2. 이동거리의 제곱이 목적지까지의 거리보다 커지면 이동거리를 -1 해주고 목적지에서 이동거리의 제곱을 빼주고 count는 (이동거리-1) * 2 + 1이다.
 * 3. 위에서 구한 이동거리에서 1까지 목적지와 현 위치가 동일할 때까지
 * - 현위치에서 이동거리를 더한 것이 목적지보다 작으면 현위치에 이동거리를 더해주고 count를 1 증가시킨다.
 * - 현위치에서 이동거리르 더한 것이 목적지보다 크면 이동거리는 -1을 해준다.
 *
 * ex) x가 1 y가 15이면
 * 목적지까지의 거리는 14이고 이동거리 = 1에서 1씩 증가시키다가 이동거리가 4일 때는 제곱 값이 16으로 14보다 커진다. 따라서 최대 이동거리는 3이 된다.
 * 이 때 목적지 15에서 최대 이동거리 3의 제곱 9를 빼면 목적지는 6이 된다. count는 (3 - 1) * 2 + 1 = 5이다.
 *
 * 그리고 목적지 6은 현위치 1과 동일하지 않고 위의 풀이에서 이동거리는 3이라는 것을 이용해서
 * 1에서 3을 더하면 6보다 작아서 현위치는 1 + 3 = 4 count는 5 + 1 = 6
 * 목적지 6은 현위치 4와 동일하지 않고
 * 4에서 3을 더하면 목적지 6보다 크기 때문에 이동거리를 -1 해서 이동거리는 2가 된다.
 * 4에서 2를 더하면 목적지 6보다 크지 않기 때문에 현위치는 4 + 2 = 6, count는 6 + 1 = 7
 * 목적지 6과 현위치 6이 동일하기 때문에 이 때의 count 7이 정답이다.
 *
 *
 * 글로 적으니 되게 헷갈린다,, 내가 풀이를 어렵게 한 것일 수도 있다..
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1011 {


    static int current, destination;    //현위치 current, 목적지 destination
    static int count, move;     //최소 작동횟수를 셀 count, 이동가능한 거리 move

    static void calculate() {
        move = 0;
        count = 0;
        // 최대로 이동할 수 있는 거리를 구하고 이 때 목적지에서 최대 이동할 수 있는 거리를 빼주고 count를 계산한다.
        // 이 과정으로 시간을 매우 줄일 수 있다.
        while (true) {
            // 1부터 n까지 + n-1부터 1까지의 합은 n^2라는 것을 이용
            if (Math.sqrt(destination - current) < move) {  // 제곱근을 쓰는 이유는 최대거리가 int형의 최대범위라서 제곱으로 표시할 경우 int형 범위를 넘는다.
                move--;
                destination -= move * move;
                count = (move - 1) * 2 + 1;
                break;
            }

            move++;
        }
        
        // 최대로 이동할 수 있는 거리에서 1까지 현위치에서 목적지가 동일할 때까지 현위치에 최대 이동가능한 거리를 더해주고 count를 계산한다.
        while (destination != current) {
            //현 위치에서 이동가능한 거리가 목적지보다 작거나 같으면 현위치를 이동가능한 거리만큼 이동시켜주고 count를 1증가시킨다.
            if (current + move <= destination) { 
                current += move;
                count++;
                continue;
            }
            //현 위치에서 이동가능한 거리가 목적지보다 크면 이동가능한 거리를 1씩 줄여준다.
            move--;
        }
    }

    static int T;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            current = Integer.parseInt(st.nextToken());
            destination = Integer.parseInt(st.nextToken());
            calculate();
            System.out.println(count);
        }
    }
