N = int(input())
A, B, C = map(int, input().split())
ans = 0
for i in [A,B,C]:
    ans += N if i >= N else i
print(ans)