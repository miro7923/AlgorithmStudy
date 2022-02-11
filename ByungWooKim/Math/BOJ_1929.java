/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1929
 *
 * # 문제
 * M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 2 초 / 메모리 제한:  	256 MB
 *
 * # 입력
 * 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
 *
 * # 출력
 * 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
 *
 * # 풀이
 * 2부터 N까지의 숫자들 중에서 소수를 찾아야 하는데 다른 소수 문제와는 달리 시간복잡도를 고려해야 했다.
 * 에라토스테네스의 체라는 소수 찾는 방법에 착안하여 코드로 구성했다.
 * 에라토스테네스의 체는 다음과 같다
 *
 * 구하고자하는 모든 수를 나열하고 소수가 나오면 그 소수를 제외한 소수의 배수들을 모두 제거한다.
 * 위의 과정을 2부터 구하고자 하는 수까지 모두 처리하면 남는 수들은 모두 소수이다.
 *
 * 내 풀이로는 메모리가 36480KB에 982ms가 나왔다.
 * 그러나 다른사람의 풀이를 보면 메모리가 22708KB에 340ms까지 줄일 수 있었다.
 *
 * # 배운점
 * 난 int배열로 소수가 아니라면 0으로 체크해주고 맞다면 그 소수값 그대로를 넣어줬는데
 * 더 빨랐던 풀이를 보면 boolean 배열로 인덱스가 소수인 값은 false로 소수가 아닌값은 true로 해서
 * 시간과 메모리의 차이가 났던 것 같다.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static int[] primeNums;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        primeNums = new int[N + 1];
        for (int i = 2; i <= N; i++) {  // i=2부터 시작하는 이유는 1은 소수가 아니기 때문에
            primeNums[i] = i;
        }
    }

    static void findPrimeNum() {    // 소수들을 찾아 출력하는 메서드
        int temp;
        for (int i = 2; i <= (int) Math.sqrt(N); i++) {
            temp = 2 * i;   //만약 i가 2이고 소수이기 때문에 2의 2배부터 2의 배수 즉 소수가 아니게된다.
            if (primeNums[i] != 0) {  // 미리 소수인지 아닌지 거르는 조건문
                // i가 소수일 경우 i의 배수들을 배열에서 제거해줌(에라토스테네스의 체 원리 이용)
                while (N >= temp) {
                    primeNums[temp] = 0;    // 소수이면 그 인덱스값에 0, 즉 소수가 아니라는 걸 체크함.
                    temp += i;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (primeNums[i] != 0)
                System.out.println(primeNums[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        findPrimeNum();
    }
}
