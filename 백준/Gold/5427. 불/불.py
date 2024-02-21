import sys
from collections import deque
input = sys.stdin.readline
moveDir = [(-1,0),(0,-1),(1,0),(0,1)]

def BFS(pos, fire, map):
    fire_que = deque()
    pos_que = deque()
    fire_que.extend(fire)
    pos_que.append(pos)
    cnt = 0
    while pos_que or fire_que:
        cnt += 1
        N = len(fire_que)
        for _ in range(N):
            x, y = fire_que.popleft()
            for i in range(4):
                nx = x + moveDir[i][0]
                ny = y + moveDir[i][1]
                if nx < 0 or ny < 0 or nx >= w or ny >= h: continue
                if map[ny][nx] != '.': continue
                map[ny][nx] = '*'
                fire_que.append((nx, ny))
        
        N = len(pos_que)
        for _ in range(N):
            x, y = pos_que.popleft()
            for i in range(4):
                nx = x + moveDir[i][0]
                ny = y + moveDir[i][1]
                if nx < 0 or ny < 0 or nx >= w or ny >= h: continue
                if map[ny][nx] != '.': continue
                if nx == 0 or ny == 0 or nx == w-1 or ny == h-1:
                    return cnt+1
                map[ny][nx] = '*'
                pos_que.append((nx, ny))
    return "IMPOSSIBLE"

for _ in range(int(input())):
    w, h = map(int, input().split())
    Map = [list(input().rstrip()) for i in range(h)]
    pos, fire = (), []
    for i in range(h):
        for j in range(w):
            if Map[i][j] == '#': continue
            if Map[i][j] == '@':
                pos = (j, i)
            if Map[i][j] == '*':
                fire.append((j, i))
    if pos[0] == 0 or pos[1] == 0 or pos[0] == w-1 or pos[1] == h-1: print(1)
    else: print(BFS(pos, fire, Map))