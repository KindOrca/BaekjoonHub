import sys
input = sys.stdin.readline
N = int(input())
start = end = sum = cnt = 1
while N != end:
    if sum == N:
        cnt += 1
        end += 1
        sum += end - start
        start += 1
    elif sum > N:
        sum -= start
        start += 1
    else:
        end += 1
        sum += end
    if start > N//2+1: break
print(cnt)