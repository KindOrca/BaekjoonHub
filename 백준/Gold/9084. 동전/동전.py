import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N = int(input())
    coins = list(map(int, input().split()))
    M = int(input())
    arr = [0]*(M+1)
    for coin in coins:
        if coin > M: continue
        arr[coin] += 1
        for i in range(coin+1, M+1):
            arr[i] += arr[i-coin]
    print(arr[M])