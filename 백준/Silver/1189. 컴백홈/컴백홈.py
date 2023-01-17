a,b,K = map(int, input().split())
Map = [list(input()) for _ in range(a)]
moveUP = [-1,0,1,0]
moveLR = [0,1,0,-1]
visited = [[False]*b for _ in range(a)]
visited[a-1][0] = True
cnt = 0

def dfs(x, y, t):
    global cnt
    if x == 0 and y == b-1:
        if t == K: cnt += 1
        return 
    for i in range(4):
        nx = x + moveUP[i]
        ny = y + moveLR[i]
        if nx < 0 or ny < 0 or nx >= a or ny >= b or visited[nx][ny]: continue
        if Map[nx][ny] == 'T': continue
        visited[nx][ny] = True
        dfs(nx, ny, t+1)
        visited[nx][ny] = False

if Map[a-1][0] == 'T':
    print(0)
else:
    dfs(a-1,0,1)
    print(cnt)