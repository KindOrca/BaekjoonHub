import sys
from math import *
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N = int(input())
    while True:
        for i in range(2, int(sqrt(N)+1)):
            if N % i == 0: break
        else: break
        N += 1
    N = 2 if N < 2 else N
    print(N)