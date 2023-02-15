import sys
input = sys.stdin.readline
N, C = map(int, input().split())
houses = sorted([int(input()) for _ in range(N)])
distance = []
for i in range(1, N):
    distance.append(houses[i]-houses[i-1])

def check(d):
    cnt = C - 1
    temp = 0
    for i in distance:
        temp += i
        if temp >= d:
            cnt -= 1
            temp = 0
        if cnt == 0: return True
    return False

lo, hi = 1, houses[-1] - houses[0]
ans = 0
while lo <= hi:
    mid = (lo + hi) // 2
    if check(mid):
        ans = mid
        lo = mid + 1
    else:
        hi = mid - 1
    
print(ans)