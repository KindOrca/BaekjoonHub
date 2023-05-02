import sys
input = sys.stdin.readline

N, M = map(int, input().split())
S = []
cnt = 0
for _ in range(N):
    S.append(input())
for _ in range(M):
    if input() in S:
        cnt += 1

print(cnt)