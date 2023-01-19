import sys

sys.setrecursionlimit(10**9)
input = sys.stdin.readline

M, N, K = map(int, input().split())
Map = [[0 for _ in range(N)] for _ in range(M)]
for _ in range(K):
    x1,y1,x2,y2 = map(int, input().split())
    for i in range(x1, x2):
        for j in range(y1, y2):
            Map[j][i] = 1

moveDir = [(1,0),(0,1),(-1,0),(0,-1)]
visited = [[False]*N for _ in range(M)]

def dfs(x,y):
    global cnt
    cnt += 1
    for i in range(4):
        nx = x + moveDir[i][0]
        ny = y + moveDir[i][1]
        if nx < 0 or ny < 0 or nx >= N or ny >= M or visited[ny][nx]: continue
        if Map[ny][nx] == 1: continue
        visited[ny][nx] = True
        dfs(nx, ny)

ans = []
for i in range(M):
    for j in range(N):
        if Map[i][j] == 1 or visited[i][j]: continue
        visited[i][j] = True
        cnt = 0
        dfs(j, i)
        ans.append(cnt)

print(len(ans))
print(*sorted(ans))