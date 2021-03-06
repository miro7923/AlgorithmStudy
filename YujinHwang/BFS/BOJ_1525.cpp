// BOJ 1524. 퍼즐
// https://www.acmicpc.net/problem/1525

/*
 제한
 시간 : 1 초
 메모리 : 32 MB
 
 문제
 3×3 표에 다음과 같이 수가 채워져 있다. 오른쪽 아래 가장 끝 칸은 비어 있는 칸이다.
 
 1    2    3
 4    5    6
 7    8
 
 어떤 수와 인접해 있는 네 개의 칸 중에 하나가 비어 있으면, 수를 그 칸으로 이동시킬 수가 있다. 물론 표 바깥으로 나가는 경우는 불가능하다. 우리의 목표는 초기 상태가 주어졌을 때, 최소의 이동으로 위와 같은 정리된 상태를 만드는 것이다. 다음의 예를 보자.
 
 1         3
 4    2    5
 7    8    6
 
 1    2    3
 4         5
 7    8    6
 
 1    2    3
 4    5
 7    8    6
 
 1    2    3
 4    5    6
 7    8
 가장 윗 상태에서 세 번의 이동을 통해 정리된 상태를 만들 수 있다. 이와 같이 최소 이동 횟수를 구하는 프로그램을 작성하시오.
 
 입력
 세 줄에 걸쳐서 표에 채워져 있는 아홉 개의 수가 주어진다. 한 줄에 세 개의 수가 주어지며, 빈 칸은 0으로 나타낸다.
 
 출력
 첫째 줄에 최소의 이동 횟수를 출력한다. 이동이 불가능한 경우 -1을 출력한다.
 ********************************
 
 풀이
 고민해 봤지만 풀이가 떠오르지 않아서 구글링했다.
 브루트포스 + bfs 조합으로 푸는 문제였는데 풀이의 키포인트는 3*3 2차원 배열로 생각하는 것이 아니라 123456780의 문자열로 생각하고 푸는 것이다.
 그리고 이 문자열에서 0이 몇 번 인덱스에 있는지 알아낸 다음 그 인덱스를 기준으로 2차원 배열 상에서의 좌표를 구한다.
 좌표는 x = 인덱스 / 3
 y = 인덱스 % 3 하면 구할 수 있다.
 구한 좌표를 이용해서 2차원 배열에서의 다음 좌표를 구할 수 있다.
 
 다음 좌표를 구했다면 1차원 배열인 문자열 상에서의 위치를 바꿔줘야 한다.
 문자열 상에서 0과 다음 위치의 숫자를 바꿔주려면 두 숫자가 위치한 인덱스를 알아야 한다.
 인덱스를 이용해 좌표를 구했듯이 좌표를 이용해 인덱스도 구할 수 있다.
 인덱스는 x와 y를 구했던 과정을 거꾸로 돌려서 x * 3 + y 하면 구할 수 있다.
 그러면 위 계산식을 통해 구한 두 인덱스들을 swap() 함수를 이용해 바꿔준다.
 
 그런데 문제의 답은 123456780으로 만드는 데 필요한 최소 횟수이다.
 그래서 swap한 문자열과 함께 이 문자열을 만들기까지 필요했던 횟수도 함께 저장해야 하기 때문에 <string, int> 페어로 큐에 저장하고 bfs 탐색을 실시한다.
 이 때 방문표시가 필요한데 이 풀이 형태에서 방문여부를 알 수 있는 방법은 같은 문자열이 나왔는지 비교하는 것이다.
 그러면 중복을 허용하지 않고 검색이 가능한 컨테이너가 유용할 것이다.
 그래서 set을 사용해 같은 문자열이 있다면(iterator가 end를 가리킨다면) 그 문자열은 방문한 것이니까 거를 수 있어서 방문표시와 같은 동작을 수행할 수 있다.
 방문하지 않았다면 현재 이동 횟수에 + 1 한 값을 새 문자열과 함께 큐에 넣으면 된다.
 
 결과
 시간 : 264 ms
 메모리 : 16560 KB
 */

#include <iostream>
#include <queue>
#include <set>
#include <algorithm>
#include <string>

using namespace std;

string input, target; // 입력, 최종 타겟 문자열 123456780
int dir[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
set<string> visited; // 방문표시용

int bfs()
{
    queue<pair<string, int>> q;
    q.push(make_pair(input, 0));
    visited.insert(input);
    while (!q.empty())
    {
        string curS = q.front().first;
        int curCnt = q.front().second;
        q.pop();
        
        // 현재 문자열이 타겟 문자열과 같으면(정리되었으면) 현재 횟수 리턴
        if (curS == target) return curCnt;
        
        // 0이 있는 인덱스와 x, y 좌표 구하기
        int zero = curS.find('0');
        int x = zero / 3;
        int y = zero % 3;
        
        // 상하좌우 4방향 탐색
        for (int i = 0; i < 4; i++)
        {
            auto next = make_pair(x + dir[i][0], y + dir[i][1]);
            
            // 보드판 범위 안이라면 바꾼다.
            if (0 <= next.first && 3 > next.first && 0 <= next.second && 3 > next.second)
            {
                string nextS = curS;
                swap(nextS[x * 3 + y], nextS[next.first * 3 + next.second]);
                
                // 아직 방문하지 않은 문자열이면 방문표시 후 다음 탐색을 위해 큐에 삽입
                if (visited.end() == visited.find(nextS))
                {
                    visited.insert(nextS);
                    q.push(make_pair(nextS, curCnt + 1));
                }
            }
        }
    }
    
    return -1;
}

int main()
{
    clock_t start = clock();
    
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    input = "";
    target = "123456780";
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            int tmp;
            cin >> tmp;
            input += tmp + '0'; // string으로 변환
        }
    }
    
    int ans = bfs();
    cout << ans;
    
    clock_t end = clock();
    printf("\n%f\n", (double)(end - start) / CLOCKS_PER_SEC);
    
    return 0;
}
