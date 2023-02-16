import sys
from collections import defaultdict, deque

input = sys.stdin.readline

N, M = map(int, input().split())
graph = defaultdict(list)
dic_weight = defaultdict(int)
max_weight = 0
for _ in range(M):
    A, B, C = map(int, input().split())
    if dic_weight[(A,B)] == 0:
        graph[A].append(B)
        graph[B].append(A)
    dic_weight[(A,B)] = max(C, dic_weight[(A,B)])
    dic_weight[(B,A)] = dic_weight[(A,B)]
    max_weight = max(max_weight, C)
start, end = map(int, input().split())

def condition(x):
    visited = [False]*(N+1)
    visited[start] = True
    que = deque()
    que.append(start)
    while que:
        now = que.popleft()
        for ni in graph[now]:
            weight = dic_weight[(now, ni)]
            if x > weight: continue
            if ni == end: return True
            if visited[ni]: continue
            visited[ni] = True
            que.append(ni)
    return False

lo,  hi = 1, max_weight
while lo < hi:
    mid = (lo+hi+1)//2
    if condition(mid):
        lo = mid
    else:
        hi = mid - 1

print(lo)