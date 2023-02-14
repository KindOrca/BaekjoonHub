import sys
from collections import defaultdict
input = sys.stdin.readline
Size = int(input())
m, n = map(int, input().split())
A = [int(input()) for _ in range(m)]
B = [int(input()) for _ in range(n)]
ASum = [0] * (m+1)
BSum = [0] * (n+1)
total_Sum_A = sum(A)
total_Sum_B = sum(B)
for i in range(1, m+1):
    ASum[i] = ASum[i-1] + A[i-1]
for i in range(1, n+1):
    BSum[i] = BSum[i-1] + B[i-1]

dicA = defaultdict(int)
dicB = defaultdict(int)
for i in range(1, m+1):
    for j in range(i):
        dicA[ASum[i]-ASum[j]] += 1
        if j != 0 and i != m:
            dicA[total_Sum_A-(ASum[i]-ASum[j])] += 1

for i in range(1, n+1):
    for j in range(i):
        dicB[BSum[i]-BSum[j]] += 1
        if j != 0 and i != n:
            dicB[total_Sum_B-(BSum[i]-BSum[j])] += 1

dicA[0] = dicB[0] = 1
cnt = 0
for key, val in dicA.items():
    cnt += (val * dicB[Size-key])

print(cnt)