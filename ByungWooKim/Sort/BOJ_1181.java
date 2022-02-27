/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1181
 *
 * # 문제
 * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
 * 1. 길이가 짧은 것부터
 * 2. 길이가 같으면 사전 순으로
 *
 * # 제한
 * 시간제한: 2 초 / 메모리 제한:  	256 MB
 *
 * # 입력
 * 첫째 줄에 단어의 개수 N이 주어진다.
 * (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다.
 * 주어지는 문자열의 길이는 50을 넘지 않는다.
 *
 * # 출력
 * 조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
 *
 * # 풀이
 * Comparable 인터페이스의 compareTo 메서드를 이용하여 정렬기준을 정해준다.
 * 구현객체는 단어의 길이와 단어를 받는다.
 * 길이가 같으면 String의 compareTo 메서드를 이용하여 비교하고 아니면 길이를 비교하여 짧은 것부터 긴 순서대로 정렬되게 한다.
 * 
 * 처음에 Comparable 말고 Stinrg 2차원 배열 만들어서 하려고 했다가 null값들로는 정렬할 수 없다는 걸 뒤늦게 깨닫고 
 * 그냥 편리하게 Comparable로 구현하여 쉽게 해결했다..
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    static int N;
    static Elem[] words;
    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem> {

        public String word;
        public int length;

        @Override
        public int compareTo(Elem other) {
            if (length == other.length) return word.compareTo(other.word);
            return length - other.length;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new Elem[N];

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words[i] = new Elem();
            words[i].word = word;
            words[i].length = word.length();
        }
        br.close();
    }

    static void sort() {
        Arrays.sort(words);

        for (int i = 0; i < N; i++) {
            if (i != 0 && words[i].word.equals(words[i - 1].word)) continue;
            sb.append(words[i].word).append('\n');
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        sort();
        System.out.println(sb);
    }
}
