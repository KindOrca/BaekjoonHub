import sys
from collections import defaultdict
input = sys.stdin.readline
dic = defaultdict(int)

N, M = map(int, input().split())
for _ in range(N):
    word = input().rstrip()
    if len(word) >= M:
        dic[word] += 1

arr = []
for key, val in dic.items():
    arr.append((val, len(key), key))

arr.sort(key=lambda x : (-x[0],-x[1],x[2]))

for _, _, let in arr:
    print(let)