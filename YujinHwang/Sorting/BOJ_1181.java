/*
문제 링크
https://www.acmicpc.net/problem/1181

제한
시간 : 2 초    메모리 : 256 MB

문제
알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

1. 길이가 짧은 것부터
2. 길이가 같으면 사전 순으로

입력
첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.

출력
조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
 */

/*
풀이
Collections.sort와 Comparator 람다식을 이용해 구현했다.
마지막에 정렬한 값을 출력할 때엔 equals를 통한 value 비교를 해서 중복값은 걸러지도록 했다.

결과
시간 : 392 ms    메모리 : 23208 KB
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
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < N; i++)
            arr.add(br.readLine());

        // 길이 순으로 오름차순 정렬하되 길이가 같으면 사전순으로 정렬한다.
        // String class에 오버라이딩되어 있는 compareTo 함수를 이용하면 s1이 사전순으로 빠를 때 양수를 리턴하므로 오름차순 정렬이 된다.
        Collections.sort(arr, (s1, s2)->{
            if (s1.length() == s2.length())
                return s1.compareTo(s2);
            else
                return s1.length() - s2.length();
        });

        // 중복값은 제거하고 출력이 되어야 하는데 비교할 때 == 연산자를 쓰면 주소 비교가 되어서 항상 false가 리턴되므로 equals()를 통해 value 비교를 한다.
        bw.write(arr.get(0) + "\n");
        for (int i = 1; i < N; i++)
        {
            if (arr.get(i).equals(arr.get(i - 1))) continue;

            bw.write(arr.get(i) + "\n");
        }

        bw.flush();
        bw.close();
    }
}