/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/10989
 *
 * # 문제
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 2 초 / 메모리 제한:  	256 MB
 *
 * # 입력
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다.
 * 이 수는 10,000보다 작거나 같은 자연수이다.
 *
 * # 출력
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 *
 * # 풀이
 * 처음엔 수 정렬하기2를 푼 코드를 그대로 넣어봤더니 안됐다. 입력받은 모든 수들을 배열에 넣어 정렬하려고 했기 때문이었다.
 * 시간과 메모리를 획기적으로 줄일 방법을 생각하다가 입력받을 수들이 10,000보다 작거나 같은 자연수임을 보고 생각을 달리해봤다.
 *
 * 결국 0부터 10000까지의 숫자배열만 있으면 되었다. 그리고 중복되는 수가 있기 때문에 그 숫자 인덱스에 1씩 증가시키는 count를 저장하면 되었다.
 * 예를 들면 5개의 숫자 8, 1, 10, 10, 60을 입력받으면 8, 1, 60번째 인덱스에는 각 1씩 더하여 1이 있을 것이고 10번째 인덱스의 경우에는 2가 들어있다.
 * 이런식으로 count를 저장한 배열들을 0부터 10000까지 순회하면서 0이 아니면 출력을 해주되 그 인덱스에 있는만큼 출력을 해주어야 한다.
 * 10번쨰 인덱스의 경우 2가 저장되어 있으므로 10은 2번 출력해준다.
 *
 * # 배운점
 * 시간은 1616 ms
 * 메모리는 481336 KB
 * 인데 다른사람과 비교해보니 상대적으로 메모리가 100000 KB가 높았다.. 
 * 메모리가 높게 나온 이유는 코드의 문제가 아니라 java의 버전 차이 때문이었다..
 * java 11로 돌려보니 336208 KB로 확 줄었다.. 버전마다 메모리 관리를 다르게 하나보다. 
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10989 {

    static int N;
    static int[] numsCount = new int[10001];
    static StringBuilder sb = new StringBuilder();
    static int num;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());
            numsCount[num]++;
        }
        br.close();
    }

    static void sort() {
        for (int i = 0; i < numsCount.length; i++) {
            if (numsCount[i] != 0) {
                for (int j = 0; j < numsCount[i]; j++) {
                    sb.append(i).append('\n');
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        sort();
        System.out.println(sb.toString());
    }
}
