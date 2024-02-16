import sys
input = sys.stdin.readline

N = int(input())
S = sorted(list(map(int, input().split())))
ans = [S[0],S[1],S[2]]

def binary_search(i, j):
    lo, hi = i+1, j-1
    while lo+1 < hi:
        mid = (lo+hi)//2
        if S[i] + S[mid] + S[j] == 0:
            print(S[i], S[mid], S[j])
            exit(0)
        if S[i] + S[mid] + S[j] < 0:
            lo = mid
        else:
            hi = mid
    if abs(S[i]+S[lo]+S[j]) < abs(S[i]+S[hi]+S[j]):
        return lo
    else:
        return hi

for i in range(N-2):
    for j in range(i+2, N):
        idx = binary_search(i, j)
        if abs(sum(ans)) > abs(S[i]+S[idx]+S[j]):
            ans = [S[i],S[idx],S[j]]

print(*ans)