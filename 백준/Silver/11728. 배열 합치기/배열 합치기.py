import sys

input = sys.stdin.readline

N, M = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
i = j = 0
ans = []
while i != N and j != M:
    if A[i] < B[j]:
        ans.append(A[i])
        i += 1
    else:
        ans.append(B[j])
        j += 1
if i != N: ans.extend(A[i:])
else: ans.extend(B[j:])

print(*ans)