/*
문제 링크
https://www.acmicpc.net/problem/10989

제한
시간 : 3 초    메모리 : 512 MB

문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 */

/*
풀이
자바는 제한시간 3초에 메모리 제한은 512라 컬렉션을 쓸 수 없었다.(처음에 컬렉션 sort 써 봤는데 메모리 초과됨 ㅠ)
int 배열 메모리 계산해 보니까 합병정렬을 할 수 있을 정도가 되어서 합병정렬을 구현했다.
N의 최대값 10,000,000 * 4byte(int) = 40,000,000byte = 39,062kb = 약 38mb
합병정렬은 정렬할 배열과 같은 크기의 배열이 하나 더 필요하기 때문에 38 * 2 = 약 76mb
그래서 자바에서 기본적으로 잡아먹는 메모리를 더해도 통과할 수 있을거 같아서 합병정렬로 풀었는데 시간이 좀 아슬아슬했다.

결과
시간 : 2948 ms    메모리 : 383572 KB
 */

import java.io.*;

public class Main
{
    static int arr[]; // 원본배열
    static int tmp[]; // 정렬 결과를 저장할 임시배열

    public static void merge(int l, int m, int r)
    {
        int left = l; // 왼쪽 부분배열의 시작 인덱스
        int right = m + 1; // 오른쪽 부분배열의 시작 인덱스
        int idx = l;

        // 정렬된 결과를 저장할 임시배열의 절반이 찰 때까지 왼쪽과 오른쪽 arr 원소의 크기를 비교해서 임시배열에 정렬한다.
        while (left <= m && right <= r)
        {
            if (arr[left] < arr[right])
                tmp[idx++] = arr[left++];
            else
                tmp[idx++] = arr[right++];
        }

        if (left > m) // 왼쪽은 다 채웠고 오른쪽이 남아있는 경우
        {
            while (right <= r)
                tmp[idx++] = arr[right++];
        }
        else // 오른쪽은 다 채웠고 왼쪽이 남아있는 경우
        {
            while (left <= m)
                tmp[idx++] = arr[left++];
        }

        // 정렬된 배열을 원본에 복사
        for (int i = l; i <= r; i++)
            arr[i] = tmp[i];
    }

    public static void mergeSort(int l, int r)
    {
        // 왼쪽과 오른쪽 피봇이 같아질 때까지 쪼갠다.
        if (l == r) return;

        // 쪼갤 수 있는 단위가 최소가 되면 정렬 후 합병 시작
        int m = (l + r) / 2;
        mergeSort(l, m);
        mergeSort(m + 1, r);
        merge(l, m, r);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tmp = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        mergeSort(0, N - 1);

        for (int i = 0; i < N; i++)
            bw.write(arr[i] + "\n");

        bw.flush();
        bw.close();
    }
}