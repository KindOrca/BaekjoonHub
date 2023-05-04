import sys
input = sys.stdin.readline

C, N = map(int, input().split())
c, n = [0], [0]
for _ in range(N):
    a, b = map(int, input().split())
    c.append(a)
    n.append(b)

DP = [0]*100001

for i in range(1, N+1):
    cost = c[i]
    mem = n[i]
    DP[cost] = max(DP[cost], mem)
    for j in range(cost+1, 100001):
        DP[j] = max(DP[j], DP[j-cost]+mem)
        if DP[j] >= C: break

for i in range(100001):
    if DP[i] >= C:
        print(i)
        break