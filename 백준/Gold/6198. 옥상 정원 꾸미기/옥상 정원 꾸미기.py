import sys
from collections import deque
input = sys.stdin.readline
que = deque()
N = int(input())
heights = [int(input()) for _ in range(N)] + [1000000001]
cnt = 0
for height in heights:
    while que and que[-1] <= height:
        now = que.pop()
        if not que: break
        idx = len(que)
        cnt += idx
    que.append(height)

print(cnt)