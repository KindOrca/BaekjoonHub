import sys
from collections import defaultdict

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def dfs(node, shape):
    global check
    if not check: return
    for i in graph[node]:
        if visited[i]:
            if visited[i] == shape:
                check = False
                return
        else:
            visited[i] = 1 if shape == 2 else 2
            dfs(i, visited[i])

K = int(input())
for _ in range(K):
    V, E = map(int, input().split())
    graph = defaultdict(list)
    for _ in range(E):
        A, B = map(int, input().split())
        graph[A].append(B)
        graph[B].append(A)
    visited = [False] * (V+1)
    check = True
    for i in range(1, V+1):
        if visited[i]: continue
        visited[i] = 1
        dfs(i, 1)
    if check: print("YES")
    else: print("NO")