import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    input()
    coins = list(map(int, input().split()))
    P = int(input())
    DP = [0] * (P+1)
    for coin in coins:
        if coin > P: continue
        DP[coin] += 1
        for i in range(coin+1, P+1):
            DP[i] += DP[i-coin]
    print(DP[P])