import sys
input = sys.stdin.readline
S = input().rstrip()
cnt = 0
for i in range(1, len(S)):
    if S[i] != S[i-1]: cnt += 1
print(cnt//2+1 if cnt%2 else cnt//2)