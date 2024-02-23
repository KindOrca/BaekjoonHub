import sys
from collections import deque
input = sys.stdin.readline
moveDir = [(-1,0),(0,-1),(1,0),(0,1)]

def findSquares(h):
    path = [[False]*M for _ in range(N)]
    cnt = 0
    for j in range(N):
        for i in range(M):
            if path[j][i]: continue
            if Map[j][i] - h > 0:
                path[j][i] = True
                continue
            tmp, path = BFS(i, j, path, h)
            cnt += tmp
    return cnt

def BFS(i, j, path, h):
    que = deque()
    que.append((i, j))
    path[j][i] = True
    edgeCheck = False
    cnt = 1
    while que:
        x, y = que.popleft()
        for t in range(4):
            nx = x + moveDir[t][0]
            ny = y + moveDir[t][1]
            if nx < 0 or ny < 0 or nx >= M or ny >= N: 
                edgeCheck = True
                continue
            if Map[ny][nx] - h > 0: continue
            if path[ny][nx]: continue
            path[ny][nx] = True
            cnt += 1
            que.append((nx, ny))
    if edgeCheck: return 0, path
    return cnt, path

N, M = map(int, input().split())
Map = [list(map(int, list(input().rstrip()))) for _ in range(N)]
max_height = max(map(max, Map))
ans = 0
for i in range(1, max_height):
    ans += findSquares(i)
print(ans)