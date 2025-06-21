import sys
input = sys.stdin.readline

def init(st, en, idx):
    if st == en:
        tree[idx] = arr[st]
        return
    mid = (st+en)//2
    init(st, mid, 2*idx)
    init(mid+1, en, 2*idx+1)
    tree[idx] = tree[2*idx] + tree[2*idx+1]

def query(st, en, idx, lo, hi):
    lazy_update(st, en, idx)
    if hi < st or en < lo:
        return 0
    if lo <= st and en <= hi:
        return tree[idx]
    mid = (st+en)//2
    lsum = query(st, mid, 2*idx, lo, hi)
    rsum = query(mid+1, en, 2*idx+1, lo, hi)
    return lsum + rsum

def update(st, en, idx, lo, hi, val):
    lazy_update(st, en, idx)
    if hi < st or en < lo:
        return
    if lo <= st and en <= hi:
        tree[idx] += (en-st+1)*val
        if st != en:
            lazy[2*idx] += val
            lazy[2*idx+1] += val
        return
    mid = (st+en)//2
    update(st, mid, 2*idx, lo, hi, val)
    update(mid+1, en, 2*idx+1, lo, hi, val)
    tree[idx] = tree[2*idx] + tree[2*idx+1]

def lazy_update(st, en, idx):
    if lazy[idx]:
        tree[idx] += (en-st+1)*lazy[idx]
        if st != en:
            lazy[2*idx] += lazy[idx]
            lazy[2*idx+1] += lazy[idx]
        lazy[idx] = 0

N, M, K = map(int, input().split())
arr = [int(input()) for _ in range(N)]
tree = [0]*4*N
lazy = [0]*4*N
init(0, N-1, 1)
for _ in range(M+K):
    P = list(map(int, input().split()))
    if P[0] == 1:
        b, c, d = P[1], P[2], P[3]
        update(0, N-1, 1, b-1, c-1, d)
    else:
        b, c = P[1], P[2]
        print(query(0, N-1, 1, b-1, c-1))