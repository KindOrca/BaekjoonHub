import sys
from collections import deque

input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    home = tuple(map(int, input().split()))
    store = []
    for _ in range(n):
        X, Y = map(int, input().split())
        store.append((X, Y))
    destination = tuple(map(int, input().split()))
    store.append(destination)

    visited = [False]*(n+1)
    que = deque()
    que.append(home)
    check = False
    while que:
        (x, y) = que.popleft()
        if (x, y) == destination:
            check = True
            break
        for i, spot in enumerate(store):
            if abs(x - spot[0]) + abs(y - spot[1]) > 1000: continue
            if visited[i]: continue
            visited[i] = True
            que.append(spot)

    if check: print("happy")
    else: print("sad")