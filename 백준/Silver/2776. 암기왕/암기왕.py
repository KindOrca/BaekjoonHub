import sys
from collections import deque
input = sys.stdin.readline

def Binary_Search(x):
    lo, hi = -1, N
    while lo+1 < hi:
        mid = (lo + hi) // 2
        if arr[mid] == x: return 1
        if arr[mid] < x:
            lo = mid
        else:
            hi = mid
    return 0

T = int(input())
for _ in range(T):
    N = int(input())
    arr = sorted(list(map(int, input().split())))
    M = int(input())
    quests = list(map(int, input().split()))
    for quest in quests:
        print(Binary_Search(quest))