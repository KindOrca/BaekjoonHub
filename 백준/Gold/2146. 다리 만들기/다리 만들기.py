import sys
from collections import deque

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N = int(input())
Map = [list(map(int, input().split())) for _ in range(N)]

moveDir = [(-1,0),(0,-1),(0,1),(1,0)]
visited = [[False]*N for _ in range(N)]

def find_island(x, y, idx):
    for i in range(4):
        nx = x + moveDir[i][0]
        ny = y + moveDir[i][1]
        if nx < 0 or ny < 0 or nx >= N or ny >= N: continue
        if visited[ny][nx] or Map[ny][nx] == 0: continue
        visited[ny][nx] = True
        Map[ny][nx] = idx
        find_island(nx, ny, idx)

num = 1
for j in range(N):
    for i in range(N):
        if visited[j][i] or Map[j][i] == 0: continue
        visited[j][i] = True
        Map[j][i] = num
        find_island(i, j, num)
        num += 1

route = 198
visited_Island = [0]
for j in range(N):
    for i in range(N):
        if Map[j][i] == 0: continue
        temp = [[False]*N for _ in range(N)]
        temp[j][i] = True
        que = deque()
        que.append((i,j,0))
        while que:
            x, y, cnt = que.popleft()
            if Map[y][x] != 0 and Map[y][x] != Map[j][i]:
                route = min(route, cnt-1)
                break
            for t in range(4):
                nx = x + moveDir[t][0]
                ny = y + moveDir[t][1]
                if nx < 0 or ny < 0 or nx >= N or ny >= N: continue
                if temp[ny][nx] or Map[ny][nx] == Map[j][i]: continue
                temp[ny][nx] = True
                que.append((nx, ny, cnt+1))

print(route)