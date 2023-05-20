M = int(input())
N = int(input())
sum, min = 0, 0
for i in range(N, M-1, -1):
    n = i**(1/2)
    if int(n) == n:
        sum += i
        min = i
if sum:
    print(sum)
    print(min)
else:
    print(-1)