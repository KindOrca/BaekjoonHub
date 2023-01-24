import sys
from collections import defaultdict

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N = int(input().rstrip())
graph = defaultdict(list)
for _ in range(N):
    rows = list(map(int, input().split()))
    A, row = rows[0], rows[1:-1]
    while row:
        graph[A].append((row.pop(0),row.pop(0)))

def dfs(node):
    global diameter
    ret = []
    for i, val in graph[node]:
        if visited[i]: continue
        visited[i] = True
        ret.append(dfs(i) + val)
    if len(ret) == 1:
        diameter = max(diameter, ret[0])
        return ret[0]
    elif len(ret) == 0:
        return 0
    else:
        ret.sort()
        diameter = max(diameter, ret[-1]+ret[-2])
        return ret[-1]

diameter = 0
visited = [False]*(N+1)
visited[1] = True
dfs(1)
print(diameter)