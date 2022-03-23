'''
문제 출처
이것이 취업을 위한 코딩테스트다 with 파이썬
그리디 - 실전문제 3

제한
시간 : 1 초
메모리 : 128 MB

문제
여러 개의 숫자 카드 중에서 가장 높은 숫자가 쓰인 카드 한 장을 뽑는 게임

단, 게임의 룰을 지키며 뽑아야 한다.

1. 숫자가 쓰인 카드들이 N X M 형태로 놓여 있다. 이때 N은 행의 개수를 의미하고, M은 열의 개수를 의미
2. 먼저 뽑고자 하는 카드가 포함된 행을 선택한다.
3. 선택된 행에 포함된 카드들 중 가장 숫자가 낮은 카드를 뽑는다.
4. 따라서 처음에 카드를 골라낼 행을 선택할 때, 이후 해당 행에서 가장 숫자가 낮은 카드를 뽑아야 하는 것을 고려해 가장 높은 숫자를 뽑을 수 있도록 해야한다.

입력
첫째 줄에 숫자 카드들이 놓인 행의 개수 N과 열의 개수 M이 공백을 기준으로 하여 각각 자연수로 주어진다. (1 <= N, M <= 100)
둘째 줄부터 N개의 줄에 걸쳐 각 카드에 적힌 숫자가 주어진다. 각 숫자는 1 이상 10,000 이하의 자연수이다.

출력
첫째 줄에 게임의 룰에 맞게 선택한 카드에 적힌 숫자를 출력한다.
'''

'''
풀이
처음에 문제의 4번 조건이 이해가 안 되서 문제 이해를 위한 구글링을 해야 했다...
구글링 결과 각 행에서 가장 낮은 숫자를 뽑은 다음 그 중에서 가장 큰 수를 뽑는 문제였다.
이걸 이렇게 어렵게 설명할 필요가 있나? ㅠㅠ 문제 이해력 좀 올려야 겠다...

문제 풀이는 2차원 배열을 입력받은 후
2중 반복문으로 각 행에서 가장 작은 숫자를 찾은 뒤 그 수를 지금까지 찾은 가장 큰 수와 비교해서 더 큰 값으로 갱신해주는 방식으로 짰다.
'''

N, M = map(int, input().split())

arr = []
for i in range(N):
    arr.append(list(map(int, input().split())))

# 정답을 저장할 변수 - 각 행 별 가장 작은 수 중에서 가장 큰 수
ans = 0
# 각 행에서 가장 작은 수
minValInLine = 0
for i in range(N):
    # 각 행을 탐색 하기 전에 각 행의 첫 번째 원소를 가장 작은 수로 설정한 후 가장 작은 수를 찾는다.
    minValInLine = arr[i][0]
    for j in range(1, M):
        if minValInLine > arr[i][j]:
            minValInLine = arr[i][j]
    # 지금까지 찾은 가장 큰 수와 비교해서 더 큰 값으로 갱신힌다.
    if ans < minValInLine:
        ans = minValInLine

print(ans)


'''
책의 해설을 참고하여 min() 함수를 사용한 코드
'''

N, M = map(int, input().split())

ans = 0
for i in range(N):
    # 한 줄씩 입력 받으면서 바로 확인
    arr = list(map(int, input().split()))
    minVal = min(arr)
    ans = min(ans, minVal)

print(ans)

'''
2중 반복문과 min() 함수를 사용한 코드
'''

N, M = map(int, input().split())

ans = 0;
for i in range(N):
    # 한 줄씩 입력 받으면서 확인
    arr = list(map(int, input().split()))
    # 각 행에서 가장 작은 수를 찾는다.
    minVal = 10001
    for j in arr:
        minVal = min(minVal, j)
    # 가장 작은 수 중에서 가장 큰 수를 찾는다.
    ans = max(ans, minVal)

print(ans)
