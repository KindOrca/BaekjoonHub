from collections import Counter

input()
arr = list(map(int, input().split()))
N = int(input())
counter = Counter(arr)
print(counter[N])