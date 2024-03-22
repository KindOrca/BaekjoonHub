import sys
input = sys.stdin.readline

def find(n):
    if n == root[n]: return n
    root[n] = find(root[n])
    return root[n]

def union(a, b):
    a = find(a)
    b = find(b)
    if a == b: cycle1.add(a)
    if a < b:
        root[b] = a
    else:
        root[a] = b

idx = 1
while 1:
    n, m = map(int, input().split())
    if n==0 and m==0: break
    root = [i for i in range(n+1)]
    cycle1, cycle2 = set(), set()
    for _ in range(m):
        a, b = map(int, input().split())
        union(a, b)

    for i in cycle1:
        cycle2.add(find(i))
    
    cnt = -len(cycle2)
    for i in range(1, n+1):
        if i == find(i): cnt += 1
    if cnt > 1:
        print(f"Case {idx}: A forest of {cnt} trees.")
    elif cnt:
        print(f"Case {idx}: There is one tree.")
    else:
        print(f"Case {idx}: No trees.")
    idx += 1