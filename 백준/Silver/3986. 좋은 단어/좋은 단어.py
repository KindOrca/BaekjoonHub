import sys
from collections import deque
input = sys.stdin.readline
N = int(input())
cnt = 0
for _ in range(N):
    word = input().rstrip()
    if len(word) % 2: continue
    que = deque()
    que.append(word[0])
    tmp = ''
    for let in word[1:]:
        if not que or que[-1] != let:
            que.append(let)
        else:
            que.pop()
    if not que: cnt += 1
print(cnt)