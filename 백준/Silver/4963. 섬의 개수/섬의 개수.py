import sys

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

def dfs(x, y):
    for i in range(8):
        nx = x + moveDir[i][0]
        ny = y + moveDir[i][1]
        if nx < 0 or ny < 0 or nx >= w or ny >= h or visited[ny][nx]: continue
        if Map[ny][nx] == 0: continue
        visited[ny][nx] = True
        dfs(nx, ny)

while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0: break
    Map = [list(map(int, input().split())) for _ in range(h)]
    moveDir = [(-1,0),(0,-1),(1,0),(0,1),(1,1),(-1,-1),(-1,1),(1,-1)]
    visited = [[False]*w for _ in range(h)]

    cnt = 0
    for i in range(w):
        for j in range(h):
            if visited[j][i] or Map[j][i] == 0: continue
            dfs(i,j)
            cnt += 1

    print(cnt)