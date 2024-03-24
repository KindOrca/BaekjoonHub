import sys
input = sys.stdin.readline

def find(n):
    if n == root[n]: return n
    root[n] = find(root[n])
    return root[n]

def union(a, b):
    a = find(a)
    b = find(b)
    if a > b:
        root[a] = b
    else:
        root[b] = a

N = int(input())
root = [i for i in range(N+1)]
for _ in range(N-2):
    a, b = map(int, input().split())
    union(a, b)

ans = set()
for i in root[1:]:
    ans.add(find(i))
print(*ans)