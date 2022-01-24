package AlgorithmStudy.ByungWooKim.Strings;

/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/11720
 *
 * # 문제
 * N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 1초 / 메모리 제한: 256 MB
 *
 * # 입력
 * 첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
 *
 * # 출력
 * 입력으로 주어진 숫자 N개의 합을 출력한다.
 *
 */
import java.io.*;

public class BOJ_11720 {

    static String nums;
    static int N;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(br.readLine());
        nums = br.readLine();
        for(int i=0; i<length; i++){
            N = nums.charAt(i) - 48;
            // charAt으로 가져오면 char타입이 되고 char 타입을 그대로 int타입으로 원하는 숫자를 가져올 수 없음.
            // char를 숫자로 바꾸기 위해서는 48을 뺴줘야 한다.
            // ex) '5'의 유니코드는 53. 숫자 5를 얻으려면 -48을 한다.
            sum += N;
        }

        System.out.println(sum);

    }
}
