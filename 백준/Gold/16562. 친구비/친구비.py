import sys
input = sys.stdin.readline

def find(n):
    if n == root[n]: return n
    root[n] = find(root[n])
    return root[n]

def union(a, b):
    a = find(a)
    b = find(b)
    if a == b: return
    if a > b:
        root[a] = b
        money[b] = min(money[a], money[b])
    else:
        root[b] = a
        money[a] = min(money[a], money[b])

N, M, k = map(int, input().split())
money = [0] + list(map(int, input().split()))
root = [i for i in range(N+1)]
for _ in range(M):
    v, w = map(int, input().split())
    if v == w: continue
    union(v, w)

total = 0
for i in range(1, N+1):
    if i != root[i]: continue
    total += money[i]

if total <= k: print(total)
else: print("Oh no")