import sys
input = sys.stdin.readline
N = int(input())
arr = []
for _ in range(N):
    arr.append(int(input()))
arr = sorted(arr)
ans = 4
for i in range(N):
    temp = 0
    for j in range(1,5):
        if i+j >= N: continue
        if arr[i+j] in [arr[i]+1,arr[i]+2,arr[i]+3,arr[i]+4]:
            temp += 1
    ans = min(ans, 4-temp)

print(ans)