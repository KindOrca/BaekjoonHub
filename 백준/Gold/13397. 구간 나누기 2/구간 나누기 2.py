import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))

def condition(x):
    cnt = 1
    mi, ma = arr[0], arr[0]
    for i in arr:
        mi = min(mi, i)
        ma = max(ma, i)
        if ma - mi > x:
            cnt += 1
            mi, ma = i, i
    return cnt <= M

lo, hi = 0, max(arr)
result = hi
while lo <= hi:
    mid = (lo + hi) // 2
    if condition(mid):
        hi = mid - 1
        result = min(result, mid)
    else:
        lo = mid + 1

print(result)