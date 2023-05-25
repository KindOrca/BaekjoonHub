import sys
from collections import deque
input = sys.stdin.readline
que = deque()
rpt_que = deque()
N = int(input())
heights = [int(input()) for _ in range(N)]
if N == 1: print(0)
else:
    que.append(heights[0])
    rpt_que.append(1)
    ans = 0
    rpt = 1
    for height in heights[1:]:
        cnt = 0
        if que[-1] < height:
            while True:
                now = que.pop()
                cnt += 1
                if not que or que[-1] != now:
                    rpt_que.pop()
                if not que or que[-1] >= height: break
            
        if que and que[-1] == height:
            rpt = rpt_que.pop()
            rpt += 1
            cnt += rpt - 1
            cnt += 1 if que[0] > height else 0
            rpt_que.append(rpt)
        elif que and  que[-1] > height:
            rpt_que.append(1)
            cnt += 1

        if not que: rpt_que.append(1)
        que.append(height)
        ans += cnt
    print(ans)