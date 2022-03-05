/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/10814
 *
 * # 문제
 * 온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.
 * 이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 3 초 / 메모리 제한:  	256 MB
 *
 * # 입력
 * 첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)
 * 둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다.
 * 나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다.
 * 입력은 가입한 순서로 주어진다.
 *
 * # 출력
 * 첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.
 *
 * # 풀이
 * Comparable 인터페이스의 compareTo 메서드를 이용하여 정렬기준을 정해준다.
 * 구현객체는 나이와 이름을 받는다.
 * 나이가 같으면 이름을 String의 compareTo 메서드를 이용하여 비교하고 그렇지 않으면 나이를 기준으로 오름차순 정렬한다.
 *
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static Elem[] members;
    static class Elem implements Comparable<Elem> {
        public int age;
        public String name;
        @Override
        public int compareTo(Elem other) {
            if (age == other.age) name.compareTo(other.name);
            return age - other.age;
        }
    }
    static int N;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        members = new Elem[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            members[i] = new Elem();
            members[i].age = Integer.parseInt(st.nextToken());
            members[i].name = st.nextToken();
        }
    }
    static StringBuilder sb = new StringBuilder();
    static void sort(){
        Arrays.sort(members);
        for (int i=0; i<members.length; i++){
            sb.append(members[i].age).append(" ").append(members[i].name).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        sort();
        System.out.println(sb);
    }
}
