import sys
input = sys.stdin.readline
N = int(input())
def dot(n, S):
    if n == N: return S
    S += S - 1
    return dot(n+1, S)

print(dot(0, 2)**2)