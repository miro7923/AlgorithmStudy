/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/18870
 *
 * # 문제
 * 수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
 * Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.
 * X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.
 *
 * # 제한
 * 시간제한: 2 초 / 메모리 제한:  	512 MB
 *
 * # 입력
 * 첫째 줄에 N이 주어진다.
 * 둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.
 *
 * # 출력
 * 첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.
 *
 * # 제한
 * 1 ≤ N ≤ 1,000,000
 * -109 ≤ Xi ≤ 109
 *
 * # 풀이
 * Comparable 인터페이스를 이용한다.
 * 구현객체는 입력받을 숫자들의 입력받는 순서를 order라는 int값으로 입력받는 숫자들은 num으로 받는다.
 * 순서를 따로 필드로 넣은 이유는 출력할 정답들은 입력받은 순서대로 출력을 해야하는데
 * 정렬하고 입력받은 값들을 순서대로 다 비교할려면 n^2이라는 시간초과가 발생하기때문에 따로 order 값을 기억하기 위해 넣어줬다.
 *
 * 1. 구현객체들의 배열은 num을 기준으로 오름차순 정렬한다.
 * 2. 정답을 담을 배열에 중복을 체크하면서 정렬한 구현객체들의 order값에 해당하는 인덱스에 count(정렬되어 있으므로 구현객체들의 index값)를 넣어준다.
 * 3. 정답을 담은 배열을 순서대로 출력한다.
 *
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int answer[];    // 정답을 담을 배열
    static Elem[] points;   // 입력받을 좌표들

    static class Elem implements Comparable<Elem> {
        public int order, num;  // 입력받은 순서와, 입력받은 숫자들

        @Override
        public int compareTo(Elem other) {  //오름차순 정렬
            return num - other.num;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = new int[N];
        points = new Elem[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            points[i] = new Elem();
            points[i].num = num;
            points[i].order = i;
        }
    }

    static StringBuilder sb = new StringBuilder();

    static void sort() {
        Arrays.sort(points);
        int count = 0;
        answer[points[0].order] = count;
        for (int i = 1; i < points.length; i++) {
            // 정렬을 했기 때문에 count값을 index값으로 하는데 중복되는 값이 나오면 count에서 1을 빼주면 된다.
            if (points[i].num == points[i-1].num) count--;

            count++;
            answer[points[i].order] = count;
        }

        for (int i=0; i<answer.length; i++) sb.append(answer[i]).append(" ");
    }

    public static void main(String[] args) throws IOException {
        input();
        sort();
        System.out.println(sb);
    }
}
