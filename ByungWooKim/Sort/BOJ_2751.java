/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2751
 *
 * # 문제
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 2 초 / 메모리 제한:  	256 MB
 *
 * # 입력
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다.
 * 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 *
 * # 출력
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 *
 * # 풀이
 * 입력받은 숫자들을 int배열에 담고 Arrays.sort로 정렬후 출력하니 시간초과..
 * ArrayList에 담고 Collections.sort로 정렬 후 출력하니 성공.
 * 메모리 : 214712 KB
 * 시간 : 1444 ms 
 * 서로 다른 정렬을 쓰는 건 알았는데 Arryas의 sort가 더 빠를 줄 알았는데 아니었다.
 * 각 경우마다 다른 거 같은데 Arryas의 sort와 Collections.sort의 차이점을 알아봐야겠다.
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static int N;
    static ArrayList<Integer> nums;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(br.readLine()));
        }
    }

    static void sort() {
        Collections.sort(nums);
        for (int i = 0; i < nums.size(); i++) {
            sb.append(nums.get(i)).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        sort();
        System.out.println(sb.toString());
    }
}
