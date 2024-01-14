A, B = input().split()
La, Lb = len(A), len(B)
ans, temp = 51, 0
for i in range(Lb-La+1):
    for j in range(La):
        if A[j] != B[i+j]:
            temp += 1
    ans = min(ans, temp)
    temp = 0
print(ans)