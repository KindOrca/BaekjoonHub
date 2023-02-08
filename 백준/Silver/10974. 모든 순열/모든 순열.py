N = int(input())

visited = [False]*(N+1)
arr = [0]*(N)

def Back_Tracking(idx):
    if idx == N:
        print(*arr)
        return
    for i in range(1, N+1):
        if visited[i]: continue
        visited[i] = True
        arr[idx] = i
        Back_Tracking(idx+1)
        visited[i] = False

Back_Tracking(0)