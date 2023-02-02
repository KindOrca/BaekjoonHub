import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
Map = [list(input().rstrip()) for _ in range(N)]
red, blue, hole = (),(),()
for y in range(N):
    for x in range(M):
        if Map[y][x] == 'R':
            red = (x,y)
        elif Map[y][x] == 'B':
            blue = (x,y)
        elif Map[y][x] == 'O':
            hole = (x,y)

moveDir = [(-1,0),(1,0),(0,1),(0,-1)]

que = deque()
que.append((red, blue, 1))
ans = 0
while que:
    now = que.popleft()
    red, blue, idx = now[0], now[1], now[2]
    for i in range(4):
        n_red, n_blue = red, blue
        goal_red = False
        check_red = False
        while True:
            nx = n_red[0]+moveDir[i][0]
            ny = n_red[1]+moveDir[i][1]
            if Map[ny][nx] == '#': break
            if nx == blue[0] and ny == blue[1]:
                check_red = True
                break
            if Map[ny][nx] == 'O':
                n_red = (-1,-1)
                goal_red = True
                break
            n_red = (nx, ny)

        goal_blue = False
        check_blue = False
        while True:
            nx = n_blue[0]+moveDir[i][0]
            ny = n_blue[1]+moveDir[i][1]
            if Map[ny][nx] == '#': break
            if nx == n_red[0] and ny == n_red[1]: break
            if Map[ny][nx] == 'O':
                goal_blue = True
                break
            n_blue = (nx, ny)

        if goal_red and not goal_blue:
            ans = idx
            break

        if check_red: n_red = (n_blue[0]-moveDir[i][0], n_blue[1]-moveDir[i][1])

        if not (goal_blue or goal_red) and idx < 10:
            que.append((n_red, n_blue, idx+1))

    if ans: break

if ans: print(ans)
else: print(-1)
