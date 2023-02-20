import sys
from collections import deque
input = sys.stdin.readline

R,C,T = map(int, input().split())
Map = [list(map(int, input().split())) for _ in range(R)]
deq = deque()
moveDir = [(-1,0),(0,-1),(1,0),(0,1)]

for i in range(R):
    if Map[i][0] == -1:
        air = i
        break

def moveDust():
    for i in range(R):
        for j in range(C):
            if Map[i][j] > 4:
                deq.append((i, j, Map[i][j]//5))

    while deq:
        x, y, mis = deq.pop()
        for i in range(4):
            nx = x + moveDir[i][0]
            ny = y + moveDir[i][1]
            if nx < 0 or ny < 0 or nx >= R or ny >= C: continue
            if Map[nx][ny] == -1: continue
            Map[nx][ny] += mis
            Map[x][y] -= mis

def operateAir():
    global air
    for i in range(air-1, 0, -1):
        Map[i][0] = Map[i-1][0]
    for i in range(C-1):
        Map[0][i] = Map[0][i+1]
    for i in range(air):
        Map[i][C-1] = Map[i+1][C-1]
    for i in range(C-1, 1, -1):
        Map[air][i] = Map[air][i-1]
    Map[air][1] = 0

    for i in range(air+2, R-1):
        Map[i][0] = Map[i+1][0]
    for i in range(C-1):
        Map[R-1][i] = Map[R-1][i+1]
    for i in range(R-1, air+1, -1):
        Map[i][C-1] = Map[i-1][C-1]
    for i in range(C-1, 1, -1):
        Map[air+1][i] = Map[air+1][i-1]
    Map[air+1][1] = 0

for i in range(T):
    moveDust()
    operateAir()

print(sum(list(map(sum, Map[:])))+2)