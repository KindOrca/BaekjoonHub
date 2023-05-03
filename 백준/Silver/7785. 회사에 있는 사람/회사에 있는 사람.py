import sys
from collections import defaultdict
input = sys.stdin.readline

N = int(input())
dic = defaultdict()
for _ in range(N):
    name, cg = input().split()
    if cg == 'enter':
        dic[name] = 1
    else:
        dic[name] = 0
ans = []
for n, v in dic.items():
    if v: ans.append(n)

ans.sort(reverse=True)
for a in ans:
    print(a)