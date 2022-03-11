// BOJ 1213. 팰린드롬 만들기
// https://www.acmicpc.net/problem/1213

/*
 제한
 시간 : 2 초
 메모리 : 128 MB
 
 문제
 임한수와 임문빈은 서로 사랑하는 사이이다.
 
 임한수는 세상에서 팰린드롬인 문자열을 너무 좋아하기 때문에, 둘의 백일을 기념해서 임문빈은 팰린드롬을 선물해주려고 한다.
 
 임문빈은 임한수의 영어 이름으로 팰린드롬을 만들려고 하는데, 임한수의 영어 이름의 알파벳 순서를 적절히 바꿔서 팰린드롬을 만들려고 한다.
 
 임문빈을 도와 임한수의 영어 이름을 팰린드롬으로 바꾸는 프로그램을 작성하시오.
 
 입력
 첫째 줄에 임한수의 영어 이름이 있다. 알파벳 대문자로만 된 최대 50글자이다.
 
 출력
 첫째 줄에 문제의 정답을 출력한다. 만약 불가능할 때는 "I'm Sorry Hansoo"를 출력한다. 정답이 여러 개일 경우에는 사전순으로 앞서는 것을 출력한다.
 ********************************
 
 풀이
 예전에 팰린드롬인지 판별하는 문제를 풀었던 기억이 나서 판별하는 알고리즘에다 팰린드롬 문자열을 출력하는 알고리즘을 추가로 구현했다.
 
 주어진 문자열이 팰린드롬인지 판별하는 방법은
 문자열의 길이가 짝수일 때엔 같은 알파벳의 갯수가 모두 짝수여야 한다. 예제 입력의 AABB와 같은 문자열은 A 2개 B 2개로 모든 구성 요소가 각각 짝수개 있기 때문에 팰린드롬이다. 하나라도 홀수면 팰린드롬이 될 수 없다.
 
 문자열의 길이가 홀수일 때엔 알파벳 하나만 홀수개여야 하고 나머지는 모두 짝수개가 있어야 한다. ABCC와 같이 홀수개인 문자가 2개 있으면 팰린드롬을 만들 수 없다.
 
 그래서 입력으로 주어지는 문자열을 한 번 순회하면서 각 알파벳의 갯수를 센다.
 
 
 그 다음 센 갯수를 바탕으로 주어진 문자열이 팰린드롬인지 아닌지 판별한다.
 팰린드롬이라면
 길이가 짝수일 땐 알파벳의 갯수를 센 배열을 앞에서부터 순회하면서 각 알파벳들의 절반 횟수만큼만 먼저 정답 문자열에 더해준 뒤 저걸 복사해서 반대로 뒤집은 다음 정답 문자열에 더한다.
 
 길이가 홀수일 땐 짝수와 비슷하게 하는데 갯수가 홀수인 문자는 1을 뺀 값에서 절반만큼만 정답 문자열에 더해준다.
 짝수 갯수인 문자들은 문자열의 길이가 짝수일 때와 마찬가지로 더해준다.
 다 더했으면 역시 복사한 뒤 뒤집어서 정답에 마저 더해준다.
 
 팰린드롬이 여러 개일 때엔 사전순으로 빠른 순서대로 출력하라고 했으므로 위와 같이 구하면 정답이다.
 
 결과
 시간 : 0 ms
 메모리 : 2028 KB
 */

#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

#define ALPHA 26

int alphabet[ALPHA];

bool checkEvenCnt()
{
    // 문자열의 길이가 짝수일 때
    for (int i = 0; i < ALPHA; i++)
    {
        // 하나라도 홀수이면 팰린드롬이 아니다.
        if (0 != alphabet[i] % 2)
            return false;
    }
    
    return true;
}

bool checkOddCnt()
{
    // 문자열의 길이가 홀수일 때
    // 한 개만 홀수고 나머지는 짝수
    int oddCnt = 0;
    for (int i = 0; i < ALPHA; i++)
    {
        if (0 != alphabet[i] % 2)
        {
            // 홀수개인 문자가 2개 이상이면 팰린드롬이 아니다.
            oddCnt++;
            if (2 <= oddCnt)
                return false;
        }
    }
    
    return true;
}

string append(int cnt, char ch)
{
    // 정해진 횟수만큼 문자를 합쳐주는 함수
    string ret = "";
    for (int i = 0; i < cnt; i++)
        ret += ch;
    
    return ret;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    string s, ans = "", tmp;
    cin >> s;
    
    for (auto elem : s)
        alphabet[elem - 'A']++;
    
    if (0 == s.length() % 2) // 길이 짝수
    {
        if (checkEvenCnt())
        {
            for (int i = 0; i < ALPHA; i++)
            {
                if (0 < alphabet[i])
                {
                    // 횟수의 절반만큼 더한다.
                    int cnt = alphabet[i] *= 0.5;
                    ans += append(cnt, i + 'A');
                }
            }
            
            // 임시 문자열에 복사한 뒤 내림차순 정렬한다.
            tmp = ans;
            sort(tmp.begin(), tmp.end(), [](const char &a, const char &b)->bool{
                return a > b;
            });
            
            // 정답 문자열에 더해주면 된다.
            ans += tmp;
        }
        else
            ans = "I'm Sorry Hansoo";
    }
    else // 길이 홀수
    {
        if (checkOddCnt())
        {
            char center;
            for (int i = 0; i < ALPHA; i++)
            {
                if (0 < alphabet[i])
                {
                    int cnt;
                    if (0 != alphabet[i] % 2)
                    {
                        // 한 개는 가운데에 들어가야 하니까 1 뺀 값에서 절반만큼만 더한다.
                        cnt = (alphabet[i] - 1) * 0.5;
                        ans += append(cnt, i + 'A');
                        
                        // 가운데에 들어갈 문자 표시
                        center = i + 'A';
                    }
                    else
                    {
                        cnt = alphabet[i] *= 0.5;
                        ans += append(cnt, i + 'A');
                    }
                }
            }
            
            tmp = ans;
            sort(tmp.begin(), tmp.end(), [](const char &a, const char &b)->bool{
                return a > b;
            });
            
            // 가운데에 들어갈 문자를 먼저 더한 다음 뒤집은 문자열을 더한다.
            ans += center + tmp;
        }
        else
            ans = "I'm Sorry Hansoo";
    }
    
    cout << ans;
    
    return 0;
}
