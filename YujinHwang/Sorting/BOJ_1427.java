/*
문제 링크
https://www.acmicpc.net/problem/1427

제한
시간 : 2 초    메모리 : 128 MB

문제
배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

입력
첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
 */

/*
풀이
입력값을 모듈러와 나누기 연산을 하면서 한 자릿수씩 배열에 저장한 다음 Collections의 sort를 사용해 내림차순 정렬했다.

결과
시간 : 124 ms    메모리 : 14260 KB
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        while (0 < N)
        {
            // 배열에 담기
            int mod = N % 10;
            arr.add(mod);
            N *= 0.1; // 곱하기 연산이 더 빠름
        }

        // 내림차순 정렬
        Collections.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < arr.size(); i++)
            bw.write(Integer.toString(arr.get(i)));

        bw.flush();
        bw.close();
    }
}