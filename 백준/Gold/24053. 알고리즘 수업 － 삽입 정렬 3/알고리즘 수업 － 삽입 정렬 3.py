import sys
input = sys.stdin.readline

def InsertionSort():
    for i in range(1, N):
        loc = i
        newItem = A[i]
        while loc > 0 and A[loc-1] > newItem:
            A[loc] = A[loc-1]
            if A[loc] == B[loc] and A == B:
                return 1
            loc -= 1
        A[loc] = newItem
        if A[loc] == B[loc] and A == B:
            return 1
    return 0

N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
print(InsertionSort())