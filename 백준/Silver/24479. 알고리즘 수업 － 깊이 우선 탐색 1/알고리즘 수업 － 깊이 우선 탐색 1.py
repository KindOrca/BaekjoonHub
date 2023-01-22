import sys
from collections import defaultdict

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N, M, start = map(int, input().split())
graph = defaultdict(list)
for _ in range(M):
    A, B = map(int, input().split())
    graph[A].append(B)
    graph[B].append(A)

for i in range(1, N+1):
    graph[i] = sorted(graph[i])

visited = [0] * (N+1)
visited[start] = 1
cnt = 2

def dfs(node):
    global cnt
    for i in graph[node]:
        if visited[i]: continue
        visited[i] = cnt
        cnt += 1
        dfs(i)

dfs(start)
for i in range(1, N+1):
    print(visited[i])