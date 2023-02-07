N = int(input())
arr = list(map(int, input().split()))

visited = [False]*N
temp = [0]*N
ans = 0

def Back_Tracking(array, idx):
    global ans
    if idx == N:
        ans = max(ans, calculation(array))
        return
    for i in range(N):
        if visited[i]: continue
        visited[i] = True
        array[idx] = arr[i]
        Back_Tracking(array, idx+1)
        visited[i] = False
    
def calculation(array):
    sum = 0
    for i in range(N-1):
        sum += abs(array[i] - array[i+1])
    return sum

Back_Tracking(temp, 0)
print(ans)