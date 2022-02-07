/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/9012
 *
 * 문제
 * 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
 * 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
 * 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 2 초 / 메모리 제한: 128 MB
 *
 * # 입력
 * 첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다.
 * 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
 *
 *
 * # 출력
 * 첫째 줄에 그룹 단어의 개수를 출력한다.
 *
 * # 풀이
 * 입력받은 단어들을 순회하면서 각 문자마다 문자의 처음 나오는 index와 마지막으로 나오는 index값으로 String클래스의 subString()메서드를 이용하여 문자열을 자른다.
 * 그 자른 문자열들에서 각 문자들이 모두 동일하면 그룹단어이다.
 * ex) 1. "aabbeeac"를 자르면 첫번째 a와 마지막 a를 기준으로 자른 문자열 aabbeea들이 나오고 이는 동일한 문자들로 이루어지지 않았기 때문에 그룹단어가 아니다.
 *     2. "aaaabbbbbccccc"를 자르면 aaaa와 bbbb와 cccc 등 동일한 문자들로 이루어진 문자열들로 잘리고 이는 그룹단어이다.
 * 
 *
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1316 {

    static int N;
    static int count = 0; // 그룹단어의 개수
    static String word, temp; // 입력받을 단어와 임시로 사용할 temp
    static char[] wordToChar; //단어를 char배열안에 문자로 쪼개어 넣어서 다루기 쉽게하기 위함.

    static void countGroupWord() { // 그룹단어 개수 체크하기
        wordToChar = word.toCharArray();
        temp = "";
        for (int index = 0; index < wordToChar.length; index++) {
            int lastIndex = word.lastIndexOf(wordToChar[index]);    // 단어들중에 또 다른 같은 문자가 있는지 뒤에서 부터 체크한뒤 index값을 가져옴.
            temp = word.substring(index, lastIndex); // 시작 index에서 lastIndex까지 문자를 잘라 문자열 temp에 넣는다.

            //temp에 담긴 문자열들이 모두 같은 문자인지 체크하고 같지 않으면 그룹단어가 아니므로 더 이상 체크할 필요없이 이 메서드를 종료시킨다.
            for (int i = 0; i < temp.length(); i++) {
                if (wordToChar[index] != temp.charAt(i))
                    return;
            }
        }
        //위의 for문을 통과했다는 것은 그룹단어라는 것을 의미하고 그룹단어의 개수를 1씩 증가시킨다.
        count++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            word = br.readLine();
            countGroupWord();
        }

        System.out.println(count);
    }
}
