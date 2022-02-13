/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2292
 *
 * # 문제
 * 무한히 큰 배열에 다음과 같이 분수들이 적혀있다.

1/1	1/2	1/3	1/4	1/5	…
2/1	2/2	2/3	2/4	…	…
3/1	3/2	3/3	…	…	…
4/1	4/2	…	…	…	…
5/1	…	…	…	…	…
…	…	…	…	…	…
* 이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
* X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
*
 * # 제한
 * 시간제한: 0.5 초 (추가 시간 없음) / 메모리 제한:  256 MB
 *
 * # 입력
 * 첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.
 *
 * # 출력
 * 첫째 줄에 분수를 출력한다.
 *
 *
 * # 풀이
 * 각 배열에 따른 X를 구하면 아래와 같다.
 * 1/1	1/2	1/3	1/4	1/5	…
 * (1)  (2) (6) (7) (15)
 * 2/1	2/2	2/3	2/4	…	…
 * (3)  (5) (8) (14)
 * 3/1	3/2	3/3	…	…	…
 * (4)  (9) (13)
 * 4/1	4/2	…	…	…	…
 * (10) (12)
 * 5/1	…	…	…	…	…
 * (11)
 *
 * 오른 대각선 '/' 의 형태로 각 숫자가 증가하거나 감소하는 형태를 볼 수 있는데 1 / 2 3 / 4 5 6 / 7 8 9 10
 * 각 대각선 상 숫자의 개수는 1씩 계속 증가한다.
 * 난 각 대각선마다 기준값(1,3,4,10)을 구했다.
 * 지그재그순서기 때문에 홀수번째 대각선일 때는 기준값이 시작값 (1, 4)가 되고 짝수번째 대각선일 때는 기준값이 끝값 (3, 10)이 되었다.
 * 분자와 분모값은 대각선 상의 숫자의 개수가 최대값이 되고 1이 최소값이 되는데 예를 들면 1/3의 경우 분자는 1이고 분모는 3인데 1/3이 있는 대각선상의 개수 또한 3이다.
 * 입력받은 값에서 기준값과의 차이는 분자와 분모를 각각 증가시키거나 빼서 원하는 분자,분모 값을 얻어낼 수 있다.
 *
 * ex) 입력받은 값이 14일 경우
 * 5번째 대각선 상에 있고 이 대각선 상의 숫자의 개수는 5개이고 기준값은 15가 되고 이 때 분자와 분모는 1/5이다.
 * 기준값과의 차이가 1이나는데 이를 분자와 분모에 각각 1씩 더하거나 빼주면 2/4라는 정답이나온다.
 *
 *
 * # 아쉬운 점
 * 풀면서도 헷갈렸던 것들이 많은 만큼 풀이도 뭔가 직관적으로 이해갈만하게 적은 것 같지가 않다.
 * 풀이 방법을 생각할 때 좀 더 다양한 관점에서 보도록 노력해야겠다..
 * 안되는 방법을 고집하다가 시간이 너무 오래걸렸다.
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int X;   //입력받을 값
    static int numerator, denominator; //각각 분자와 분모를 나타내는 수

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
    }

    static int standard, count;    // 기준으로 삼을 값과 '/' 대각선 형태로 증가하는 개수

    static void getFractionOrder() {
        getStandard();
        System.out.println(count);
        System.out.println(standard);
        int diff = standard - X;    //이 차이 값으로 기준값에서 분자와 분모를 얼만큼 증가시키고 뺄지를 결정한다.

        // 지그재그순서로 되어있기 때문에 count의 개수가 짝수일 때는 분모가 개수로 분자가 1이 되고 홀수일 때는 그 반대가 된다.
        if (count % 2 == 0) {
            denominator = count;
            numerator = 1;
            denominator -= diff;
            numerator += diff;
        } else {
            denominator = 1;
            numerator = count;
            denominator += diff;
            numerator -= diff;
        }
        sb.append(denominator).append("/").append(numerator);
    }

    static void getStandard() {
        standard = 0;
        while (true) {
            count++;
            standard += count;  // 각 대각선의 기준값(시작값)은 그 전 기준값에 개수를 더한 값. 1 (1/1) -> 3 (2/1) -> 6 (1/3) -> 10 (1/4)
            if (X <= standard)
                break;
        }
    }


    public static void main(String[] args) throws IOException {
        input();
        getFractionOrder();
        System.out.println(sb.toString());
    }
}
