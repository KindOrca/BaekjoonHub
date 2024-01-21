import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def QuickSort(arr, lo, hi):
    if lo >= hi: return
    pivot = partition(arr, lo, hi)
    QuickSort(arr, lo, pivot-1)
    QuickSort(arr, pivot+1, hi)

def partition(arr, lo, hi):
    pivot = arr[lo]
    i, j = lo, hi
    while i < j:
        while pivot < arr[j]: j -= 1
        while i < j and pivot >= arr[i]: i += 1
        arr[i], arr[j] = arr[j], arr[i]
        if arr[i] == B[i] and arr == B:
            print(1)
            exit()
    if lo != i:
        arr[lo], arr[i] = arr[i], arr[lo]
        if arr[i] == B[i] and arr == B:
            print(1)
            exit()
    return i

N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
if A == B: print(1)
else:
    QuickSort(A, 0, N-1)
    print(0)