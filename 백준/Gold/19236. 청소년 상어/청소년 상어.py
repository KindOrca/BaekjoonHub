import sys, copy

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

Map = []
fish_position = [0]*17
for t in range(4):
    Map.append([])
    temp = list(map(int, input().split()))
    for i in range(0,4):
        Map[t].append(temp[2*i])
        fish_position[temp[2*i]] = (i, t, temp[2*i+1])

moveDir = [0,(0,-1),(-1,-1),(-1,0),(-1,1),(0,1),(1,1),(1,0),(1,-1)]
ans = 0 

def Back_Tracking(fish_num, map, max_num, fish_place):
    global ans
    max_num += fish_num
    x, y, dir = fish_place[fish_num]
    after_map, after_fish_place = Map_Change(x, y, map, fish_place)
    temp = Check_Shark(x, y, dir, after_map)
    if not temp:
        ans = max(ans, max_num)
        return
    for i in temp:
        nx = x + moveDir[dir][0] * i
        ny = y + moveDir[dir][1] * i
        fish = after_map[ny][nx]
        Back_Tracking(fish, after_map, max_num, after_fish_place)

def Check_Shark(x, y, dir, map):
    temp = []
    for i in range(1,4):
        nx = x + moveDir[dir][0] * i
        ny = y + moveDir[dir][1] * i
        if nx < 0 or ny < 0 or nx >= 4 or ny >= 4: continue
        if map[ny][nx] == 0: continue
        temp.append(i)
    return temp

def Map_Change(x, y, map, fish_place):
    temp = copy.deepcopy(map)
    temp_place = fish_place[:]
    fish_num = temp[y][x]
    temp_place[fish_num], temp[y][x] = 0, 0
    for i in range(1, 17):
        if temp_place[i] == 0: continue
        fx, fy, dir = temp_place[i]
        for j in range(dir, dir+8):
            j = j-8 if j>8 else j
            fnx = fx + moveDir[j][0]
            fny = fy + moveDir[j][1]
            if fnx < 0 or fny < 0 or fnx >= 4 or fny >= 4: continue
            if fnx == x and fny == y: continue
            if temp[fny][fnx]:
                after_fish = temp[fny][fnx]
                temp_place[i] = (fnx, fny, j)
                temp_place[after_fish] = (fx, fy, temp_place[after_fish][2])
                temp[fy][fx] = after_fish
                temp[fny][fnx] = i
            else:
                temp_place[i] = (fnx, fny, j)
                temp[fy][fx] = 0
                temp[fny][fnx] = i
            break
    return temp, temp_place

Back_Tracking(Map[0][0], Map, 0, fish_position)
print(ans)