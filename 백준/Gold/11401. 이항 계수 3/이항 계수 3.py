N, K = map(int, input().split())
P = 1000000007

def find(n, i):
    if i == 0: return 1
    tmp = find(n, i//2)
    if i % 2 == 1:
        return tmp * tmp * n % P
    return tmp * tmp % P

def factorial(n):
    ret = 1
    while n > 1:
        ret = (ret*n) % P
        n -= 1
    return ret

numer = factorial(N)
denom = factorial(K) * factorial(N-K) % P
print(numer * find(denom, P-2) % P)