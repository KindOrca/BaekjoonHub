import sys
input = sys.stdin.readline
Map = [[0]*101 for _ in range(101)]
dir = [(1,0),(0,-1),(-1,0),(0,1)]

def drawDragonCurve(x, y, d, g):
    Map[y][x] = 1
    nx = x + dir[d][0]
    ny = y + dir[d][1]
    Map[ny][nx] = 1
    total = [(x, y), (nx, ny)]
    for _ in range(g):
        N = len(total)
        (lx,ly) = total[-1]
        for i in range(N-2,-1,-1):
            (a, b) = total[i]
            na, nb = lx-(b-ly), ly+(a-lx)
            total.append((na, nb))
            Map[nb][na] = 1

N = int(input())
for _ in range(N):
    x,y,d,g = map(int, input().split())
    drawDragonCurve(x, y, d, g)

cnt = 0
for i in range(100):
    for j in range(100):
        if Map[i][j] and Map[i+1][j] and Map[i][j+1] and Map[i+1][j+1]:
            cnt += 1
print(cnt)