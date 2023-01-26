import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N, M = map(int, input().split())
Map = []
for _ in range(N):
    Map.append(list(map(int, input().split())))

visited = [[False]*M for _ in range(N)]
moveDir = [(1,0),(0,1),(-1,0),(0,-1),(1,-1),(1,1),(-1,1),(-1,-1)]

def dfs(x, y):
    global check
    for i in range(8):
        nx = x + moveDir[i][0]
        ny = y + moveDir[i][1]
        if nx < 0 or ny < 0 or nx >= M or ny >= N: continue
        if Map[y][x] < Map[ny][nx]:
            check = False
        if visited[ny][nx] or Map[y][x] != Map[ny][nx]: continue
        visited[ny][nx] = True
        dfs(nx, ny)

cnt = 0
for y in range(N):
    for x in range(M):
        if visited[y][x] or Map[y][x] == 0: continue
        visited[y][x] = True
        check = True
        dfs(x, y)
        if check: cnt += 1

print(cnt)