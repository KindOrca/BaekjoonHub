import sys, string
input = sys.stdin.readline
T = int(input())
for _ in range(T):
    C = int(input())
    q, r = divmod(C, 25)
    d, r = divmod(r, 10)
    n, r = divmod(r, 5)
    print(q, d, n, r)