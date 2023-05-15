import sys
input = sys.stdin.readline

N = int(input())
arr = []
dif = set()
for _ in range(N):
    arr.append(int(input()))
for i in range(1, N):
    dif.add(arr[i]-arr[i-1])
dif = list(dif)

def GCD(a, b):
    if a%b == 0: return b
    return GCD(b, a%b)

if len(dif) == 1:
    print(0)
else:
    gcd = GCD(dif[0], dif[1])
    for i in range(2, len(dif)):
        gcd = GCD(gcd, dif[i])
    print((arr[N-1]-arr[0])//gcd-N+1)