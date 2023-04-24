import sys
input = sys.stdin.readline
while True:
    tri = sorted(list(map(int, input().split())))
    A, B, C = tri[0], tri[1], tri[2]
    if A == 0: break
    if A + B <= C: print('Invalid')
    elif A == B and B == C: print('Equilateral')
    elif A == B or B == C: print('Isosceles')
    else: print('Scalene')