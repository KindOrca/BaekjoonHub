import sys
input = sys.stdin.readline
N = int(input())
Map = [list(input().rstrip()) for _ in range(N)]
w, l = 0, 0
for i in range(N):
    j, cnt = 0, 0
    while j < N:
        if Map[i][j] == 'X':
            if cnt > 1: w += 1
            cnt = 0
        else:
            cnt += 1
        j += 1
    if cnt > 1: w += 1

for j in range(N):
    i, cnt = 0, 0
    while i < N:
        if Map[i][j] == 'X':
            if cnt > 1: l += 1
            cnt = 0
        else:
            cnt += 1
        i += 1
    if cnt > 1: l += 1
print(w, l)