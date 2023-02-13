import sys
from collections import defaultdict
input = sys.stdin.readline
N = int(input())
balls = []
for i in range(N):
    c, s = map(int, input().split())
    balls.append((i+1, c, s))
balls.sort(key=lambda x: (x[2], x[1]))
bSum = [0]*N
dic = defaultdict(int)
wei = balls[0][2]
cnt = balls[0][2]
for i in range(1,N):
    bSum[i] = bSum[i-1]
    if wei != balls[i][2]:
        bSum[i] += cnt
        wei = balls[i][2]
        cnt = balls[i][2]
    else:
        cnt += balls[i][2]

ans = [0]*(N+1)
temp = (0,0)
pre_i = 0
for i in range(N):
    idx, color, weight = balls[i]
    if temp != (color, weight):
        ans[idx] = bSum[i] - dic[color]
        temp = (color, weight)
    else:
        ans[idx] = ans[pre_i]
    dic[color] += weight
    pre_i = idx
for i in ans[1:]:
    print(i)