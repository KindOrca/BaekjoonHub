import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
end = N - 1
ans = 1 if A==B else 0
while end:
    last_swapped = 0
    for i in range(end):
        if A[i] > A[i+1]:
            A[i], A[i+1] = A[i+1], A[i]
            if A[i+1] == B[i+1]:
                if A == B:
                    ans = 1
                    break
            last_swapped = i
    end = last_swapped
print(ans)