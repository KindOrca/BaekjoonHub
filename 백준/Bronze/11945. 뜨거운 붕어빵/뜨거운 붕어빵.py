import sys
input = sys.stdin.readline
N, M = map(int, input().split())
breads = [input().rstrip() for _ in range(N)]
for bread in breads:
    print(bread[::-1])