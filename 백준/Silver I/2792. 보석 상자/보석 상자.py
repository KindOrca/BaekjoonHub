import sys
input = sys.stdin.readline

N, M = map(int, input().split())
bead = [int(input()) for _ in range(M)]
lo, hi = 0, max(bead)

def check(K):
    cnt = 0
    for i in bead:
        cnt += i//K+1 if i%K else i//K
    if cnt > N: return False
    else: return True

while lo+1 < hi:
    mid = (lo+hi)//2
    if check(mid):
        hi = mid
    else:
        lo = mid
print(hi)