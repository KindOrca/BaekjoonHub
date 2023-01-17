from collections import defaultdict

N = int(input())
edges = list(map(int, input().split()))
remove = int(input())

graph = defaultdict(list)
for chi, par in enumerate(edges):
    if par == -1: root = chi
    if par == remove or chi == remove: continue
    graph[par].append(chi)

visited = [False] * N
visited[root] = True
cnt = 0

def dfs(node):
    global cnt
    if node not in graph.keys():
        cnt += 1
        return
    if len(graph[node]) == 1 and graph[node][0] == remove:
        cnt += 1
        return
    for i in graph[node]:
        if visited[i]: continue
        visited[i] = True
        dfs(i)

if root == remove: 
    print(0)
else:
    dfs(root)
    print(cnt)