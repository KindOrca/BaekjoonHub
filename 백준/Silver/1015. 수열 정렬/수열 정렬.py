from collections import defaultdict
dic = defaultdict(list)
N = int(input())
A = list(map(int, input().split()))
for i in range(N):
    dic[A[i]].append(i)
cnt = 0
ans = [0]*N
for i in range(1001):
    if not dic[i]: continue
    for t in sorted(dic[i]):
        ans[t] = cnt
        cnt += 1
print(*ans)