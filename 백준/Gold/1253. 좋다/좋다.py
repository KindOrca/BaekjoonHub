import sys
input = sys.stdin.readline

N = int(input())
A = sorted(list(map(int, input().split())))
ans = 0

def binary_search(i, j):
    lo, hi = i, N-1
    while lo+1 < hi:
        mid = (lo+hi)//2
        if mid != j and A[i]+A[mid] == A[j]: return True
        if A[i]+A[mid] < A[j]:
            lo = mid
        else:
            hi = mid
    if hi == j:
        if hi != N-1 and A[i]+A[hi+1] == A[j]: return True
    elif A[i]+A[hi] == A[j]: return True
    return False

for j in range(N):
    for i in range(N):
        if i == j: continue
        if binary_search(i, j):
            ans += 1
            break

print(ans)