/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2581
 *
 * # 문제
 * 자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.
 * 예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 이들 소수의 합은 620이고, 최솟값은 61이 된다.
 *
 * # 제한
 * 시간제한: 1 초 / 메모리 제한:  128 MB
 *
 * # 입력
 * 입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다.
 * M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.
 *
 * # 출력
 * M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다.
 * 단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.
 *
 * # 풀이
 * ArrayList자료구조를 활용하여 M이상 N이하의 소수들을 ArrayList에 넣는다.
 * 만약 ArrayList의 size가 0이라면 소수가 없다는 뜻이고 -1을 출력한다.
 * 소수들의 합은 간단히 M부터 N까지의 구한 소수들을 더해주면 된다.
 *
 * 소수를 구하는 로직은
 * 1이면 소수가 아니고
 * 2부터 자기자신의 수 앞까지를 순회하면서 자기자신의 수가 나누어 떨어지면 소수가 아니고
 * 자기자신의 수 앞까지 순회했는데도 나누어 떨어지는 수가 없으면 소수이다.
 *
 * ex) 61은 for문을 이용하여 i를 2부터 60까지 순회하였을때 61 % i == 0이 되는 경우가 한번도 없기 때문에 소수이다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2581 {

    static int M, N;
    static ArrayList<Integer> primeNums = new ArrayList<>();        // 소수들을 담을 집합 

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
    }

    static int sum;

    static void checkPrimeNum(int num) {    // 소수인지 체크하고 소수라면 sum에 더해주고, 그리고 ArrayList에 추가해준다.
        if (num == 1) return;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return;
            }
        }

        // 위의 과정을 모두 통과하면 num이 소수라는 것을 의미하므로 소수들의 집합에 num을 넣어주고 소수들의 합에 num을 더해준다.
        primeNums.add(num);
        sum += num;
    }


    public static void main(String[] args) throws IOException {
        input();
        for (int num = M; num <= N; num++) {    //M이상 N이하의 소수들을 찾는다.
            checkPrimeNum(num);
        }

        if (primeNums.size() == 0) {    // 소수들의 집합 primeNums의 크기가 0이라는 것은 소수가 없다는 것을 의미하기에 -1을
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(primeNums.get(0));
            // 소수들의 집합 primeNums에 소수들을 추가해줄때 작은수부터 넣어 준것이기 때문에 primeNums의 첫번째 수가 최솟값이다.
        }
    }
}
