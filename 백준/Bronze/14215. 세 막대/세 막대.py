import sys
input = sys.stdin.readline
num = sorted(list(map(int, input().split())))
s_num = num[0] + num[1]
if s_num <= num[2]:
    print(s_num*2 - 1)
else:
    print(sum(num))