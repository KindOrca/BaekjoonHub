import sys

input = sys.stdin.readline

N = int(input())
M = int(input())
arr = sorted(list(map(int, input().split())))
start, end = 0, N-1
cnt = 0
while start < end:
    if arr[start]+arr[end] == M: 
        cnt += 1
        start += 1
        end -= 1
    elif arr[start]+arr[end] > M: end -= 1
    else: start += 1

print(cnt)