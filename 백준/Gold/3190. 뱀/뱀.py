import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
Map = [[0]*(N+1) for _ in range(N+1)]
K = int(input())
for _ in range(K):
    x, y = map(int, input().split())
    Map[x][y] = 2
L = int(input())
seq = []
for _ in range(L):
    sec, dir = input().split()
    seq.append((int(sec), dir))
moveDir = [(0,1),(-1,0),(0,-1),(1,0)]

cnt = idx = 0
x, y = 1, 1
Map[x][y] = 1
deq = deque()
deq.append((1,1))
while True:
    cnt += 1
    direct = moveDir[idx]
    x += direct[0]
    y += direct[1]
    if x == 0 or y == 0 or y == N+1 or x == N+1: break
    if Map[x][y] == 1: break
    if Map[x][y] == 2:
        Map[x][y] = 1
        deq.append((x, y))
    else:
        Map[x][y] = 1
        deq.append((x, y))
        tail_x, tail_y = deq.popleft()
        Map[tail_x][tail_y] = 0
    if seq and cnt == seq[0][0]:
        _, dir = seq.pop(0)
        if dir == 'L': idx = idx+1 if idx != 3 else 0
        else: idx = idx-1 if idx != 0 else 3

print(cnt)