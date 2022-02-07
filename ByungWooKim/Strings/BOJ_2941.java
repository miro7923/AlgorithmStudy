/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2941
 *
 * 문제
 * 예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.
크로아티아 알파벳	변경
č	c=
ć	c-
dž	dz=
đ	d-
lj	lj
nj	nj
š	s=
ž	z=
* 예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
* dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.
 *
 * # 제한
 * 시간제한: 1 초 / 메모리 제한: 128 MB
 *
 * # 입력
 * 첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
 * 단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.
 *
 *
 * # 출력
 * 입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 *
 * # 풀이
 * 크로아티아 알파벳 문자열들을 담은 배열을 만들고 입력으로 주어진 단어를 순회하면서 크로아티아 알파벳과 같다면 문자 한개로 바꿔주면(String클래스의 replace()메서드 사용) 결국 입력으로 주어진 단어들의 개수는 크로아티아 알파벳의 개수가 된다.
 * ex) 문자 'a'로 바꾼다고 하면 lj e s= nj ak => a e a a ak 이렇게 바뀐다. 이 문자열의 길이가 즉 정답이 된다.
 *
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941 {

    static String[] croatiaAlpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    static String word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();

        for(String alphabet : croatiaAlpha){
            word =  word.replace(alphabet, "a"); // 여기서 크로아티아 알파벳과 겹치지 않을만한 문자열이라면 "a"는 어느 것이 든 상관없음.
        }

        System.out.println(word.length());
    }
}
