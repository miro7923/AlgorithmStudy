package AlgorithmStudy.ByungwooKim.Strings;

/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/8958
 *
 * # 문제
 * "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다.
 * 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.
 * "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다. OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 1초 / 메모리 제한: 128 MB
 *
 * # 입력
 * 첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고,
 * 길이가 0보다 크고 80보다 작은 문자열이 주어진다. 문자열은 O와 X만으로 이루어져 있다.
 *
 * # 출력
 * 각 테스트 케이스마다 점수를 출력한다.
 *
 */

import java.io.*;

public class BOJ_8958 {
    static int score = 0, sum = 0, count;
    static String result;
    static void calculate(String result){
        for(int i=0; i<result.length(); i++){
            if(result.charAt(i) == 'O'){
                score++; //O가 중복될때마다 올라갈 수 있는 점수는 1점씩 증가
                sum+=score;
            }
            else {
                score = 0;
                //X가 나오면 score는 다시 0부터 시작.
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(br.readLine());

        for (int i=0; i<count; i++){
            result = br.readLine();
            calculate(result);
            System.out.println(sum);
            score=0;    sum =0;
            //각 케이스마다 score와 sum을 0으로 초기화하지 않으면 전 케이스의 값들이 넘어온다.
        }
    }
}
