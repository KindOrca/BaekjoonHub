import sys
input = sys.stdin.readline
stack = []
word = input().rstrip()
bomb = input().rstrip()
bo_len = len(bomb)
ans = ''
for i in range(len(word)):
    stack.append(word[i])
    if ''.join(stack[-bo_len:]) == bomb:
        for _ in range(bo_len):
            stack.pop()

ans = ''.join(stack)
ans = ans if ans else 'FRULA'
print(ans)