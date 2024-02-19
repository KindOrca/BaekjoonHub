import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

def dfs(x, y):
    for i in range(4):
        nx = x + moveDir[i][0]
        ny = y + moveDir[i][1]
        if nx < 0 or ny < 0 or nx >= N or ny >= M: continue
        if Map[ny][nx] == "1" or check[ny][nx]: continue
        check[ny][nx] = True
        dfs(nx, ny)

M, N = map(int, input().split())
Map = [list(input().rstrip()) for _ in range(M)]
moveDir = [(0,1), (1,0), (0,-1), (-1,0)]
check = [[False]*N for _ in range(M)]

for i in range(N):
    if Map[0][i] == "1" or check[0][i]: continue
    check[0][i] = True
    dfs(i, 0)

ans = False
for i in range(N):
    if check[M-1][i]:
        ans = True
        break

if ans: print("YES")
else: print("NO")