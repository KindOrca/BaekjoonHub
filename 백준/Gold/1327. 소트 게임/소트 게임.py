import sys
from collections import deque, defaultdict

input = sys.stdin.readline

N, K = map(int, input().split())
num = list(map(int, input().split()))
sort_num = sorted(num)
visited = defaultdict(int)
que = deque()
que.append((num, 0))
ans = -1
while que:
    now, idx = que.popleft()
    if now == sort_num:
        ans = idx
        break
    for i in range(N-K+1):
        temp = now[:i] + now[i:i+K][::-1] + now[i+K:]
        temp_i = 0
        for j in range(N):
            temp_i += temp[j]*(10**(N-j-1))
        if visited[temp_i]: continue
        visited[temp_i] = 1
        que.append((temp, idx+1))

print(ans)
