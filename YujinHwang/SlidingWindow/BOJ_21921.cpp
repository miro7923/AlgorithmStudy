// BOJ 21921. 블로그
// https://www.acmicpc.net/problem/21921

/*
 제한
 시간 : 1 초
 메모리 : 512 MB
 
 문제
 찬솔이는 블로그를 시작한 지 벌써 N일이 지났다.
 
 요즘 바빠서 관리를 못 했다가 방문 기록을 봤더니 벌써 누적 방문 수가 6만을 넘었다.
 
 
 
 찬솔이는 X일 동안 가장 많이 들어온 방문자 수와 그 기간들을 알고 싶다.
 
 찬솔이를 대신해서 X일 동안 가장 많이 들어온 방문자 수와 기간이 몇 개 있는지 구해주자.
 
 입력
 첫째 줄에 블로그를 시작하고 지난 일수 N와 X가 공백으로 구분되어 주어진다.
 
 둘째 줄에는 블로그 시작 1일차부터 N일차까지 하루 방문자 수가 공백으로 구분되어 주어진다.
 
 출력
 첫째 줄에 X일 동안 가장 많이 들어온 방문자 수를 출력한다. 만약 최대 방문자 수가 0명이라면 SAD를 출력한다.
 
 만약 최대 방문자 수가 0명이 아닌 경우 둘째 줄에 기간이 몇 개 있는지 출력한다.
 ********************************
 
 풀이
 입력 배열의 처음부터 X일만큼의 합을 구하면서 한 칸씩 뒤로 이동하는데 그 중 합계가 가장 높은 경우와 그 일수들을 따로 저장해 주었다.
 N개 중 X개의 합을 매번 구하면 좀 비효율적이란 생각이 들어 처음에 N 배열의 0번 원소부터 X개의 합을 구한 뒤 그것을 최대값으로 설정한 다음 다른 X개의 합을 구하는 반복문에서는 i가 1부터 시작하면서 i-1번째 원소는 합계에서 빼고 i+(X-1)번째 원소를 더해주며 부분 합계를 구했다.
 그 과정에서 현재 최대값과 같은 값이 나오면 최대 일수를 계산하는 카운트를 증가시키고 현재 최대값보다 큰 값이 나오면 카운트를 1로 초기화한 뒤 최대값을 갱신해 주었다.
 
 결과
 시간 : 20 ms
 메모리 : 2876 KB
 */

#include <iostream>

using namespace std;

#define MAXN 250000

int main()
{
    clock_t start = clock();
    
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int N, X, input[MAXN];
    cin >> N >> X;
    for (int i = 0; i < N; i++)
        cin >> input[i];
    
    int sum = 0, cnt = 1;
    for (int i = 0; i < X; i++)
        sum += input[i];
    
    int len = N - X, nextIdx = X - 1, high = sum;
    for (int i = 1; i <= len; i++)
    {
        sum -= input[i-1];
        sum += input[i+nextIdx];
        if (sum == high)
        {
            cnt++;
        }
        else if (sum > high)
        {
            cnt = 1;
            high = sum;
        }
    }
    
    if (0 < high)
        cout << high << "\n" << cnt;
    else
        cout << "SAD";
    
    clock_t end = clock();
    printf("\n%f\n", (double)(end - start) / CLOCKS_PER_SEC);
    
    return 0;
}
