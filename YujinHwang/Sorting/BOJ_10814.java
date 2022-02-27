/*
문제 링크
https://www.acmicpc.net/problem/10814

제한
시간 : 3 초    메모리 : 256 MB

문제
온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.
이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)

둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다.
나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다. 입력은 가입한 순서로 주어진다.

출력
첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.
 */

/*
풀이
Collections.sort()와 Comparator 람다식으로 구현했다.
회원의 나이가 같을 경우엔 가입한 순서대로 정렬하면 되는데 입력이 가입한 순서대로 주어지므로 나이가 같다면 정렬을 하지 않으면 된다.
그래서 Comparator에서 나이가 같을 때엔 0을 리턴하면 정렬을 하지 않고 넘어갈 것이고 나이가 다를 때에만 정렬 조건을 걸어주면 된다.

결과
시간 : 772 ms    메모리 : 49448 KB
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Person
{
    int age;
    String name;

    public Person(int age, String name)
    {
        this.age = age;
        this.name = name;
    }

    public int getAge() { return age; }
    public String getName() { return name; }
}

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Person> people = new ArrayList<>();
        StringTokenizer st;
        int age;
        String name;
        Person p;
        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            age = Integer.parseInt(st.nextToken());
            name = st.nextToken();
            p = new Person(age, name);
            people.add(p);
        }

        // 나이가 같을 때 0을 리턴하면 정렬하지 않고 넘어가니까 입력된 순서 그대로 정렬이 될 것이고
        // 나이가 다를 때에만 오름차순으로 정렬되도록 한다.
        Collections.sort(people, (p1, p2)->{
            if (p1.getAge() == p2.getAge())
                return 0;
            else
                return p1.getAge() - p2.getAge();
        });

        for (int i = 0; i < N; i++)
            bw.write(people.get(i).getAge() + " " + people.get(i).getName() + "\n");

        bw.flush();
        bw.close();
    }
}