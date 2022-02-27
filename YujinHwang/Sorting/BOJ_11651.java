/*
문제 링크
https://www.acmicpc.net/problem/11651

제한
시간 : 1 초    메모리 : 256 MB

문제
2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

출력
첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
 */

/*
풀이
11650번에서 썼던 Comparator 함수에서 기준값을 x에서 y로만 바꿔주었다.

결과
시간 : 860 ms    메모리 : 49896 KB
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Pair
{
    int x, y;

    public Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
}

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Pair> arr = new ArrayList<>();
        int x, y;
        Pair p;
        StringTokenizer st;
        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            p = new Pair(x, y);
            arr.add(p);
        }

        // Comparator 람다식으로 구현
        // 음수가 리턴되면 오른쪽에 있는 값이 내려가므로 아래와 같이 작성하면 문제의 조건대로 오름차순 정렬이 된다.
        Collections.sort(arr, (p1, p2)->{
            if (p1.getY() == p2.getY())
                return p1.getX() - p2.getX();
            else
                return p1.getY() - p2.getY();
        });

        for (Pair pair : arr)
            bw.write(pair.getX() + " " + pair.getY() + "\n");

        bw.flush();
        bw.close();
    }
}