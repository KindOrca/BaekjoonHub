import sys
from collections import defaultdict
input = sys.stdin.readline
N, K = map(int, input().split())
arr = list(map(int, input().split()))
arr_sum = [0]*(N+1)
for i in range(N):
    arr_sum[i+1] = arr_sum[i] + arr[i]
dic = defaultdict(int)
cnt = 0
for i in range(1,N+1):
    if arr_sum[i] == K:
        cnt += 1
    cnt += dic[arr_sum[i] - K]
    dic[arr_sum[i]] += 1
print(cnt)