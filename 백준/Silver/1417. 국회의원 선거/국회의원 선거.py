import sys
from queue import PriorityQueue
input = sys.stdin.readline
que = PriorityQueue()

N = int(input())
one = int(input())
for _ in range(N-1):
    que.put(-int(input()))
ans = 0
while N > 1:
    tmp = -que.get()
    if one > tmp: break
    ans += 1
    one += 1
    que.put(1-tmp)
print(ans)