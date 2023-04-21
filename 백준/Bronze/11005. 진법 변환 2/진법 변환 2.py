import sys, string
input = sys.stdin.readline
N, B = map(int, input().split())
tmp = string.digits + string.ascii_uppercase

def convert(N, base):
    q, r = divmod(N, base)
    if q == 0: 
        return tmp[r]
    else:
        return convert(q, base) + tmp[r]
    
print(convert(N, B))