import sys
input = sys.stdin.readline
X, Y, check = 0, 0, True
ans = ""
for _ in range(int(input())):
    if input().strip() == 'D':
        X += 1
    else:
        Y += 1
    if check and abs(X-Y) == 2:
        ans = f"{X}:{Y}"
        check = False
if check: print(f"{X}:{Y}")
else: print(ans)