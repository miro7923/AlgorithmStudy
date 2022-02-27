/*
문제 링크
https://www.acmicpc.net/problem/2108

제한
시간 : 2 초    메모리 : 256 MB

문제
수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.

산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이
N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.

출력
첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.

둘째 줄에는 중앙값을 출력한다.

셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.

넷째 줄에는 범위를 출력한다.
 */

/*
풀이
각 알고리즘 자체는 어렵지 않았는데 종류가 많아서 그런가 구현에 시간이 걸렸다.
중앙값 구하는 알고리즘을 더 손에 익히면 좋겠다.
중앙값은 최대힙과 최소힙을 사용해서 중앙값보다 더 큰 수는 최소힙에 저장하고 작은 수는 최대힙에 저장한 후 
최대힙과 최소힙의 길이가 같은 경우 top 평균을 구하고 최대힙이 더 크면 최대힙의 top을 반환하고 최소힙이 더 크면 최소힙의 top을 반환하도록 했다.

최빈값은 배열 인덱스에 1:1로 매핑시켜서 빈도를 구하는 방식은 입력값의 범위가 커서 비효율적일 거 같아서 map을 사용했다.
입력값을 <입력값, 빈도> 로 map에 저장한 후 입력이 끝나면 map을 순회하면서 가장 높은 빈도수를 구한 다음
가장 높은 빈도수와 일치하는 키값이 하나라면 그걸 바로 리턴하고 여러 개라면 그 수를 모두 배열에 저장한 뒤 오름차순으로 정렬해서 두번째로 작은 수를 구해서 리턴했다.

범위는 입력 받으면서 최댓값과 최솟값을 구해서 두 값의 차를 출력하면 되는데 입력값이 음수도 들어오기 때문에 최댓값을 저장하는 변수의 초기값은 0이 아닌 Integer의 가장 작은 value로 설정하면 된다.

결과
시간 : 1028 ms    메모리 : 105020 KB
 */

import java.io.*;
import java.util.*;

public class Main
{
    static int N, mid;
    static ArrayList<Integer> arr;
    static PriorityQueue<Integer> minHeap;
    static PriorityQueue<Integer> maxHeap;
    static TreeMap<Integer, Integer> cntMap;

    public static int getMid()
    {
        // 두 힙의 사이즈가 같으면 top 값의 평균을 반환한다.
        if (minHeap.size() == maxHeap.size())
            return (minHeap.peek() + maxHeap.peek()) / 2;

        // 최소힙이 더 크면 최소힙의 top을 반환한다.
        if (minHeap.size() > maxHeap.size())
            return minHeap.peek();

        // 아니면 최대힙의 top을 반환한다.
        return maxHeap.peek();
    }

    public static void addHeap(int n)
    {
        // 최대힙이 비어있으면 최대힙에 데이터 저장
        if (maxHeap.isEmpty())
        {
            maxHeap.add(n);
            return;
        }

        // 최대힙과 최소힙 사이즈가 같으면 중앙값과 비교해서 중앙값보다 작거나 같으면 최대힙에 저장
        // 중앙값보다 크면 최소힙에 저장
        if (maxHeap.size() == minHeap.size())
        {
            if (getMid() >= n)
                maxHeap.add(n);
            else
                minHeap.add(n);

            return;
        }

        // 최소힙 사이즈가 더 크면 중앙값이 입력값보다 작으면 최대힙에 최소힙의 top을 추가하고 최소힙에서 pop
        // 최소힙에 입력값 추가
        // 입력값보다 크거나 같으면 최대힙에 추가
        if (minHeap.size() > maxHeap.size())
        {
            if (getMid() < n)
            {
                maxHeap.add(minHeap.remove());
                minHeap.add(n);
            }
            else
                maxHeap.add(n);

            return;
        }

        // 입력값이 중앙값보다 작으면 최소힙에 최대힙의 top 추가하고 최소힙에서 pop
        // 입력값을 최대힙에 추가
        // 중앙값보다 크면 최소힙에 추가
        if (getMid() > n)
        {
            minHeap.add(maxHeap.remove());
            maxHeap.add(n);
        }
        else
            minHeap.add(n);
    }

    public static void addCount(int n)
    {
        if (!cntMap.isEmpty() && cntMap.containsKey(n))
        {
            // 키가 있으면 횟수 추가
            int cnt = cntMap.get(n);
            cntMap.replace(n, cnt + 1);
        }
        else
        {
            // 없으면 새로 추가
            cntMap.put(n, 1);
        }
    }

    public static int getFreqVal()
    {
        int ret = 0, maxCnt = 0;
        ArrayList<Integer> tmp = new ArrayList<>();
        Iterator<Integer> it = cntMap.keySet().iterator();
        while (it.hasNext())
        {
            // 일단 돌면서 가장 높은 횟수 찾기
            int key = it.next();
            int cnt = cntMap.get(key);
            maxCnt = (maxCnt > cnt) ? maxCnt : cnt;
        }

        it = cntMap.keySet().iterator();
        while (it.hasNext())
        {
            // 가장 높은 횟수랑 비교하면서 같은 횟수인 키값 배열에 담기
            int key = it.next();
            if (maxCnt == cntMap.get(key))
                tmp.add(key);
        }

        if (tmp.size() > 1)
        {
            // 횟수가 같은 숫자가 여러개면 두 번째로 작은 값 리턴
            Collections.sort(tmp);
            int minVal = tmp.get(0);
            for (int i = 1; i < tmp.size(); i++)
            {
                if (minVal < tmp.get(i))
                {
                    ret = tmp.get(i);
                    break;
                }
            }
        }
        else
            ret = tmp.get(0);

        return ret;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();

        // 평균용 합계
        double sum = 0;

        // 중앙값 변수 초기화
        mid = 0;
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // 최빈값 변수 초기화
        cntMap = new TreeMap<>(); // <num, count>

        // 범위 구하기용 최댓값과 최솟값
        int maxVal = Integer.MIN_VALUE, minVal = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++)
        {
            arr.add(Integer.parseInt(br.readLine()));

            // 평균용 누적합
            sum += arr.get(i);

            // 중앙값 구하기용 힙에 추가
            addHeap(arr.get(i));

            // 최빈값 구하기용 맵에 추가
            addCount(arr.get(i));

            // 최댓값, 최솟값 구하기
            maxVal = (maxVal > arr.get(i)) ? maxVal : arr.get(i);
            minVal = (minVal < arr.get(i)) ? minVal : arr.get(i);
        }

        // 평균
        int avg = (int) Math.round(sum / N);
        bw.write(avg + "\n");

        // 중앙값
        mid = getMid();
        bw.write(mid + "\n");

        // 최빈값
        int freq = getFreqVal();
        bw.write(freq + "\n");

        // 범위
        int bnd = maxVal - minVal;
        bw.write(bnd + "\n");

        bw.flush();
        bw.close();
    }
}