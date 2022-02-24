/*
문제 링크
https://www.acmicpc.net/problem/7568

제한
시간 : 1 초    메모리 : 128 MB

문제
우리는 사람의 덩치를 키와 몸무게, 이 두 개의 값으로 표현하여 그 등수를 매겨보려고 한다. 어떤 사람의 몸무게가 x kg이고 키가 y cm라면 이 사람의 덩치는 (x, y)로 표시된다.
두 사람 A 와 B의 덩치가 각각 (x, y), (p, q)라고 할 때 x > p 그리고 y > q 이라면 우리는 A의 덩치가 B의 덩치보다 "더 크다"고 말한다.
예를 들어 어떤 A, B 두 사람의 덩치가 각각 (56, 177), (45, 165) 라고 한다면 A의 덩치가 B보다 큰 셈이 된다. 그런데 서로 다른 덩치끼리 크기를 정할 수 없는 경우도 있다.
예를 들어 두 사람 C와 D의 덩치가 각각 (45, 181), (55, 173)이라면 몸무게는 D가 C보다 더 무겁고, 키는 C가 더 크므로, "덩치"로만 볼 때 C와 D는 누구도 상대방보다 더 크다고 말할 수 없다.

N명의 집단에서 각 사람의 덩치 등수는 자신보다 더 "큰 덩치"의 사람의 수로 정해진다. 만일 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1이 된다.
이렇게 등수를 결정하면 같은 덩치 등수를 가진 사람은 여러 명도 가능하다. 아래는 5명으로 이루어진 집단에서 각 사람의 덩치와 그 등수가 표시된 표이다.

이름	(몸무게, 키)	덩치 등수
A	(55, 185)	2
B	(58, 183)	2
C	(88, 186)	1
D	(60, 175)	2
E	(46, 155)	5
위 표에서 C보다 더 큰 덩치의 사람이 없으므로 C는 1등이 된다. 그리고 A, B, D 각각의 덩치보다 큰 사람은 C뿐이므로 이들은 모두 2등이 된다.
그리고 E보다 큰 덩치는 A, B, C, D 이렇게 4명이므로 E의 덩치는 5등이 된다. 위 경우에 3등과 4등은 존재하지 않는다. 여러분은 학생 N명의 몸무게와 키가 담긴 입력을 읽어서 각 사람의 덩치 등수를 계산하여 출력해야 한다.

입력
첫 줄에는 전체 사람의 수 N이 주어진다. 그리고 이어지는 N개의 줄에는 각 사람의 몸무게와 키를 나타내는 양의 정수 x와 y가 하나의 공백을 두고 각각 나타난다.
2 ≤ N ≤ 50
10 ≤ x, y ≤ 200

출력
여러분은 입력에 나열된 사람의 덩치 등수를 구해서 그 순서대로 첫 줄에 출력해야 한다. 단, 각 덩치 등수는 공백문자로 분리되어야 한다.
 */

/*
풀이
처음에 너무 어렵게 생각해서 덩치 순서대로 배열을 정렬한 다음 정렬한 배열을 다시 순회하면서 정렬된 순서대로 등수를 매기는 방법을 썼는데 틀렸다.
그 후 질문게시판 반례를 찾아보니까 어렵게 생각할 문제가 아니라 내 앞에 있는 사람이 몇 명인지 세는 문제여서 그렇게 수정하니까 통과되었다.

통과 후 배열 순회 횟수 추가 유무에 따라 실행속도가 궁금해져서
등수를 배열에 저장한 다음 마지막에 배열을 순회하면서 출력하는 방식 - 14268KB	124ms
등수를 저장하는 배열을 사용하지 않고 등수를 구하는 즉시 BufferedWriter로 출력하는 방식 - 14416KB 	132ms
등수를 저장하는 배열을 사용하지 않고 등수를 구하는 즉시 StringBuilder에 저장한 후 출력하는 방식으로 풀어 봤는데 - 15904KB	 144ms
첫번째가 메모리를 가장 적게 쓰고 속도도 가장 빨랐다.

결과
시간 : 124 ms    메모리 : 14268 KB
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Pair
{
    int weight;
    int height;

    Pair(int weight, int height)
    {
        this.weight = weight;
        this.height = height;
    }
}

public class Main
{
    static BufferedWriter bw;
    static int N;
    static Pair input[];
    static int grade[];
    static StringBuilder sb;

    static public void getGrade()
    {
        for (int i = 0; i < N; i++)
        {
            int cnt = 0;
            for (int j = 0; j < N; j++)
            {
                if (i == j) continue;

                if (input[i].weight < input[j].weight && input[i].height < input[j].height)
                    cnt++; // 나보다 덩치가 큰 사람의 수를 센다.
            }

            grade[i] += cnt; // 한 명에 대한 검사가 끝날 때마다 센 사람의 수를 더해준다.
//            sb.append(cnt + "\n");
            //bw.write(Integer.toString(cnt) + "\n");
            //bw.flush();
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        input = new Pair[N];
        for (int i = 0; i < N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            input[i] = new Pair(a, b);
        }

        grade = new int[N];
        Arrays.fill(grade, 1); // 모든 사람이 1등이라고 가정하고 시작
        getGrade();

        for (int i = 0; i < N; i++)
            bw.write(Integer.toString(grade[i]) + "\n");

//        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}
