// BOJ 2579. 계단 오르기
// https://www.acmicpc.net/problem/2579

/*
 제한
 시간 : 1 초
 메모리 : 128 MB
 
 문제
 계단 오르는 데는 다음과 같은 규칙이 있다.
 
 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
 마지막 도착 계단은 반드시 밟아야 한다.
 따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.
 
 각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.
 
 입력
 입력의 첫째 줄에 계단의 개수가 주어진다.
 
 둘째 줄부터 한 줄에 하나씩 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여 있는 점수가 주어진다. 계단의 개수는 300이하의 자연수이고, 계단에 쓰여 있는 점수는 10,000이하의 자연수이다.
 
 출력
 첫째 줄에 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값을 출력한다.
 ********************************
 
 풀이
 참고 풀이 : https://yabmoons.tistory.com/510
 
 dp로 어떻게 풀어야 할 지 대충은 알겠는데 구체적인 풀이가 안 떠올라서 구글링했다.
 처음에는 1번 계단과 2번 계단부터 시작하는 경우를 나눈 규칙에 따라 다음 계단을 올라가며 최대값을 구하는데 마지막 계단을 밟지 못하는 경우가 생길수도 있으니까 규칙에 따라 왔을 때 마지막 계단에 도착하지 못하면 다시 되돌아가서 다른 경우를 탐색하는 방식으로 하려 했었다.
 그래서 재귀로 짜려고 했는데 되돌아가서 다시 탐색해야 하는 경우에 대한 조건 설정하는 것이 너무 애매해서 할 수 없었다 ㅠㅠ 그래서 구글링...
 
 문제 풀이의 키포인트는 i번째 계단을 밟았을 때 얻을 수 있는 최대값을 구해서 dp 배열에 저장하는 것인데
 
 1번 계단에 왔을 때의 최대값은 1번 계단의 값이다.
 
 2번 계단에 왔을 때의 최대값은 1번+2번 계단의 값이 될 것이다.
 
 3번 계단에 왔을 때의 최대값은 1번+3번 계단 or 2번+3번 계단의 값만 가능하다.
 
 4번 계단에 왔을 때의 최대값은 1번+3번+4번 계단 or 2번+4번 계단 or 1번+2번+4번 계단의 값이 가능하다.
 여기서 2, 3번째 경우를 보면 둘 다 2번 계단을 밟고 4번까지 오는데 두 경우 중 1+2+4번 경우가 항상 더 큰 값이 나올 것이다.
 그래서 4번 계단에 왔을 때엔 1번+3번+4번 계단 or 1번+2번+4번 계단의 값 중 하나가 최대값이 될 것이다.
 이걸 바꿔 표현하면 1번까지 왔을 때의 최대값 + 3번 + 4번 or 2번까지 왔을 때의 최대값 + 4번이 된다.
 여기서 4에 i를 대입하면 i번째 계단 = i-3까지 왔을 때의 최대값 + i-1번째 계단 + i번째 계단 or i-2까지 왔을 때의 최대값 + i번째 계단이 된다.
 dp 배열에 대입하면 dp[i]는 i번째 계단에 왔을 때의 최대값이라고 정의하면
 dp[i] = max(dp[i-3] + stair[i-1] + stair[i], dp[i-2] + stair[i])
 
 dp 배열의 마지막 계단 인덱스값을 출력하면 정답이 된다.
 
 결과
 시간 : 0 ms
 메모리 : 2020 KB
 */

#include <iostream>
#include <string.h>

using namespace std;

#define MAX 301

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int N, stair[MAX], dp[MAX]; // 계단의 갯수, 계단배열, dp배열
    cin >> N;
    
    memset(stair, 0, sizeof(stair));
    memset(dp, 0, sizeof(dp));
    for (int i = 1; i <= N; i++)
        cin >> stair[i];
    
    // dp[N-2] + stait[N]
    // dp[N-3] + stair[N-1] + stair[N]
    dp[1] = stair[1];
    dp[2] = stair[1] + stair[2];
    dp[3] = (stair[1] + stair[3] > stair[2] + stair[3]) ? stair[1] + stair[3] : stair[2] + stair[3];
    
    int c1, c2;
    for (int i = 4; i <= N; i++)
    {
        c1 = dp[i-2] + stair[i];
        c2 = dp[i-3] + stair[i-1] + stair[i];
        dp[i] = (c1 > c2) ? c1 : c2;
    }
    
    cout << dp[N];
    
    return 0;
}
