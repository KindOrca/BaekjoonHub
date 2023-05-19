import sys
input = sys.stdin.readline
N = int(input())
dance = set()
dance.add('ChongChong')
for _ in range(N):
    A, B = input().split()
    if A in dance: dance.add(B)
    if B in dance: dance.add(A)
print(len(dance))