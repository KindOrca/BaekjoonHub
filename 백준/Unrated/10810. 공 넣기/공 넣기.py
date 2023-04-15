import sys
input = sys.stdin.readline
N, M = map(int, input().split())
basket = [0] * (N+1)
for _ in range(M):
    i, j, k = map(int, input().split())
    basket = basket[:i] + [k]*(j-i+1) + basket[j+1:]
print(*basket[1:])