import sys
input = sys.stdin.readline

N, K = map(int, input().strip().split())
A = list(map(int, input().strip().split()))
B = sorted(A)
dic = {}

for idx, val in enumerate(A):
    dic[val] = idx

cnt = 0
for i in range(N-1, -1, -1):
    # A : [3, 1, 2, 4, 5]
    # B : [1, 2, 3, 4, 5]
    # 2, 3
    if A[i] != B[i]:
        temp = [A[i], B[i]]
        A[i], A[dic[B[i]]] = A[dic[B[i]]], A[i]
        dic[temp[0]], dic[temp[1]] = dic[temp[1]], dic[temp[0]]
        cnt += 1
    if K == cnt:
        print(*temp)
        sys.exit(0)
else:
    print(-1)