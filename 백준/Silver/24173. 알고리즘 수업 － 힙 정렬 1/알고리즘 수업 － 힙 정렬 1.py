import sys
input = sys.stdin.readline

def build_min_heap(A, n):
    for i in range(n//2, 0, -1):
        heapify(A, i, n)

def heapify(A, k, n):
    global cnt
    lo, hi = 2*k, 2*k+1
    if hi <= n:
        idx = lo if A[lo] < A[hi] else hi
    elif lo <= n:
        idx = lo
    else:
        return
    
    if A[idx] < A[k]:
        A[idx], A[k] = A[k], A[idx]
        cnt += 1
        if cnt == K:
            print(A[k], A[idx])
            exit()
        heapify(A, idx, n)

N, K = map(int, input().split())
A = [-1] + list(map(int, input().split()))
cnt = 0
build_min_heap(A, N)
for i in range(N, 1, -1):
    A[1], A[i] = A[i], A[1]
    cnt += 1
    if cnt == K:
        print(A[i], A[1])
        exit()
    heapify(A, 1, i-1)
print(-1)