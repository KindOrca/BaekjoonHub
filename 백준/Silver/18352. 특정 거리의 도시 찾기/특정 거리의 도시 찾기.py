import sys
from collections import deque, defaultdict

input = sys.stdin.readline

N, M, K, X = map(int, input().split())
graph = defaultdict(list)
for _ in range(M):
    A, B = map(int, input().split())
    graph[A].append(B)

que = deque()
que.append((X,1))
visited = [0] * (N+1)
visited[X] = -1
while que:
    now = que.popleft()
    node, idx = now[0], now[1]
    for i in graph[node]:
        if visited[i]: continue
        visited[i] = idx
        if idx < K:
            que.append((i, idx+1))

ans = []
for i in range(1, N+1):
    if visited[i] == K: ans.append(i)

if ans:
    for i in range(len(ans)):
        print(ans[i])
else: print(-1)