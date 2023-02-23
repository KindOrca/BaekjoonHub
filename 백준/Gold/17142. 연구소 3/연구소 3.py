import sys, copy
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
Map = [list(map(int, input().split())) for _ in range(N)]
Virus = []
for i in range(N):
    for j in range(N):
        if Map[i][j] == 2:
            Map[i][j] = 0
            Virus.append((i, j))

LV = len(Virus)
moveDir = [(0,1),(1,0),(-1,0),(0,-1)]
visited_virus = [False]*LV
que = deque()
ans = 987654321

def Find_cnt():
    cnt = 0
    Map_copy = copy.deepcopy(Map)
    temp = copy.deepcopy(que)
    for i in range(len(que)):
        a, b, _ = que[i]
        Map_copy[a][b] = '*'

    while temp:
        (x, y, time) = temp.popleft()
        for i in range(4):
            nx = x + moveDir[i][0]
            ny = y + moveDir[i][1]
            if nx < 0 or ny < 0 or nx >= N or ny >= N: continue
            if Map_copy[nx][ny] != 0: continue
            if (nx, ny) not in Virus:
                cnt = max(cnt, time+1)
            Map_copy[nx][ny] = '*'
            temp.append((nx, ny, time+1))
    if Find_Empty(Map_copy): cnt = 987654321
    return cnt

def Back_Tracking(n, idx):
    global ans
    if idx == M:
        ans = min(ans, Find_cnt())
        return
    for i in range(n, LV):
        if visited_virus[i]: continue
        visited_virus[i] = True
        x, y = Virus[i]
        que.append((x, y, 0))
        Back_Tracking(i+1, idx+1)
        visited_virus[i] = False
        que.pop()

def Find_Empty(Map_):
    cnt = 0
    for i in range(N):
        for j in range(N):
            if Map_[i][j] == 0 and (i,j) not in Virus:
                cnt += 1
    return cnt != 0

Back_Tracking(0, 0)
if ans == 987654321: print(-1)
else: print(ans)