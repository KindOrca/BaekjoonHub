import sys
from collections import defaultdict

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

graph = defaultdict(list)
while True:
    try:
        A, B, D = map(int, input().split())
        graph[A].append((B, D))
        graph[B].append((A, D))
    except:
        break

N = len(graph.keys())

def dfs(node):
    global max_distance
    total = []
    for i, distance in graph[node]:
        if visited[i]: continue
        visited[i] = True
        total.append(dfs(i)+distance)
    if len(total) == 0: return 0
    elif len(total) == 1: 
        max_distance = max(max_distance, total[0])
        return total[0]
    total = sorted(total)
    max_distance = max(max_distance, total[-1]+total[-2])
    return total[-1]

if N == 0: print(0)
else:
    visited = [False] * (N+1)
    max_distance = 0
    visited[1] = True
    dfs(1)
    print(max_distance)