for _ in range(int(input())):
    N = int(input())
    for i in range(N//5):
        print('++++', end=' ')
    for i in range(N%5):
        print('|', end='')
    print()