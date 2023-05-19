N, K = map(int, input().split())
cache = [[0]*(N+1) for _ in range(K+1)]
for i in range(N+1):
    cache[0][i] = 1
for i in range(K+1):
    cache[i][i] = 1
for i in range(1, N+1):
    for j in range(1, K+1):
        cache[j][i] = (cache[j][i-1] + cache[j-1][i-1])%10007
print(cache[K][N])