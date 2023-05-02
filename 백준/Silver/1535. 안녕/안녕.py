import sys
input = sys.stdin.readline

N = int(input())
s = [0] + list(map(int, input().split()))
h = [0] + list(map(int, input().split()))
DP = [[0]*100 for _ in range(N+1)]

for i in range(1, N+1):
    for j in range(1, 100):
        if j - s[i] >= 0:
            DP[i][j] = max(DP[i-1][j], DP[i-1][j-s[i]]+h[i])
        else:
            DP[i][j] = DP[i-1][j]
print(DP[N][99])