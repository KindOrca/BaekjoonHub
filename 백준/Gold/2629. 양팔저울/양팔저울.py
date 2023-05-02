import sys
from collections import deque
input = sys.stdin.readline
que = deque()

N = int(input())
weights = list(map(int, input().split()))
T = int(input())
pb = list(map(int, input().split()))
total = sum(weights)
DP = [0] * (total+1)

for weight in weights:
    check = False
    if DP[weight] == 0:
        check = True
    DP[weight] = 1
    for i in range(1, total+1):
        if i == weight and check: continue
        if DP[i]:
            que.append(abs(i-weight))
            if i + weight <= total:
                que.append(i+weight)
    while que:
        DP[que.pop()] = 1

ans = []
for p in pb:
    if p <= total and DP[p]: ans.append('Y')
    else: ans.append('N')

print(*ans)