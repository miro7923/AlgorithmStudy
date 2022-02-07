/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1259
 *
 * 문제
 * 어떤 단어를 뒤에서부터 읽어도 똑같다면 그 단어를 팰린드롬이라고 한다. 'radar', 'sees'는 팰린드롬이다.
 * 수도 팰린드롬으로 취급할 수 있다. 수의 숫자들을 뒤에서부터 읽어도 같다면 그 수는 팰린드롬수다.
 * 121, 12421 등은 팰린드롬수다. 123, 1231은 뒤에서부터 읽으면 다르므로 팰린드롬수가 아니다.
 * 또한 10도 팰린드롬수가 아닌데, 앞에 무의미한 0이 올 수 있다면 010이 되어 팰린드롬수로 취급할 수도 있지만, 특별히 이번 문제에서는 무의미한 0이 앞에 올 수 없다고 하자.
 *
 * # 제한
 * 시간제한: 1 초 / 메모리 제한: 128 MB
 *
 * # 입력
 * 입력은 여러 개의 테스트 케이스로 이루어져 있으며, 각 줄마다 1 이상 99999 이하의 정수가 주어진다.
 * 입력의 마지막 줄에는 0이 주어지며, 이 줄은 문제에 포함되지 않는다.
 *
 *
 * # 출력
 * 각 줄마다 주어진 수가 팰린드롬수면 'yes', 아니면 'no'를 출력한다.
 *
 * # 풀이
 * StringBuilder 클래스의 reverse()메서드를 사용하여 입력받은 수들(nums)을 뒤집은 새로운 문자열 reverseNums를 만든다
 * nums와 reverseNums가 같은지 그리고 nums의 마지막 글자가 0이 아닌지의 조건을 만족하면 yes를 아니면 no를 출력한다.
 * 지금보니 굳이 마지막 글자가 0이 아닌지의 조건을 따질 필요가 없었다..
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1259 {

    static String nums;
    static char lastNum;
    static StringBuilder sb = new StringBuilder();

    static String check() { //뒤집은 수와 뒤집지 않은수가 동일한지 체크하는 메서드
        String reverseNums = sb.append(nums).reverse().toString(); // StringBuilder에 nums를 넣고 뒤집은 다음 다시 String으로 변환해주는 작업
        lastNum = nums.charAt(nums.length() - 1); 
        if (reverseNums.equals(nums) && lastNum != '0') { 
            return "yes";
        } else {
            return "no";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nums = br.readLine();
        while (!nums.equals("0")) { // "0"이 나오면 입력받는 것을 종료시켜야함.
            System.out.println(check());
            sb.setLength(0);
            nums = br.readLine();
        }
    }
}
