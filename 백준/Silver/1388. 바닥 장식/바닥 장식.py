import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N, M = map(int, input().split())
Map = [list(input().rstrip()) for _ in range(N)]
visited = [[False]*M for _ in range(N)]
moveDir = [(1,0),(-1,0),(0,1),(0,-1)]

def dfs(x, y, shape):
    temp = 0 if shape == "-" else 2
    for i in range(2):
        nx = x + moveDir[i + temp][0]
        ny = y + moveDir[i + temp][1]
        if nx < 0 or ny < 0 or nx >= M or ny >= N: continue
        if Map[ny][nx] != shape: continue
        if visited[ny][nx]: continue
        visited[ny][nx] = True
        dfs(nx, ny, shape)

cnt = 0
for y in range(N):
    for x in range(M):
        if visited[y][x]: continue
        visited[y][x] = True
        dfs(x, y, Map[y][x])
        cnt += 1

print(cnt)