from collections import deque
que = deque()
ex = input()
L = len(ex)
i = 0
ans = ''

def postfix(n):
    i = n
    exp = ''
    tmp = deque()
    while True:
        if ex[i] not in ['+','-','*','/','(',')']:
            exp += ex[i]
        elif ex[i] in ['+','-']:
            while tmp:
                exp += tmp.pop()
            tmp.append(ex[i])
        elif ex[i] in ['*','/']:
            if tmp and tmp[-1] in ['*','/']:
                while tmp and tmp[-1] in ['*','/']:
                    exp += tmp.pop()
            tmp.append(ex[i])
        elif ex[i] == ')':
            while tmp: exp += tmp.pop() 
            return exp, i
        elif ex[i] == '(':
            inner, i = postfix(i+1)
            exp += inner
        i += 1

while i < L:
    if ex[i] not in ['+','-','*','/','(',')']:
        ans += ex[i]
    elif ex[i] in ['+','-']:
        while que:
            ans += que.pop()
        que.append(ex[i])
    elif ex[i] in ['*','/']:
        if que and que[-1] in ['*','/']:
            while que and que[-1] in ['*','/']:
                ans += que.pop()
        que.append(ex[i])
    elif ex[i] == '(':
        inner, i = postfix(i+1)
        ans += inner
    i += 1

while que: ans += que.pop()
print(ans)