import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().split())
Map = [0]
for i in range(1,N+1):
    temp = [0]
    temp.extend(map(int, input().split()))
    Map.append(temp)
chess = [[[] for _ in range(N+1)] for _ in range(N+1)]
Horse = deque()
first_one = [False]*(K+1)
position = [None]*(K+1)
for i in range(1, K+1):
    x, y, z = map(int, input().split())
    Horse.append([i, z])
    chess[x][y].append(i)
    first_one[i] = True
    position[i] = [x, y]
moveDir = [0,(1,0),(-1,0),(0,-1),(0,1)]
change = {1:2, 2:1, 3:4, 4:3}

def moveHorse():
    for _ in range(K):
        horse, dir = Horse.popleft()
        x, y = position[horse][0], position[horse][1]
        if not first_one[horse]:
            Horse.append([horse, dir])
            continue
        nx = x + moveDir[dir][1]
        ny = y + moveDir[dir][0]
        if nx == 0 or ny == 0 or nx > N or ny > N or Map[nx][ny] == 2:
            dir = change[dir]
            nx = x + moveDir[dir][1]
            ny = y + moveDir[dir][0]
            blue(horse, x, y, dir, nx, ny)
            if nx == 0 or ny == 0 or nx > N or ny > N:
                nx, ny = x, y
        elif Map[nx][ny] == 0:
            white(horse, x, y, dir, nx, ny)
        elif Map[nx][ny] == 1:
            red(horse, x, y, dir, nx, ny)
        if len(chess[nx][ny]) >= 4: return True
    return False
            
def white(horse, x, y, dir, nx, ny):
    if not chess[nx][ny]:
        chess[nx][ny] = chess[x][y]
    else:
        chess[nx][ny].extend(chess[x][y])
        first_one[horse] = False
    chess[x][y] = []
    Horse.append([horse, dir])
    for i in chess[nx][ny]:
        position[i] = [nx, ny]

def red(horse, x, y, dir, nx, ny):
    if not chess[nx][ny]:
        chess[nx][ny] = chess[x][y][::-1]
        first_one[chess[nx][ny][-1]] = False
        first_one[chess[nx][ny][0]] = True
    else:
        first_one[chess[x][y][0]] = False
        chess[nx][ny].extend(chess[x][y][::-1])
    chess[x][y] = []
    Horse.append([horse, dir])
    for i in chess[nx][ny]:
        position[i] = [nx, ny]

def blue(horse, x, y, dir, nx, ny):
    if nx == 0 or ny == 0 or nx > N or ny > N or Map[nx][ny] == 2:
        Horse.append([horse, dir])
    elif Map[nx][ny] == 0:
        white(horse, x, y, dir, nx, ny)
    elif Map[nx][ny] == 1:
        red(horse, x, y, dir, nx, ny)

idx = 1
while True:
    if idx > 1000: break
    if moveHorse(): break
    idx += 1
if idx > 1000: print(-1)
else: print(idx)