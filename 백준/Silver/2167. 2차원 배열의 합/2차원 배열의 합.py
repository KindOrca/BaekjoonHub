import sys
input = sys.stdin.readline
N, M = map(int, input().split())
Map = [[0]*(M+1) for _ in range(N+1)]
for i in range(1,N+1):
    temp = list(map(int, input().split()))
    cnt = 0
    for j in range(1,M+1):
        cnt += temp[j-1]
        Map[i][j] = cnt
K = int(input())
quest = [list(map(int, input().split())) for _ in range(K)]
for i in range(K):
    x1, y1, x2, y2 = quest[i]
    ans = 0
    for j in range(x1, x2+1):
        ans += Map[j][y2] - Map[j][y1-1]
    print(ans)