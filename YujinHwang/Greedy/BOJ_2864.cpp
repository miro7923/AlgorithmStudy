// BOJ 2864. 기타줄
// https://www.acmicpc.net/problem/2864

/*
 제한
 시간 : 1 초
 메모리 : 128 MB
 
 문제
 상근이는 2863번에서 표를 너무 열심히 돌린 나머지 5와 6을 헷갈리기 시작했다.
 
 상근이가 숫자 5를 볼 때, 5로 볼 때도 있지만, 6으로 잘못 볼 수도 있고, 6을 볼 때는, 6으로 볼 때도 있지만, 5로 잘못 볼 수도 있다.
 
 두 수 A와 B가 주어졌을 때, 상근이는 이 두 수를 더하려고 한다. 이때, 상근이가 구할 수 있는 두 수의 가능한 합 중, 최솟값과 최댓값을 구해 출력하는 프로그램을 작성하시오.
 
 입력
 첫째 줄에 두 정수 A와 B가 주어진다. (1 <= A,B <= 1,000,000)
 
 출력
 첫째 줄에 상근이가 구할 수 있는 두 수의 합 중 최솟값과 최댓값을 출력한다.
 ********************************
 
 풀이
 한 자리씩 검사하면서 5라면 6으로 만들었을 때의 합을 구하고(최대값) 6이라면 5로 만들었을 때의 합(최소값)을 구했다.
 
 결과
 시간 : 0 ms
 메모리 : 2024 KB
 */

#include <iostream>
#include <stack>

using namespace std;

int convertToMinVal(int n)
{
    // 뒷자리부터 하나씩 떼서 스택에 저장한다.
    // 최소값을 구하는 함수이기 때문에 6을 만나면 1 뺀 값을 저장한다.
    int ret = 0;
    stack<int> s;
    while (0 < n)
    {
        if (6 == n % 10)
            s.push(n % 10 - 1);
        else
            s.push(n % 10);
        
        n *= 0.1;
    }
    
    // 스택을 돌면서 다시 정수 형태로 만들어서 리턴한다.
    while (!s.empty())
    {
        ret += s.top();
        ret *= 10;
        s.pop();
    }
    
    return ret * 0.1;
}

int convertToMaxVal(int n)
{
    // 주어진 값의 최대값을 구하는 함수
    // 5를 만나면 1 더해준다.
    int ret = 0;
    stack<int> s;
    while (0 < n)
    {
        if (5 == n % 10)
            s.push(n % 10 + 1);
        else
            s.push(n % 10);
        
        n *= 0.1;
    }
    
    while (!s.empty())
    {
        ret += s.top();
        ret *= 10;
        s.pop();
    }
    
    return ret * 0.1;
}

int main()
{
    clock_t start = clock();
    
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int A, B, minVal = 0, maxVal = 0;
    cin >> A >> B;
    
    minVal = convertToMinVal(A) + convertToMinVal(B);
    maxVal = convertToMaxVal(A) + convertToMaxVal(B);
    
    cout << minVal << " " << maxVal << "\n";
    
    clock_t end = clock();
    printf("%f\n", (double)(end - start) / CLOCKS_PER_SEC);
    
    return 0;
}
