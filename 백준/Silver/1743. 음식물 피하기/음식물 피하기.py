import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

r,c,K = map(int, input().split())
Map = [[0]*c for _ in range(r)]
for _ in range(K):
    A, B = map(int, input().split())
    Map[A-1][B-1] = 'X'
moveDir = [(-1,0),(0,-1),(1,0),(0,1)]
visited = [[False]*c for _ in range(r)]
ans = 1

def dfs(x, y):
    global size
    for i in range(4):
        nx = x + moveDir[i][0]
        ny = y + moveDir[i][1]
        if nx < 0 or ny < 0 or nx >= c or ny >= r or not Map[ny][nx]: continue
        if visited[ny][nx]: continue
        visited[ny][nx] = True
        size += 1
        dfs(nx, ny)

for i in range(r):
    for j in range(c):
        if not Map[i][j] or visited[i][j]: continue
        visited[i][j] = True
        size = 1
        dfs(j, i)
        ans = max(ans, size)

print(ans)