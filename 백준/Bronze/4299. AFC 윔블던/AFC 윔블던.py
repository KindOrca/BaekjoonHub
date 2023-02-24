N, M = map(int, input().split())
A = (N + M)/2
B = (N - M)/2
if N < M: print(-1)
elif A != int(A) or B != int(B): print(-1)
else: print(int(A), int(B))