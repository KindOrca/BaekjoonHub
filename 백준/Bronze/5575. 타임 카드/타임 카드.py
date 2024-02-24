A = list(map(int, input().split()))
B = list(map(int, input().split()))
C = list(map(int, input().split()))

def calculate(a):
    st = a[0]*3600+a[1]*60+a[2]
    en = a[3]*3600+a[4]*60+a[5]
    t = en - st
    return [t//3600,(t%3600)//60, t%60]

print(*calculate(A))
print(*calculate(B))
print(*calculate(C))