import sys
from collections import defaultdict

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N, M = map(int, input().split())
graph = defaultdict(list)
for _ in range(N-1):
    A, B, D = map(int, input().split())
    graph[A].append((B, D))
    graph[B].append((A, D))

def dfs(node, dt):
    global ans, check
    if node == want:
        ans = dt
        check = True
        return
    for i, distance in graph[node]:
        if visited[i]: continue
        visited[i] = True
        dfs(i, dt+distance)
        if check: return

for _ in range(M):
    x, want = map(int, input().split())
    visited = [False]*(N+1)
    visited[x] = True
    ans, check = 0, False
    dfs(x, 0)
    print(ans)