import sys
input = sys.stdin.readline
while True:
    n = int(input())
    if n == -1: break
    divisor = []
    for i in range(1, n):
        if n % i == 0:
            divisor.append(i)
    if sum(divisor) == n:
        print(n,'= 1', end='')
        for i in divisor[1:]:
            print(f' + {i}', end='')
        print()
    else:
        print(f'{n} is NOT perfect.')