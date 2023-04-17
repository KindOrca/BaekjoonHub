import sys
input = sys.stdin.readline
words = [input().rstrip() for _ in range(5)]
ans = ''
for i in range(15):
    for word in words:
        if len(word) <= i: continue
        ans += word[i]
print(ans)