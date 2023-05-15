import sys
from collections import deque
input = sys.stdin.readline

Map = [list(input().rstrip()) for _ in range(12)]
MoveDir = [(1,0),(0,1),(-1,0),(0,-1)]

def FindBBuyu(a, b, shape):
    que = deque()
    que.append((a, b))
    cnt = 1
    check = [(a, b)]
    visited[b][a] = True
    while que:
        x, y = que.popleft()
        for i in range(4):
            nx = x + MoveDir[i][0]
            ny = y + MoveDir[i][1]
            if nx < 0 or ny < 0 or nx >= 6 or ny >= 12: continue
            if Map[ny][nx] != shape: continue
            if visited[ny][nx]: continue
            visited[ny][nx] = True
            cnt += 1
            que.append((nx, ny))
            check.append((nx, ny))
    if cnt >= 4:
        return check
    else:
        return []

ans = 0
while True:
    visited = [[False]*6 for _ in range(12)]
    destroy = []
    for j in range(12):
        for i in range(6):
            if visited[j][i] or Map[j][i] == '.': continue
            tmp = FindBBuyu(i, j, Map[j][i])
            destroy.extend(tmp)

    if destroy:
        ans += 1
        for tile in destroy:
            x, y = tile[0], tile[1]
            for i in range(y, 0, -1):
                Map[i][x] = Map[i-1][x]
                if Map[i][x] == '.': break
            Map[0][x] = '.'
    else:
        break

print(ans)
