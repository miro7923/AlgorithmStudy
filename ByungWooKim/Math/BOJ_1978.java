/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1978
 *
 * # 문제
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 2 초 / 메모리 제한:  128 MB
 *
 * # 입력
 * 주어진 수들 중 소수의 개수를 출력한다.
 *
 * # 출력
 * 첫째 줄에 A+B를 출력한다.
 *
 * # 풀이
 * 소수는 1과 자기 자신을 제외하고는 약수를 가져서는 안된다.
 *
 * 따라서 1부터 주어지는 수까지 쭉 돌면서 만약 나누어 떨어지는 수가 있으면 소수가 아니라고 판정하면 되고
 * 주어지는 수 앞까지 나누어 떨어지는 수가 없다면 소수라고 판정하고 count를 1 증가시켜주면 된다.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978 {

    static int N;
    static int[] nums;  //주어지는 수들을 입력 받을 배열

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i< nums.length; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    static int count;

    static void checkPrimeNum(int num) {    //소수인지 판정하고 count를 계산해주는 메서드
        if(num == 1) return;    // 1은 소수가 아니다. 따라서 return을 해준다.

        //주어지는 수 앞까지만 탐색하여 나누어 떨어진다면 자기 자신을 제외한 나머지의 수로 나누어 떨어지는 것이므로 소수가 아니다.
        for (int i = 2; i < num; i++) {
            if(num % i == 0){   
                return;
            }
        }
        
        //위의 로직을 통과하면 소수라는 것을 알 수 있고 따라서 count를 계산해준다.
        count++;
    }


    public static void main(String[] args) throws IOException {
        input();
        for (int num : nums) {  //주어진 수들을 모두 체크하여 소수인지 체크하면서 count를 계산해준다.
            checkPrimeNum(num);
        }
        System.out.println(count);
    }
}
