import sys
input = sys.stdin.readline

N, M = map(int, input().split())
memory = [-1] + list(map(int, input().split()))
cost = [-1] + list(map(int, input().split()))
total = sum(cost)+1
dp = [[0]*(total+1) for _ in range(N+1)]

for i in range(1,N+1):
    for j in range(total+1):
        if j - cost[i] < 0: 
            dp[i][j] = dp[i-1][j]
            continue
        dp[i][j] = max(dp[i-1][j], dp[i-1][j - cost[i]]+memory[i])

check = False
for j in range(total+1):
    for i in range(1, N+1):
        if dp[i][j] >= M:
            check = True
            break
    if check: break

print(j)