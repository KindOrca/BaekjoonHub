import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

Num, E,W,S,N = map(int, input().split())
E, W, S, N = E/100, W/100, S/100, N/100
visited = [[False]*(2*Num+1) for _ in range(2*Num+1)]

moveDir = []
if E != 0: moveDir.append((-1,0,E))
if W != 0: moveDir.append((1,0,W))
if S != 0: moveDir.append((0,1,S))
if N != 0: moveDir.append((0,-1,N))
L = len(moveDir)
ans = 0

def dfs(x, y, value, idx):
    global ans
    if idx == Num:
        ans += value
        return
    for i in range(L):
        nx = x + moveDir[i][0]
        ny = y + moveDir[i][1]
        if visited[ny][nx]: continue
        visited[ny][nx] = True
        dfs(nx, ny, value*moveDir[i][2], idx+1)
        visited[ny][nx] = False

visited[Num][Num] = True
dfs(Num, Num, 1, 0)
print(ans)