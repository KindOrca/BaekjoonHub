N, M = map(int, input().split())
ans = 0
for _ in range(N):
    ans += 1 if input().count('O') > M//2 else 0
print(ans)