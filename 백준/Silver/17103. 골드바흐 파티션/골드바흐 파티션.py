import sys
from math import *

input = sys.stdin.readline

n = 1000001
arr = [True]*n
for i in range(2, int(sqrt(n)+1)):
    if arr[i]:
        for j in range(i+i, n, i):
            arr[j] = False 

prime = [i for i in range(2,n) if arr[i]]

T = int(input())
for _ in range(T):
    N = int(input())
    cnt = 0
    for i in prime:
        if i > (N//2): break
        if arr[N-i]:
            cnt += 1
    print(cnt)