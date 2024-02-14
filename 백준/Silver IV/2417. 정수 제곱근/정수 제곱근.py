N = int(input())
lo, hi = -1, N
while lo+1 < hi:
    mid = (lo+hi)//2
    if mid**2 < N:
        lo = mid
    else:
        hi = mid
print(hi)