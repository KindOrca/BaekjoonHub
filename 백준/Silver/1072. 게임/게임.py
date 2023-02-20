import sys, math
input = sys.stdin.readline

X, Y = map(int, input().split())
lo, hi = 0, X
Z = math.floor(100*Y/X)

if Z in [99, 100]: print(-1) 
else:
    while lo+1 < hi:
        mid = (lo + hi) // 2
        if math.floor(100*(Y+mid)/(X+mid)) <= Z:
            lo = mid
        else:
            hi = mid
    print(hi)