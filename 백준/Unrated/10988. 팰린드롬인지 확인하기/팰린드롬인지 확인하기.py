import sys
input = sys.stdin.readline
word = input().rstrip()
if word == word[::-1]: print(1)
else: print(0)