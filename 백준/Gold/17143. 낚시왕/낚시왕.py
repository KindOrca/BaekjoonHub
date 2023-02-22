import sys
from collections import deque
input = sys.stdin.readline
fishs = deque()
moveDir = [0,(-1,0),(1,0),(0,1),(0,-1)]
ans = 0

R, C, M = map(int, input().split())
Map = [[0]*(C+1) for _ in range(R+1)]
for _ in range(M):
    r, c, s, d, z = map(int, input().split())
    if d in [1,2]: s = s % (2*(R-1))
    else: s = s % (2*(C-1))
    Map[r][c] = (s,d,z)
    fishs.append([r, c, s, d, z])

def Move_Fish():
    global fishs
    L = len(fishs)
    for _ in range(L):
        x, y, s, d, z = fishs.popleft()
        if not Map[x][y]: continue
        Map[x][y] = 0
        Move(x, y, s, d, z)

    while fishs:
        x, y, s, d, z = fishs.pop()
        if Map[x][y]:
            if Map[x][y][2] < z:
                Map[x][y] = (s,d,z)
        else:
            Map[x][y] = (s,d,z)

    for x in range(1, R+1):
        for y in range(1, C+1):
            if Map[x][y]:
                s, d, z = Map[x][y]
                fishs.append([x,y,s,d,z])

def Move(x, y, s, d, z):
    global fishs
    for _ in range(s):
        if x == 1 and d == 1: d = 2
        elif x == R and d == 2: d = 1
        elif y == 1 and d == 4: d = 3
        elif y == C and d == 3: d = 4
        x = x + moveDir[d][0]
        y = y + moveDir[d][1]
    fishs.append([x,y,s,d,z])

def Take_Fish(idx):
    global ans
    for j in range(1, R+1):
        if Map[j][idx]:
            ans += Map[j][idx][2]
            Map[j][idx] = 0
            break

for i in range(1, C+1):
    Take_Fish(i)
    Move_Fish()

print(ans)