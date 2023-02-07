import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N, M = map(int, input().split())
Map = [list(map(int, input().split())) for _ in range(N)]
chicken, house = [], []
for y in range(N):
    for x in range(N):
        if Map[y][x] == 2:
            chicken.append((x, y))
        if Map[y][x] == 1:
            house.append((x, y))

Lc, Lh = len(chicken), len(house)
moveDir = [(-1,0),(0,-1),(1,0),(0,1)]
visited = [False]*Lc
distance = [0]*Lh
ans = 987654321

def Back_Tracking(dist, idx, start):
    global ans
    if idx == M:
        ans = min(ans, sum(dist))
        return
    for i in range(start, Lc):
        if visited[i]: continue
        visited[i] = True
        after = cal_distance(i, dist[:])
        Back_Tracking(after, idx+1, i+1)
        visited[i] = False

def cal_distance(idx, dist_):
    x, y = chicken[idx][0], chicken[idx][1]
    for i in range(Lh):
        if dist_[i]: dist_[i] = min(dist_[i], abs(house[i][0] - x) + abs(house[i][1] - y))
        else: dist_[i] = abs(house[i][0] - x) + abs(house[i][1] - y)
    return dist_

Back_Tracking(distance, 0, 0)
print(ans)