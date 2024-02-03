A, B = map(int, input().split())
a1, a2 = (A-1)//4, A%4 if A%4 else 4
b1, b2 = (B-1)//4, B%4 if B%4 else 4
print(abs(a1-b1) + abs(a2-b2))