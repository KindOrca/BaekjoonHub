import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N, M = map(int, input().split())
Map = [list(input().rstrip()) for _ in range(N)]

moveDir = [(-1,0),(0,-1),(1,0),(0,1)]
visited = [[False]*M for _ in range(N)]
visited[0][0] = True
Cache = [[1]*M for _ in range(N)]
Cache[0][0] = 1
Inf = False

def dfs(x, y):
    global Inf
    if Cache[y][x] != 1:
        return Cache[y][x]
    ret = 1
    for i in range(4):
        num = int(Map[y][x])
        nx = x + moveDir[i][0] * num
        ny = y + moveDir[i][1] * num
        if nx < 0 or ny < 0 or nx >= M or ny >= N or Map[ny][nx] == 'H': continue
        if visited[ny][nx]:
            Inf = True
            return 0
        visited[ny][nx] = True
        ret = max(ret, dfs(nx, ny)+1)
        visited[ny][nx] = False
    Cache[y][x] = ret
    return ret

dfs(0,0)
if Inf: print(-1)
else: print(Cache[0][0])