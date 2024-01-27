import sys
input = sys.stdin.readline

def build_min_heap(arr, n):
    for i in range(n//2, 0, -1):
        heapify(arr, n, i)

def heapify(arr, n, k):
    global cnt
    lo, hi = 2*k, 2*k+1
    if hi <= n:
        idx = lo if arr[lo] < arr[hi] else hi
    elif lo <= n:
        idx = lo
    else:
        return
    
    if arr[idx] < arr[k]:
        arr[idx], arr[k] = arr[k], arr[idx]
        cnt += 1
        if cnt == K:
            print(*arr[1:])
            exit()
        heapify(arr, n, idx)

N, K = map(int, input().split())
A = [-1] + list(map(int, input().split()))
cnt = 0
build_min_heap(A, N)
for i in range(N, 1, -1):
    A[1], A[i] = A[i], A[1]
    cnt += 1
    if cnt == K:
        print(*A[1:])
        exit()
    heapify(A, i-1, 1)
print(-1)