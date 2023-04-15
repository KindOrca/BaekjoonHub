import sys
input = sys.stdin.readline
N, M = map(int, input().split())
arr = list(range(N+1))
for _ in range(M):
    i, j = map(int, input().split())
    arr = arr[:i] + arr[i:j+1][::-1] + arr[j+1:]
print(*arr[1:])