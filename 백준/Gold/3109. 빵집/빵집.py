import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

R,C = map(int, input().split())
Map = [list(input().rstrip()) for _ in range(R)]

moveDir = [(1,-1),(1,0),(1,1)]

def dfs(x,y):
    global check
    for i in range(3):
        nx = x + moveDir[i][0]
        ny = y + moveDir[i][1]
        if nx < 0 or ny < 0 or nx >= C or ny >= R or Map[ny][nx] == 'x': continue
        Map[ny][nx] = 'x'
        if nx == C - 1: check = True
        if check: return
        dfs(nx, ny)
        if check: return

for i in range(R):
    check = False
    dfs(0, i)

cnt = 0
for i in range(R):
    if Map[i][C-1] == 'x': cnt += 1

print(cnt)