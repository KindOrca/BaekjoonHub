import sys

input = sys.stdin.readline
N, M = map(int, input().split())
arr = list(range(N+1))
for i in range(M):
    st, en, mid = map(int, input().split())
    first = arr[:st]
    mid_1 = arr[st:mid]
    mid_2 = arr[mid:en+1]
    end = arr[en+1:]
    arr = first + mid_2 + mid_1 + end
print(*arr[1:])