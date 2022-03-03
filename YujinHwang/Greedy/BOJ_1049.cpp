// BOJ 1049. 기타줄
// https://www.acmicpc.net/problem/1049

/*
 제한
 시간 : 2 초
 메모리 : 128 MB
 
 문제
 Day Of Mourning의 기타리스트 강토가 사용하는 기타에서 N개의 줄이 끊어졌다. 따라서 새로운 줄을 사거나 교체해야 한다. 강토는 되도록이면 돈을 적게 쓰려고 한다. 6줄 패키지를 살 수도 있고, 1개 또는 그 이상의 줄을 낱개로 살 수도 있다.
 
 끊어진 기타줄의 개수 N과 기타줄 브랜드 M개가 주어지고, 각각의 브랜드에서 파는 기타줄 6개가 들어있는 패키지의 가격, 낱개로 살 때의 가격이 주어질 때, 적어도 N개를 사기 위해 필요한 돈의 수를 최소로 하는 프로그램을 작성하시오.
 
 입력
 첫째 줄에 N과 M이 주어진다. N은 100보다 작거나 같은 자연수이고, M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 M개의 줄에는 각 브랜드의 패키지 가격과 낱개의 가격이 공백으로 구분하여 주어진다. 가격은 0보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
 
 출력
 첫째 줄에 기타줄을 적어도 N개 사기 위해 필요한 돈의 최솟값을 출력한다.
 ********************************
 
 풀이
 브랜드에 상관없이 총 구매 가격이 최소가 되기만 하면 되기 때문에 입력 받으면서 6개 팩 중 가장 싼 가격과 낱개 중 가장 싼 가격을 저장해 놓았다.
 그리고 기타줄의 갯수만큼 사는데 6개 팩으로 사는 것이 더 싸면 정답 변수에 6개 팩의 가격을 더해주고 아나리면 낱개를 남은 기타줄의 갯수만큼 곱해서 더해주었다.
 
 결과
 시간 : 0 ms
 메모리 : 2020 KB
 */

#include <iostream>

using namespace std;

#define MAXN 50
#define INF 1001
#define PACK 6

int main()
{
//    clock_t start = clock(); // 시간 측정용 코드
    
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int N, M, ans = 0, minPack = INF, minSingle = INF;
    cin >> N >> M;
    
    int pack, single;
    for (int i = 0; i < M; i++)
    {
        // 기타줄 가격들을 배열에 저장할 필요도 없이 입력값 중 가장 작은 값만 저장하면 된다.
        cin >> pack >> single;
        minPack = (minPack < pack) ? minPack : pack;
        minSingle = (minSingle < single) ? minSingle : single;
    }
    
    int lines = N; // 현재 남은 기타줄의 갯수
    while (0 < lines)
    {
        if (PACK <= lines) // 6개 이상일 때
        {
            // 문제 예시만 보면 대체로 6개를 살 때엔 낱개보다 6개 팩이 더 싸지만 혹시 몰라서 예외처리를 해 주었다.
            // 6개 팩 가격과 낱개를 6개로 사는 경우를 비교해서 더 싼 가격을 정답에 더해준다.
            if (minPack <= minSingle * PACK)
                ans += minPack;
            else
                ans += minSingle * PACK;
            
            // 6개 사는 거니까 남은 기타줄에서 6개를 빼준다.
            lines -= PACK;
        }
        else // 6개 미만일 때
        {
            // 남은 갯수만큼 낱개로 사는 것과 6개 사는 것 중 싼 걸로 산다.
            if (minPack <= minSingle * lines)
                ans += minPack;
            else
                ans += minSingle * lines;
            
            // 6개 미만일 땐 다 샀으니까 0
            lines = 0;
        }
    }
    
    cout << ans;
    
    // 시간 측정용 코드
//    clock_t end = clock();
//    printf("%f\n", (double)(end - start) / CLOCKS_PER_SEC);
    
    return 0;
}
