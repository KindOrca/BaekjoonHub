import sys
input = sys.stdin.readline
N = int(input())
k = int(input())

def check(x):
    cnt = 0
    for i in range(1, N+1):
        cnt += min(x//i, N)
    return cnt < k

lo, hi = 1, k
while lo < hi:
    mid = (lo + hi) // 2
    if check(mid):
        lo = mid + 1
    else:
        hi = mid

print(lo)
