/*
문제 링크
https://www.acmicpc.net/problem/10872

제한
시간 : 1 초    메모리 : 256 MB

문제
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.

출력
첫째 줄에 N!을 출력한다.
 */

/*
풀이
N팩토리얼이 1부터 N까지의 누적곱이기 때문에 누적합을 구하는 코드에서 곱하기로만 바꿨다.
단 구한 팩토리얼을 저장할 변수가 0부터 시작하면 무슨 수를 곱해도 0이 되어버리기 때문에 1부터 시작해야 하는 것만 주의하면 된다. 
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int ans = 1;
        for (int i = 1; N >= i; i++)
            ans *= i;

        bw.write(Integer.toString(ans));
        bw.close();
    }
}
